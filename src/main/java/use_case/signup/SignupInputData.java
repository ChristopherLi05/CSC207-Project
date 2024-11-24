package use_case.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {
    private final boolean guest;
    private final String username;
    private final String password;
    private final String repeatPassword;

    public SignupInputData(String username, String password, String repeatPassword) {
        this.guest = false;
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public SignupInputData() {
        this.guest = true;
        this.username = null;
        this.password = null;
        this.repeatPassword = null;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public boolean isGuest() {
        return guest;
    }
}