package entity.user;

import entity.user.user_type.IUser;

/**
 * Generic user manager to handle user management
 */
public interface IUserManager {
    /**
     * Gets the currently logged-in user
     *
     * @return user
     */
    IUser getCurrentUser();

    /**
     * Sets the current logged-in user to an online account
     *
     * @param sessionId .
     * @param name      .
     * @param bestScore .
     */
    void setUserLoggedIn(String sessionId, String name, int bestScore);

    /**
     * Sets the current logged-in user to an offline account
     */
    void setUserGuest();

    /**
     * Sets the user factory needed for logging in
     *
     * @param factory .
     */
    void setUserFactory(IUserFactory factory);

    /**
     * Gets the user factory
     *
     * @return factory
     */
    IUserFactory getUserFactory();
}
