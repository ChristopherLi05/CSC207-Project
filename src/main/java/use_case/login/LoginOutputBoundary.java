package use_case.login;

/**
 * The output boundary for the Login Use Case.
 */
public interface LoginOutputBoundary {
    /**
     * Prepares the Signup view for the Login Use Case.
     */
    void prepareSignupView();

    /**
     * Prepares the calculator view for the Login Use Case.
     * @param loginOutputData the output data
     */
    void prepareCalculatorView(LoginOutputData loginOutputData);

    /**
     * Prepares the failure view for the Login Use Case.
     * @param error the explanation of the failure
     */
    void prepareFailView(String error);
}
