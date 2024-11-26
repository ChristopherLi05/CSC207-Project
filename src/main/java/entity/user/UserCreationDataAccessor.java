package entity.user;

/**
 * User Creation Data Accessor for DAO objects to inherit
 */
public interface UserCreationDataAccessor {
    /**
     * Returns true if signed up, and false otherwise
     * @param username .
     * @param password .
     * @return whether signup was false or not
     */
    boolean signUp(String username, String password);

    /**
     * Returns session id after logging in, null if the login process failed
     * @param username .
     * @param password .
     * @return session id
     */
    String logIn(String username, String password);
}
