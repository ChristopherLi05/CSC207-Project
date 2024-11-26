package entity.user;

import entity.user.user_type.GuestUser;
import entity.user.user_type.IUser;
import entity.user.user_type.LocalUser;

/**
 * Local User Factory; Creates local users
 */
public class LocalUserFactory implements IUserFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public IUser create(String sessionId, String name, int bestScore) {
        return new LocalUser(name, bestScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUser createGuest() {
        return new GuestUser();
    }
}
