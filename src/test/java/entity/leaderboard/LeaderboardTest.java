package entity.leaderboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeaderboardTest {
    @Test
    void testEntry() {
        LeaderboardEntry entry = new LeaderboardEntry("hello", 0);
        Assertions.assertEquals("hello", entry.username());
        Assertions.assertEquals(0, entry.score());
    }
}
