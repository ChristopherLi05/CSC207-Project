package use_case.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {
    private final boolean guest;
    private final String username;
    private final String password;
    private final String repeatPassword;

    /**
     * Constructs a new SignupInputData object for a user who is signing up with
     * a username and password.
     *
     * @param username the username chosen by the user.
     * @param password the password chosen by the user.
     * @param repeatPassword the password repeated by the user for confirmation.
     */
    public SignupInputData(String username, String password, String repeatPassword) {
        this.guest = false;
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    /**
     * Constructs a new SignupInputData object for a guest user.
     * The guest user does not require a username, password, or repeat password.
     */
    public SignupInputData() {
        this.guest = true;
        this.username = null;
        this.password = null;
        this.repeatPassword = null;
    }

    /**
     * Returns the username entered by the user.
     *
     * @return the username as a string.
     */
    String getUsername() {
        return username;
    }

    /**
     * Returns the password entered by the user.
     *
     * @return the password as a string.
     */
    String getPassword() {
        return password;
    }

    /**
     * Returns the password entered by the user for confirmation.
     *
     * @return the repeated password as a string.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Checks whether the user is signing up as a guest.
     *
     * @return true if the user is a guest, false otherwise.
     */
    public boolean isGuest() {
        return guest;
    }
}