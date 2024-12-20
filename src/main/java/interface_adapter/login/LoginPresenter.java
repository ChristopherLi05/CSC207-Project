package interface_adapter.login;

import app.App;
import interface_adapter.signup.SignupViewState;
import interface_adapter.signup.SignupState;
import interface_adapter.calculator.CalculatorState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {
    private final LoginViewState loginViewState;
    private final App app;
    private final SignupViewState signupViewState;
    private final interface_adapter.calculator.CalculatorViewState calculatorViewState;

    public LoginPresenter(App app,
                          LoginViewState loginViewState,
                          SignupViewState signupViewState,
                          interface_adapter.calculator.CalculatorViewState calculatorViewState) {
        this.loginViewState = loginViewState;
        this.signupViewState = signupViewState;
        this.calculatorViewState = calculatorViewState;
        this.app = app;
    }

    @Override
    public void prepareSignupView() {
        this.signupViewState.setState(new SignupState());
        this.signupViewState.firePropertyChanged();

        this.app.getViewManager().setView(signupViewState.getViewName());
    }

    @Override
    public void prepareCalculatorView(LoginOutputData loginOutputData) {
        this.calculatorViewState.setState(new CalculatorState());
        this.calculatorViewState.firePropertyChanged();
        this.app.getUserManager().setUserLoggedIn(loginOutputData.getUser().getSessionId(), loginOutputData.getUser().getUsername(), loginOutputData.getUser().getBestScore());

        this.app.getViewManager().setView(calculatorViewState.getViewName());
    }

    @Override
    public void prepareFailView(String message) {
        final LoginState loginState = loginViewState.getState();
        loginState.setLoginError(message);
        loginViewState.firePropertyChanged();
    }
}
