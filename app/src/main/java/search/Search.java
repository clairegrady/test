package search;

import application.Job;
import data.*;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {

    private static final int SEARCH_CUTOFF = 35;

    public static List<Job> searchJobs(String searchText, JobCategory category, Sal pay, Location location) {

        List<Job> jobs = DataStore.getDatastore().getJobs();

        return jobs.stream()
                .filter(ceilingGreaterThan(pay.getDollarValue()))
                .filter(hasLocation(location))
                .filter(hasCategory(category))
                .map(job -> new AbstractMap.SimpleEntry<>(
                        job,
                        searchText.equalsIgnoreCase("") ? 100 : FuzzySearch.weightedRatio(searchText, job.getDescription())
                ))
                .filter(e -> e.getValue() > SEARCH_CUTOFF)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(AbstractMap.SimpleEntry::getKey)
                .collect(Collectors.toList());
    }

    public static Predicate<Job> ceilingGreaterThan(int threshold) {
        System.out.println(threshold);
        return job -> job.getPayCeiling() >= threshold;
    }

    public static Predicate<Job> hasLocation(Location location) {
        return location == Location.ALL_LOCATIONS ? job -> true : hasKeyword(KeywordType.LOCATION,  location.toString());
    }

    public static Predicate<Job> hasCategory(JobCategory category) {
        return category == JobCategory.ALL_CATEGORIES ? job -> true : hasKeyword(KeywordType.CATEGORY,  category.toString());
    }

    public static Predicate<Job> hasKeyword(KeywordType keywordType, String value) {
        return job -> job.getJobKeywords().get(keywordType).stream().anyMatch(kw -> kw.equalsIgnoreCase(value));
    }

}