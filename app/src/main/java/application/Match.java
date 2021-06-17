package application;

import data.DataStore;
import data.KeywordType;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Match extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                updateAllMatches();
                Thread.sleep(30 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> calculateMatchScores(Map<KeywordType, List<String>> jobKw) {
        return DataStore.getDatastore().getJobSeekers()
                .stream()
                .collect(
                        Collectors.toMap(
                                User::getUniqueId,
                                user -> calculateUserScore(jobKw, user.getSeekerKeywords())
                        )
                );
    }

    public int calculateUserScore(Map<KeywordType, List<String>> jobKw, Map<KeywordType,
            List<String>> userKw) {
        int score = 0;

        return userKw.entrySet()
                .stream()
                .map(
                        kwList -> kwList
                                .getValue()
                                .stream()
                                .map(
                                        kw -> kwList.getKey().getMatchWeighting() * FuzzySearch.extractOne(kw,
                                                jobKw.get(kwList.getKey())).getScore()
                                )
                                .reduce(0, Integer::sum)
                )
                .reduce(0, Integer::sum);
    }

    public int getMaxScore(Map<KeywordType, List<String>> kwMap) {
        int score = 0;
        for (Map.Entry<KeywordType, List<String>> e : kwMap.entrySet()) {
            score += e.getKey().getMatchWeighting() * e.getValue().size();
        }
        return score;

    }

    public Map<String, Integer> matchAllJobSeekers(Map<KeywordType, List<String>> jobKw) {
        return normaliseMatches(getMaxScore(jobKw), calculateMatchScores(jobKw));
    }

    public Map<String, Integer> normaliseMatches(int maxScore, Map<String, Integer> matches) {
        for (Map.Entry<String, Integer> entry : matches.entrySet()) {
            entry.setValue(
                    normaliseSingleMatch(maxScore, entry.getValue())
            );
        }
        return matches;
    }

    public int normaliseSingleMatch(int maxScore, int score) {
        return score / maxScore;
    }

    public void updateAllMatches() {
        for (Job job: DataStore.getDatastore().getJobs()) {
            updateJobMatches(job);
        }
    }

    public void updateJobMatches(Job job) {
        job.setMatchingScore(matchAllJobSeekers(job.getJobKeywords()));
    }

    public void updateUserMatches(JobSeeker js) {
        System.out.println(js);
        for (Job job : DataStore.getDatastore().getJobs()) {
            job.updateMatchingScore(
                    js.getUniqueId(),
                    normaliseSingleMatch(
                            getMaxScore(job.getJobKeywords()),
                            calculateUserScore(job.getJobKeywords(), js.getSeekerKeywords()
                            )
                    )
            );
        }
    }

}