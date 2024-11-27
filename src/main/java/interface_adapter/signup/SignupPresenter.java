package interface_adapter.signup;

import entity.user.IUserManager;
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

    private final IUserManager userManager;

    private final CalculatorViewState calculatorViewState;
    private final LoginViewState loginViewState;

    public SignupPresenter(ViewManager viewManager,
                           IUserManager userManager,
                           CalculatorViewState calculatorViewState,
                           LoginViewState loginViewState) {
        this.viewManager = viewManager;
        this.userManager = userManager;

        this.loginViewState = loginViewState;
        this.calculatorViewState = calculatorViewState;
    }

    @Override
    public void prepareSuccessView(SignupOutputData outputData) {
        if (outputData.isUseCaseFailed()) {
            prepareFailView("Error");
        } else {
            viewManager.setView(loginViewState.getViewName());
        }
    }

    @Override
    public void prepareFailView(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void prepareGuestView() {
        userManager.setUserGuest();
        viewManager.setView(calculatorViewState.getViewName());
    }

    @Override
    public void switchToLoginView() {
        viewManager.setView(loginViewState.getViewName());
    }
}
