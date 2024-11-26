package entity.user.user_type;

/**
 * Generic User Interface
 */
public interface IUser {
    /**
     * Gets the username of the user
     *
     * @return username
     */
    String getUsername();

    /**
     * Gets the best score of the user
     *
     * @return best score
     */
    int getBestScore();

    /**
     * Sets the best score of the user
     *
     * @param score score
     */
    void setBestScore(int score);

    /**
     * Logged in state of the user (true if yes)
     *
     * @return login state
     */
    boolean isLoggedIn();

    /**
     * Gets the session id of the user
     *
     * @return session id
     */
    String getSessionId();
}
