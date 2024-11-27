package entity.user.user_type;

/**
 * Local User
 */
public class LocalUser implements IUser {
    private final String username;
    private int bestScore;

    public LocalUser(String username, int bestScore) {
        this.username = username;
        this.bestScore = bestScore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBestScore() {
        return bestScore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLoggedIn() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSessionId() {
        return username;
    }
}
