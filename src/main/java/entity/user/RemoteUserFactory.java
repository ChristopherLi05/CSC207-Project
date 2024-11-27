package entity.user;

import entity.user.user_type.GuestUser;
import entity.user.user_type.IUser;
import entity.user.user_type.RemoteUser;

/**
 * Remote User Factory; Creates api users
 */
public class RemoteUserFactory implements IUserFactory {
    /**
     * {@inheritDoc}
     */
    @Override
    public IUser create(String sessionId, String name, int bestScore) {
        return new RemoteUser(sessionId, name, bestScore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IUser createGuest() {
        return new GuestUser();
    }
}
