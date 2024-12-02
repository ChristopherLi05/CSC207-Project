package use_case.login;

import data_access.DataAccessor;
import entity.user.UserManager;

/**
 * The Login Interactor.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final UserManager userManager;
    private final DataAccessor dataAccessor;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(UserManager userManager, DataAccessor dataAccessor, LoginOutputBoundary loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.userManager = userManager;
        this.dataAccessor = dataAccessor;
    }

    /**
     * Executes the login use case, but as guest.
     */
    public void guestLogin() {
        LoginOutputData loginOutputData = new LoginOutputData(userManager.getUserFactory().createGuest(),
                false);
        loginPresenter.prepareCalculatorView(loginOutputData);
    }

    /**
     * Executes the login use case.
     *
     * @param loginInputData the input data
     */
    public void login(LoginInputData loginInputData) {
        final String username = loginInputData.getUsername();
        final String password = loginInputData.getPassword();
        final String result = dataAccessor.logIn(username, password);

        if (result == null) {
            loginPresenter.prepareFailView("Incorrect username or password");
        } else {
            int bestScore = dataAccessor.getBestScore(result);
            final LoginOutputData loginOutputData = new LoginOutputData(userManager.getUserFactory().create(result,
                    username, bestScore), false);
            loginPresenter.prepareCalculatorView(loginOutputData);
        }
    }

    /**
     * Takes user back to Signup View
     */
    public void signup() {
        loginPresenter.prepareSignupView();
    }
}
