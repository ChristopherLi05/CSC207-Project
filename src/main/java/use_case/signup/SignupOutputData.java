package use_case.signup;

/**
 * Output Data for the Signup Use Case.
 */
public class SignupOutputData {
    private final String username;

    private final boolean useCaseFailed;

    /**
     * Constructs a new SignupOutputData instance with the specified username and failure status.
     *
     * @param username the username of the user that attempted to sign up.
     * @param useCaseFailed a flag indicating whether the signup use case failed (true) or succeeded (false).
     */
    public SignupOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username of the user who attempted to sign up as a String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks if the signup use case failed.
     *
     * @return true if the signup use case failed, false otherwise.
     */
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}