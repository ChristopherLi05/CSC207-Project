package use_case.signup;

import entity.user.IUserFactory;
import entity.user.user_type.IUser;
import data_access.APIDataAccessor;

/**
 * The Signup Interactor.
 */
public class SignupInteractor implements SignupInputBoundary {
    private final SignupUserDataAccessInterface userDataAccessObject;
    private final SignupOutputBoundary userPresenter;
    private final IUserFactory userFactory;
    private final APIDataAccessor apiDataAccessor;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            IUserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
        this.apiDataAccessor = new APIDataAccessor("");
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        apiDataAccessor.signUp(signupInputData.getUsername(), signupInputData.getPassword());
    }

    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }
}