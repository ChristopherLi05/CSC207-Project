package use_case.login;

import entity.user.user_type.IUser;

/**
 * Output Data for the Login Use Case
 */
public class LoginOutputData {
    private final IUser user;
    private final boolean useCaseFailed;

    public LoginOutputData(IUser user, boolean useCaseFailed) {
        this.user = user;
        this.useCaseFailed = useCaseFailed;
    }

    public IUser getUser() {
        return user;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
