package entity.user;

import entity.user.user_type.GuestUser;
import entity.user.user_type.IUser;
import entity.user.user_type.RemoteUser;

public class RemoteUserFactory implements IUserFactory {
    @Override
    public IUser create(String sessionId, String name, int bestScore) {
        return new RemoteUser(sessionId, name, bestScore);
    }

    @Override
    public IUser createGuest() {
        return new GuestUser();
    }
}
