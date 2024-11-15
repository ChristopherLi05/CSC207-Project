package entity.user.user_type;

public interface IUser {
    String getUsername();

    int getBestScore();

    void setBestScore(int score);

    boolean isLoggedIn();

    String getSessionId();
}
