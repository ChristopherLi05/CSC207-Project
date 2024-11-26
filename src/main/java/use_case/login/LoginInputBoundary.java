package use_case.login;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface LoginInputBoundary {
    /**
     * Executes the login use case, but as guest.
     */
    void guestLogin();

    /**
     * Executes the login use case.
     * @param loginInputData the input data
     */
    void login(LoginInputData loginInputData);

    /**
     * Takes user back to Signup View
     */
    void signup();
}
