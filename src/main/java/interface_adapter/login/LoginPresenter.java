package interface_adapter.login;

import interface_adapter.ViewManager;
import interface_adapter.signup.SignupViewState;
import interface_adapter.signup.SignupState;
import interface_adapter.calculator.CalculatorViewState;
import interface_adapter.calculator.CalculatorState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoginViewState loginViewState;
    private final SignupViewState signupViewState;
    private final CalculatorViewState calculatorViewState;
    private final ViewManager viewManager;

    public LoginPresenter(LoginViewState loginViewState,
                          SignupViewState signupViewState,
                          CalculatorViewState calculatorViewState,
                          ViewManager viewManager) {
        this.loginViewState = loginViewState;
        this.signupViewState = signupViewState;
        this.calculatorViewState = calculatorViewState;
        this.viewManager = viewManager;
    }

    @Override
    public void prepareSignupView() {
        this.signupViewState.setState(new SignupState());
        this.signupViewState.firePropertyChanged();

        this.viewManager.setView(signupViewState.getViewName());
    }

    @Override
    public void prepareCalculatorView(LoginOutputData loginOutputData) {
        this.calculatorViewState.setState(new CalculatorState());
        this.calculatorViewState.firePropertyChanged();

        this.viewManager.setView(calculatorViewState.getViewName());
    }

    @Override
    public void prepareFailView(String message) {
        final LoginState loginState = loginViewState.getState();
        loginState.setLoginError(message);
        loginViewState.firePropertyChanged();
    }
}
