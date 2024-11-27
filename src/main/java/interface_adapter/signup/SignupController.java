package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller for the Signup use case.
 */
public class SignupController {
    private final SignupInputBoundary userSignupUseCaseInteractor;

    /**
     * Constructs a new SignupController with the given SignupInputBoundary.
     *
     * @param userSignupUseCaseInteractor the SignupInputBoundary that represents the signup use case to be executed.
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the signup process for a user with the provided username and passwords.
     *
     * @param username the username entered by the user.
     * @param password1 the password entered by the user.
     * @param password2 the repeated password entered by the user.
     */
    public void signUp(String username, String password1, String password2) {
        userSignupUseCaseInteractor.execute(new SignupInputData(username, password1, password2));
    }

    /**
     * Executes the guest signup process (no username or password).
     */
    public void guest() {
        userSignupUseCaseInteractor.execute(new SignupInputData());
    }

    /**
     * Switches the view to the login screen.
     */
    public void switchToLoginView() {
        userSignupUseCaseInteractor.switchToLoginView();
    }
}