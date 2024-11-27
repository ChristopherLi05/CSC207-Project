package entity.user;

import entity.user.user_type.IUser;

/**
 * Generic User Factory
 */
public interface IUserFactory {
    /**
     * Creates a logged in user
     *
     * @param sessionId .
     * @param name      .
     * @param bestScore .
     * @return new user
     */
    IUser create(String sessionId, String name, int bestScore);

    /**
     * Creates a guest user; these are not logged in
     *
     * @return guest user
     */
    IUser createGuest();
}
