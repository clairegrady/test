package application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class UserTest {

    private JobSeeker testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new JobSeeker(
                "test.email@email.com",
                "password123",
                "Test",
                "User",
                new ArrayList<>(),
                "Test user personal summary",
                "",
                "Post-Graduate",
                new HashMap<>()
        );
    }

    @Test
    public void getPersonalSummary() {
        assertEquals(testUser, "Test user personal summary");

    }

    @After
    public void tearDown() throws Exception {
    }
}