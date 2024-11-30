package interface_adapter.signup;

import entity.user.UserManager;
import interface_adapter.ViewManager;
import interface_adapter.calculator.CalculatorViewState;
import interface_adapter.login.LoginViewState;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class SignupPresenter implements SignupOutputBoundary {
    private final ViewManager viewManager;

    private final UserManager userManager;

    private final CalculatorViewState calculatorViewState;
    private final LoginViewState loginViewState;

    /**
     * Constructs a new SignupPresenter with the necessary dependencies.
     *
     * @param viewManager the ViewManager to control the view transitions.
     * @param userManager the IUserManager to manage the current user.
     * @param calculatorViewState the CalculatorViewState for the calculator view.
     * @param loginViewState the LoginViewState for the login view.
     */
    public SignupPresenter(ViewManager viewManager,
                           UserManager userManager,
                           CalculatorViewState calculatorViewState,
                           LoginViewState loginViewState) {
        this.viewManager = viewManager;
        this.userManager = userManager;

        this.loginViewState = loginViewState;
        this.calculatorViewState = calculatorViewState;
    }

    /**
     * Prepares the success view after a successful signup.
     * If the signup use case failed, it prepares the fail view.
     *
     * @param outputData the SignupOutputData containing the result of the signup process.
     */
    @Override
    public void prepareSuccessView(SignupOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            prepareFailView("Error");
        } else {
            viewManager.setView(loginViewState.getViewName());
        }
    }

    /**
     * Prepares the fail view by printing the error message.
     *
     * @param errorMessage the error message to display.
     */
    @Override
    public void prepareFailView(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * Prepares the guest view by setting the user as a guest and transitioning to the calculator view.
     */
    @Override
    public void prepareGuestView() {
        userManager.setUserGuest();
        viewManager.setView(calculatorViewState.getViewName());
    }

    /**
     * Switches the view to the login view.
     */
    @Override
    public void switchToLoginView() {
        viewManager.setView(loginViewState.getViewName());
    }
}
