package entity.user;

import entity.user.user_type.IUser;

public interface IUserManager {
    IUser getCurrentUser();

    void setUserLoggedIn(String sessionId, String name, int bestScore);

    void setUserGuest();

    void setUserFactory(IUserFactory factory);

    IUserFactory getUserFactory();
}
