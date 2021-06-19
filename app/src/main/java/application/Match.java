package application;

import data.DataStore;
import data.KeywordType;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Match extends Thread {

    public static Map<String, Integer> calculateMatchScores(Map<KeywordType, List<String>> jobKw) {
        return DataStore.getDatastore().getJobSeekers()
                .stream()
                .collect(
                        Collectors.toMap(
                                User::getUniqueId,
                                user -> calculateUserScore(jobKw, user.getSeekerKeywords())
                        )
                );
    }

    public static int calculateUserScore(Map<KeywordType, List<String>> jobKw, Map<KeywordType,
            List<String>> userKw) {
        return userKw.entrySet()
                .stream()
                .map(
                        kwList -> kwList
                                .getValue()
                                .stream()
                                .map(
                                        kw ->
                                                kwList.getKey().getMatchWeighting() *
                                                        jobKw.get(kwList.getKey()).size() > 0 ?
                                                        FuzzySearch.extractOne(kw,
                                                        jobKw.get(kwList.getKey())).getScore() : 0
                                )
                                .reduce(0, Integer::sum)
                )
                .reduce(0, Integer::sum);
    }

    public static int getMaxScore(Map<KeywordType, List<String>> kwMap) {
        int score = 0;
        for (Map.Entry<KeywordType, List<String>> e : kwMap.entrySet()) {
            score += e.getKey().getMatchWeighting() * e.getValue().size();
        }
        return score;

    }

    public static Map<String, Integer> matchAllJobSeekers(Map<KeywordType, List<String>> jobKw) {
        return normaliseMatches(getMaxScore(jobKw), calculateMatchScores(jobKw));
    }

    public static Map<String, Integer> normaliseMatches(int maxScore, Map<String, Integer> matches) {
        for (Map.Entry<String, Integer> entry : matches.entrySet()) {
            entry.setValue(
                    normaliseSingleMatch(maxScore, entry.getValue())
            );
        }
        return matches;
    }

    public static int normaliseSingleMatch(int maxScore, int score) {
        return score / maxScore;
    }

    public static void updateAllMatches() {
        for (Job job : DataStore.getDatastore().getJobs()) {
            updateJobMatches(job);
        }
    }

    public static void updateJobMatches(Job job) {
        job.setMatchingScore(matchAllJobSeekers(job.getJobKeywords()));
    }

    public static void updateUserMatches(JobSeeker js) {
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