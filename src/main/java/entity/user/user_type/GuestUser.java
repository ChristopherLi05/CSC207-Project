package entity.user.user_type;

/**
 * Guest User
 */
public class GuestUser implements IUser {
    private int bestScore;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUsername() {
        return "Guest";
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
    public void setBestScore(int score) {
        bestScore = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLoggedIn() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSessionId() {
        return "Guest";
    }
}
