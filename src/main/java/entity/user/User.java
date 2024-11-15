package entity.user;

public class User implements IUser {
    private final String username;
    private int bestScore;
    private final boolean loggedIn;

    /**
     * Only used for Guest Login
     */
    public User() {
        this("Guest", 0, false);
    }

    /**
     * Used for user login
     */
    public User(String username, int bestScore) {
        this(username, bestScore, true);
    }

    public User(String username, int bestScore, boolean loggedIn) {
        this.username = username;
        this.bestScore = bestScore;
        this.loggedIn = loggedIn;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getBestScore() {
        return bestScore;
    }

    @Override
    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
