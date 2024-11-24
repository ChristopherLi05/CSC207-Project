package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class SignupController {
    private final SignupInputBoundary userSignupUseCaseInteractor;

    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void signUp(String username, String password1, String password2) {
        userSignupUseCaseInteractor.execute(new SignupInputData(username, password1, password2));
    }

    public void guest() {
        userSignupUseCaseInteractor.execute(new SignupInputData());
    }

    public void switchToLoginView() {
        userSignupUseCaseInteractor.switchToLoginView();
    }
}