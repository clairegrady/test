package search;

import application.JobSeeker;
import application.User;
import data.DataStore;
import data.EmploymentType;
import application.Job;
import application.Keyword;
import data.KeywordType;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchData {

    public SearchData() {

        jobs();
        users();

    }

    public static JobSeeker getUser() {
        JobSeeker user1 = new JobSeeker(
                "user.the.third@email.com",
                "password123",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                newKeywordMap()
        );
        user1.addKeyword(KeywordType.SKILL, "Java");
        user1.addKeyword(KeywordType.LOCATION, "Canberra");

        return user1;
    }

    public static void users() {
        JobSeeker user1 = new JobSeeker(
                "test.email@email.com",
                "password123",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                newKeywordMap()
        );
        user1.addKeyword(KeywordType.SKILL, "Java");
        user1.addKeyword(KeywordType.SKILL, "Object Oriented Programming");
        user1.addKeyword(KeywordType.SKILL, "MVC");
        user1.addKeyword(KeywordType.SKILL, "Git");
        user1.addKeyword(KeywordType.LOCATION, "Canberra");

        JobSeeker user2 = new JobSeeker(
                "second.user@email.com",
                "password123",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                newKeywordMap()
        );
        user2.addKeyword(KeywordType.SKILL, "Splunk");
        user2.addKeyword(KeywordType.SKILL, "Python");
        user2.addKeyword(KeywordType.SKILL, "Docker");
        user2.addKeyword(KeywordType.LOCATION, "Melbourne");

        DataStore.getDatastore().updateUser(user1);
        DataStore.getDatastore().updateUser(user2);
    }

    public static void jobs() {
        Map<KeywordType, List<String>> kwMap = new HashMap<>();
        for (KeywordType type : KeywordType.values()) {
            kwMap.put(type, new ArrayList<>());
        }

        Job job1 = new Job(
                "Senior Software Developer",
                newKeywordMap(),
                EmploymentType.FULL_TIME,
                "Senior Software Developer",
                150000,
                120000,
                "MacroSoft",
                1,
                1,
                new HashMap<>()
        );
        job1.addKeyword(KeywordType.SKILL, "Java");
        job1.addKeyword(KeywordType.SKILL, "Object Oriented Programming");
        job1.addKeyword(KeywordType.SKILL, "MVC");
        job1.addKeyword(KeywordType.SKILL, "Git");
        job1.addKeyword(KeywordType.LOCATION, "Canberra");

        Job job2 = new Job(
                "Full Stack Engineer",
                newKeywordMap(),
                EmploymentType.FULL_TIME,
                "Full Stack Engineer",
                110000,
                100000,
                "Banana",
                1,
                1,
                new HashMap<>()
        );
        job2.addKeyword(KeywordType.SKILL, "Go");
        job2.addKeyword(KeywordType.SKILL, "Javascript");
        job2.addKeyword(KeywordType.SKILL, "React");
        job2.addKeyword(KeywordType.SKILL, "CSS");
        job2.addKeyword(KeywordType.SKILL, "Git");
        job2.addKeyword(KeywordType.LOCATION, "Melbourne");

        Job job3 = new Job(
                "Software Engineer",
                newKeywordMap(),
                EmploymentType.FULL_TIME,
                "Software Engineer",
                100000,
                80000,
                "MacroSoft",
                1,
                1,
                new HashMap<>()
        );
        job3.addKeyword(KeywordType.SKILL, "Python");
        job3.addKeyword(KeywordType.SKILL, "Java");
        job3.addKeyword(KeywordType.SKILL, "Javascript");
        job3.addKeyword(KeywordType.SKILL, "Go");
        job3.addKeyword(KeywordType.SKILL, "Ruby");
        job3.addKeyword(KeywordType.LOCATION, "Melbourne");

        Job job4 = new Job(
                "Developer",
                newKeywordMap(),
                EmploymentType.FULL_TIME,
                "Developer",
                80000,
                70000,
                "Hooli",
                1,
                1,
                new HashMap<>()
        );
        job4.addKeyword(KeywordType.SKILL, "Python");
        job4.addKeyword(KeywordType.SKILL, "Numpy");
        job4.addKeyword(KeywordType.SKILL, "Tkinter");
        job4.addKeyword(KeywordType.SKILL, "tensorflow");
        job4.addKeyword(KeywordType.SKILL, "Git");
        job4.addKeyword(KeywordType.LOCATION, "Sydney");

        DataStore.getDatastore().updateJob(job1);
        DataStore.getDatastore().updateJob(job2);
        DataStore.getDatastore().updateJob(job3);
        DataStore.getDatastore().updateJob(job4);
    }

    public static Map<KeywordType, List<String>> newKeywordMap() {
        Map<KeywordType, List<String>> kwMap = new HashMap<>();
        for (KeywordType type : KeywordType.values()) {
            kwMap.put(type, new ArrayList<>());
        }

        return kwMap;
    }

}
