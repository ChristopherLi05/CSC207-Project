package use_case.signup;

import data_access.APIDataAccessor;
import interface_adapter.signup.SignupPresenter;

/**
 * The Signup Interactor.
 */
public class SignupInteractor implements SignupInputBoundary {
    private final APIDataAccessor dataAccessor;
    private final SignupPresenter userPresenter;

    public SignupInteractor(APIDataAccessor dataAccessor, SignupPresenter userPresenter) {
        this.dataAccessor = dataAccessor;
        this.userPresenter = userPresenter;

    }

    @Override
    public void execute(SignupInputData signupInputData) {
        dataAccessor.signUp(signupInputData.getUsername(), signupInputData.getPassword());
    }

    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }
}