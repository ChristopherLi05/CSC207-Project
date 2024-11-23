package app;

import data_access.APIDataAccessor;
import data_access.DummyDataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.user.LocalUserFactory;
import entity.user.RemoteUserFactory;
import entity.user.UserManager;
import interface_adapter.calculator.CalculatorController;
import interface_adapter.calculator.CalculatorPresenter;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewState;
import interface_adapter.leaderboard.LeaderboardController;
import interface_adapter.leaderboard.LeaderboardPresenter;
import interface_adapter.leaderboard.LeaderboardState;
import interface_adapter.leaderboard.LeaderboardViewState;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewState;
import interface_adapter.calculator.CalculatorViewState;
import use_case.calculator.CalculatorInteractor;
import use_case.calculator.CalculatorOutputBoundary;
import use_case.leaderboard.LeaderboardInteractor;
import use_case.leaderboard.LeaderboardOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import view.CalculatorView;
import view.LoginView;
import view.LeaderboardView;
import view.SignupView;

public class AppBuilder {
    private final App app;
    private BuildState buildState = BuildState.START;

    // Views
    private LoginView loginView;
    private LeaderboardView leaderboardView;
    private SignupView signupView;
    private CalculatorView calculatorView;

    // ViewStates
    private LoginViewState loginViewState;
    private LeaderboardViewState leaderboardViewState;
    private SignupViewState signupViewState;
    private CalculatorViewState calculatorViewState;

    public AppBuilder() {
        this(new App("Mahjong Point Calculator"));
    }

    public AppBuilder(App app) {
        this.app = app;
    }

    // Not Necessary - set by default
    public AppBuilder setDefaultUserManager() {
        ensureState(BuildState.ATTR);
        this.app.setUserManager(new UserManager(this.app.getUserManager().getUserFactory()));
        return this;
    }

    public AppBuilder setDummyDataAccessor() {
        ensureState(BuildState.ATTR);
        this.app.setDataAccessor(new DummyDataAccessor());
        return this;
    }

    // Not Necessary - set by default
    public AppBuilder setInMemoryDataAccessor() {
        ensureState(BuildState.ATTR);
        this.app.setDataAccessor(new InMemoryDataAccessor());
        this.app.getUserManager().setUserFactory(new LocalUserFactory());
        return this;
    }

    public AppBuilder setAPIDataAccessor() {
        ensureState(BuildState.ATTR);
        this.app.setDataAccessor(new APIDataAccessor("http://134.209.160.53:5000"));
        this.app.getUserManager().setUserFactory(new RemoteUserFactory());
        return this;
    }

    // Not Necessary - set by default
    public AppBuilder setDefaultHandStateFactory() {
        ensureState(BuildState.ATTR);
        this.app.setHandStateFactory(new HandStateFactory());
        return this;
    }

    public AppBuilder addSignupView() {
        ensureState(BuildState.VIEW);
        signupViewState = new SignupViewState("LeaderboardView", new SignupState());
        signupViewState.setState(new SignupState());

        signupView = new SignupView(signupViewState, app.getViewManager());
        app.addPanel(signupView);
        return this;
    }

    public AppBuilder addLoginView() {
        ensureState(BuildState.VIEW);
        loginViewState = new LoginViewState("LoginView", new LoginState());
        loginViewState.setState(new LoginState());

        loginView = new LoginView(loginViewState);
        app.addPanel(loginView);
        return this;
    }

    public AppBuilder addCalculatorView() {
        ensureState(BuildState.VIEW);
        // TODO - do this
        return this;
    }

    public AppBuilder addPuzzleRushView() {
        ensureState(BuildState.VIEW);
        //TODO - do this
        return this;
    }

    public AppBuilder addCalculatorUseCase() {
        ensureState(BuildState.USE_CASE);
        CalculatorOutputBoundary calculatorOutputBoundary = new CalculatorPresenter(calculatorViewState);
        CalculatorInteractor calculatorInteractor = new CalculatorInteractor(calculatorOutputBoundary);
        CalculatorController calculatorController = new CalculatorController(calculatorInteractor);
        calculatorView.setCalculatorController(calculatorController);
        return this;
    }

    public AppBuilder addLeaderboardView() {
        ensureState(BuildState.VIEW);
        leaderboardViewState = new LeaderboardViewState("LeaderboardView", new LeaderboardState());
        leaderboardViewState.setState(new LeaderboardState());

        leaderboardView = new LeaderboardView(leaderboardViewState, app.getViewManager());
        app.addPanel(leaderboardView);
        return this;
    }

    public AppBuilder addLeaderboardUseCase() {
        ensureState(BuildState.USE_CASE);
        LeaderboardOutputBoundary leaderboardOutputBoundary = new LeaderboardPresenter(leaderboardViewState);
        LeaderboardInteractor leaderboardInteractor = new LeaderboardInteractor(leaderboardOutputBoundary, app.getDataAccessor());

        LeaderboardController leaderboardController = new LeaderboardController(leaderboardInteractor, leaderboardViewState);
        leaderboardView.setLeaderboardController(leaderboardController);
        return this;
    }

    public AppBuilder addLoginUseCase() {
        ensureState(BuildState.USE_CASE);
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(app, loginViewState, signupViewState, calculatorViewState);
        LoginInteractor loginInteractor = new LoginInteractor(app, loginOutputBoundary);
        LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public IApp build() {
        ensureState(BuildState.BUILD);

        app.pack();
        app.setVisible(true);

        return app;
    }

    private void ensureState(BuildState state) {
        if (state.getState() < buildState.getState()) {
            throw new RuntimeException("You are building app in the wrong order");
        }

        buildState = state;
    }

    private enum BuildState {
        START(0),
        ATTR(1),
        VIEW(2),
        USE_CASE(3),
        BUILD(4);

        private final int state;

        BuildState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }
}
