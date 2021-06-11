package search;

import application.Job;
import data.DataStore;
import data.KeywordType;
import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.util.*;
import java.util.stream.Collectors;

public class SearchTest {

    public static void main(String[] args) {

//        new SearchData();

        System.out.println("All Jobs");
        System.out.println(DataStore.getDatastore().getJobs());

        String skillKeyword = "Java";
        System.out.println("\nJobs with " + skillKeyword + " skill keyword:");
        List<Job> relevantJobs = Search.jobKeywordSearch(KeywordType.SKILL, skillKeyword);
        System.out.println(relevantJobs);

        String locationKeyword = "Melbourne";
        System.out.println("\nJobs with " + locationKeyword + " Keyword:");
        relevantJobs = Search.jobKeywordSearch(KeywordType.LOCATION, locationKeyword);
        System.out.println(relevantJobs);

        int salarySearch = 90000;
        System.out.println("\nJobs with salary over " + salarySearch + ":");
        relevantJobs = Search.jobSalarySearch(salarySearch);
        System.out.println(relevantJobs);

        String descriptionSearch = "Full Stack";
        System.out.println("\nJobs with relevance to '" + descriptionSearch + "':");
        List<Job> sortedJobs = Search.jobDescriptionSearch(descriptionSearch);
        System.out.println(sortedJobs);

        DataStore.getDatastore().saveUsers();
        DataStore.getDatastore().saveJobs();

    }
}
