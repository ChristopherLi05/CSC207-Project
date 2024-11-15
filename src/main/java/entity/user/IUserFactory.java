package entity.user;

import entity.user.user_type.IUser;

public interface IUserFactory {
    IUser create(String sessionId, String name, int bestScore);

    IUser createGuest();
}
