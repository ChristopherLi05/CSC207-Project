package entity.user;

import entity.user.user_type.GuestUser;
import entity.user.user_type.LocalUser;

public class UserFactory implements IUserFactory {
    @Override
    public IUser create(String name, int bestScore) {
        return new LocalUser(name, bestScore);
    }

    @Override
    public IUser createGuest() {
        return new GuestUser();
    }
}
