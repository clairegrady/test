package search;

import application.Job;
import application.JobSeeker;
import application.Match;
import data.DataStore;
import data.KeywordType;
import jss.DummyData;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.junit.runner.Runner;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class SearchTest {

    public static void main(String[] args) {

//        new DummyData();


        Match m = new Match();
        m.updateAllMatches();

        System.out.println("All Jobs");
        System.out.println(DataStore.getDatastore().getJobs());

//        String skillKeyword = "Java";
//        System.out.println("\nJobs with " + skillKeyword + " skill keyword:");
//        List<Job> relevantJobs = Search.jobKeywordSearch(skillKeyword, KeywordType.SKILL);
//        System.out.println(relevantJobs);

        // TODO: something going on with this and not being saved to file. need to investigate.
        JobSeeker js = DummyData.addNewJobSeeker();
        m.updateUserMatches(js);
//        String locationKeyword = "Melbourne";
//        System.out.println("\nJobs with " + locationKeyword + " Keyword:");
//        relevantJobs = Search.jobKeywordSearch(locationKeyword, KeywordType.LOCATION);
//        System.out.println(relevantJobs);
//
//        int salarySearch = 90000;
//        System.out.println("\nJobs with salary over " + salarySearch + ":");
//        relevantJobs = Search.jobSalarySearch(salarySearch);
//        System.out.println(relevantJobs);
//
//        String descriptionSearch = "Full Stack";
//        System.out.println("\nJobs with relevance to '" + descriptionSearch + "':");
//        List<Job> sortedJobs = Search.jobDescriptionSearch(descriptionSearch);
//        System.out.println(sortedJobs);
//
        DataStore.getDatastore().saveUsers();
        DataStore.getDatastore().saveJobs();

    }
}
