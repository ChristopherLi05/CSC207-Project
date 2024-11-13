package entity.user;

public interface IUser {
    String getUsername();

    int getBestScore();

    void setBestScore(int score);

    boolean isLoggedIn();
}
