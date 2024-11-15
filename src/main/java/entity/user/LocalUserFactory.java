package entity.user;

import entity.user.user_type.GuestUser;
import entity.user.user_type.IUser;
import entity.user.user_type.LocalUser;

public class LocalUserFactory implements IUserFactory {
    @Override
    public IUser create(String sessionId, String name, int bestScore) {
        return new LocalUser(name, bestScore);
    }

    @Override
    public IUser createGuest() {
        return new GuestUser();
    }
}
