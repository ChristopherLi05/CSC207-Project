package entity.user.user_type;

public class RemoteUser implements IUser {
    private final String username;
    private int bestScore;
    private final String sessionId;

    public RemoteUser(String sessionId, String username, int bestScore) {
        this.sessionId = sessionId;
        this.username = username;
        this.bestScore = bestScore;
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
        return true;
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }
}
