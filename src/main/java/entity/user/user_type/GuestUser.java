package entity.user.user_type;

public class GuestUser implements IUser {
    private int bestScore;

    @Override
    public String getUsername() {
        return "Guest";
    }

    @Override
    public int getBestScore() {
        return bestScore;
    }

    @Override
    public void setBestScore(int score) {
        bestScore = score;
    }

    @Override
    public boolean isLoggedIn() {
        return false;
    }

    @Override
    public String getSessionId() {
        return "Guest";
    }
}