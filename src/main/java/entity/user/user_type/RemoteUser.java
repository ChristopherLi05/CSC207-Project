package entity.user.user_type;

/**
 * Remote user for when interacting with api
 */
public class RemoteUser implements IUser {
    private final String username;
    private int bestScore;
    private final String sessionId;

    public RemoteUser(String sessionId, String username, int bestScore) {
        this.sessionId = sessionId;
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
        return sessionId;
    }
}
