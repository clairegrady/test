package jss;

import application.*;
import data.DataStore;
import data.EmploymentType;
import data.KeywordType;

import java.util.*;

public class DummyData {

    public DummyData() {
        initUsers();
        initJobs();
    }

    public static void initJobs() {
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

        List<JobInteraction> jobListings = new ArrayList<>();
        jobListings.add(new JobListing(JobStatus.ACTIVE, job1, -1, -1));
        jobListings.add(new JobListing(JobStatus.ACTIVE, job2, -1, -1));
        jobListings.add(new JobListing(JobStatus.DRAFT, job3, -1, -1));
        jobListings.add(new JobListing(JobStatus.CLOSED, job4, -1, -1));

        Optional<User> recruiter = DataStore.getDatastore().getUserById("r");
        recruiter.ifPresent(user -> user.setJobInteractions(jobListings));

        List<JobInteraction> jobInteractions = new ArrayList<>();
        jobInteractions.add(new JobApplication(JobStatus.ACTIVE, job1, -1));
        jobInteractions.add(new JobApplication(JobStatus.ACTIVE, job2, -1));
        jobInteractions.add(new JobApplication(JobStatus.ACTIVE, job3, -1));

        jobInteractions.add(new JobInvitation(JobStatus.ACTIVE, job1, "Please come and interview for this awesome job"));


        Optional<User> js = DataStore.getDatastore().getUserById("j");
        js.ifPresent(user -> user.setJobInteractions(jobInteractions));

    }

    public static void initUsers() {
        JobSeeker testJobSeeker = new JobSeeker(
                "jobseeker@email.com",
                "password123",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                newKeywordMap()
        );
        testJobSeeker.addKeyword(KeywordType.SKILL, "Python");
        testJobSeeker.addKeyword(KeywordType.SKILL, "Java");
        testJobSeeker.addKeyword(KeywordType.SKILL, "Javascript");
        testJobSeeker.addKeyword(KeywordType.SKILL, "Go");
        testJobSeeker.addKeyword(KeywordType.SKILL, "Ruby");
        testJobSeeker.addKeyword(KeywordType.LOCATION, "Melbourne");

        User testRecruiter = new Recruiter(
                "r",
                "r",
                "Test",
                "User",
                new ArrayList<>(),
                "Matt's stellar recruitment - we only hire stars"
        );

        User testR = new Recruiter(
                "r",
                "r",
                "Test",
                "User",
                new ArrayList<>(),
                "Matt's stellar recruitment - we only hire stars"
        );


        JobSeeker testJS = new JobSeeker(
                "j",
                "j",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                newKeywordMap()
        );

        DataStore.getDatastore().updateUser(testJobSeeker);
        DataStore.getDatastore().updateUser(testRecruiter);

        DataStore.getDatastore().updateUser(testJS);
        DataStore.getDatastore().updateUser(testR);

    }

    public static JobSeeker addNewJobSeeker() {
        JobSeeker testJobSeeker = new JobSeeker(
                "jobseeker.two@email.com",
                "password123",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                newKeywordMap()
        );

        testJobSeeker.addKeyword(KeywordType.SKILL, "Python");
        testJobSeeker.addKeyword(KeywordType.SKILL, "Java");
        testJobSeeker.addKeyword(KeywordType.LOCATION, "Canberra");

        DataStore.getDatastore().updateUser(testJobSeeker);

        return testJobSeeker;
    }


    public static Map<KeywordType, List<String>> newKeywordMap() {
        Map<KeywordType, List<String>> kwMap = new HashMap<>();
        for (KeywordType type : KeywordType.values()) {
            kwMap.put(type, new ArrayList<>());
        }

        return kwMap;
    }

}
