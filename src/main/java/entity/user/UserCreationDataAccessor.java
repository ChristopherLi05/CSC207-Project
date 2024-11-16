package entity.user;

public interface UserCreationDataAccessor {
    // Returns true if sign up works, and false if it doesn't
    boolean signUp(String username, String password);

    // Returns session id if logged in, and null otherwise
    String logIn(String username, String password);
}
