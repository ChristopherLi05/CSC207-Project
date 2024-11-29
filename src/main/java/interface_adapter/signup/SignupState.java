package interface_adapter.signup;

/**
 * The state for the Signup View Model.
 */
public class SignupState {
    private String username = "";
    private String usernameError;
    private String passwordError;
    private String repeatPasswordError;

    /**
     * Gets the current username entered by the user.
     *
     * @return the current username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the error message for the username field.
     *
     * @return the error message for the username, or null if there is no error.
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the error message for the password field.
     *
     * @return the error message for the password, or null if there is no error.
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Gets the error message for the repeat password field.
     *
     * @return the error message for the repeat password, or null if there is no error.
     */
    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    /**
     * Sets the username value.
     *
     * @param username the new username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the error message for the username field.
     *
     * @param usernameError the error message for the username field.
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the error message for the password field.
     *
     * @param passwordError the error message for the password field.
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Sets the error message for the repeat password field.
     *
     * @param repeatPasswordError the error message for the repeat password field.
     */
    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }
}