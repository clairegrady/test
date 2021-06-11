package search;

import application.Job;
import application.User;
import data.DataStore;
import data.KeywordType;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.BoundExtractedResult;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {

    private static final int SEARCH_CUTOFF = 35;

    public static List<Job> jobDescriptionSearch(String val) {
        return FuzzySearch
                .extractSorted(val, DataStore.getDatastore().getJobs(), Job::getDescription, SEARCH_CUTOFF)
                .stream()
                .map(BoundExtractedResult::getReferent)
                .collect(Collectors.toList());
    }

    public static List<Job> jobKeywordSearch(String val) {
        return DataStore.getDatastore().getJobs()
                .stream()
                .collect(
                        Collectors.toMap(
                                job -> job,
                                job -> topKeywordMatch(job, val)
                        )
                )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > SEARCH_CUTOFF)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Job> jobKeywordSearch(KeywordType type, String val) {
        return DataStore.getDatastore().getJobs()
                .stream()
                .collect(
                        Collectors.toMap(
                                job -> job,
                                job -> topKeywordMatch(job, type, val)
                        )
                )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > SEARCH_CUTOFF)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Job> jobSalarySearch(int min) {
        return DataStore
                .getDatastore().getJobs()
                .stream()
                .filter(floorGreaterThan(min))
                .sorted(Comparator.comparing(Job::getPayCeiling, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    public static List<User> getUsersForJob(Job job) {
        return job
                .getMatchingScore()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(user -> DataStore.getDatastore().getUserById(user.getKey()))
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

    public static Predicate<Job> floorGreaterThan(int num) {
        return job -> job.getPayFloor() >= num;
    }

    public static int topKeywordMatch(Job job, String val) {
        return FuzzySearch
                .extractOne(val, job.getAllKeywordsList())
                .getScore();
    }

    public static int topKeywordMatch(Job job, KeywordType type, String val) {
        return FuzzySearch
                .extractOne(val, job.getKeywordsListForType(type))
                .getScore();
    }

}