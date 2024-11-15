package data_access;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InMemoryDataAccessorTest {
    @Test
    void testSignUp() {
        InMemoryDataAccessor dataAccessor = new InMemoryDataAccessor();

        Assertions.assertTrue(dataAccessor.signUp("hello", "world"));
        Assertions.assertFalse(dataAccessor.signUp("hello", "world"));
    }

    @Test
    void testLogIn() {
        InMemoryDataAccessor dataAccessor = new InMemoryDataAccessor();
        Assertions.assertTrue(dataAccessor.signUp("hello", "world"));
        Assertions.assertNotNull(dataAccessor.logIn("hello", "world"));
        Assertions.assertNull(dataAccessor.logIn("hello", "AAA"));
    }

    @Test
    void testTopTenLeaderboard() {
        InMemoryDataAccessor dataAccessor = new InMemoryDataAccessor();
        Assertions.assertEquals(dataAccessor.getTopTenLeaderboard().size(), 0);
        dataAccessor.updateScore("hello", 1);
        Assertions.assertEquals(dataAccessor.getTopTenLeaderboard().size(), 1);
    }

    @Test
    void testUpdateScore() {
        InMemoryDataAccessor dataAccessor = new InMemoryDataAccessor();
        Assertions.assertEquals(dataAccessor.getTopTenLeaderboard().size(), 0);
        dataAccessor.updateScore("hello", 5);
        Assertions.assertEquals(dataAccessor.getTopTenLeaderboard().size(), 1);
        Assertions.assertEquals(dataAccessor.getTopTenLeaderboard().get(0).username(), "hello");
        Assertions.assertEquals(dataAccessor.getTopTenLeaderboard().get(0).score(), 5);
    }
}
