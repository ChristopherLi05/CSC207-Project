package app;

import data_access.APIDataAccessor;
import data_access.DummyDataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.user.LocalUserFactory;
import entity.user.RemoteUserFactory;
import entity.user.UserManager;
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
import use_case.leaderboard.LeaderboardInteractor;
import use_case.leaderboard.LeaderboardOutputBoundary;
import view.LoginView;
import view.LeaderboardView;
import view.SignupView;

public class AppBuilder {
    private final App app;

    // Views
    private LoginView loginView;
    private LeaderboardView leaderboardView;
    private SignupView signupView;

    // ViewStates
    private LoginViewState loginViewState;
    private LeaderboardViewState leaderboardViewState;
    private SignupViewState signupViewState;

    public AppBuilder() {
        this(new App("Mahjong Point Calculator"));
    }

    public AppBuilder(App app) {
        this.app = app;
    }

    // Not Necessary - set by default
    public AppBuilder setDefaultUserManager() {
        this.app.setUserManager(new UserManager(this.app.getUserManager().getUserFactory()));
        return this;
    }

    public AppBuilder setDummyDataAccessor() {
        this.app.setDataAccessor(new DummyDataAccessor());
        return this;
    }

    // Not Necessary - set by default
    public AppBuilder setInMemoryDataAccessor() {
        this.app.setDataAccessor(new InMemoryDataAccessor());
        this.app.getUserManager().setUserFactory(new LocalUserFactory());
        return this;
    }

    public AppBuilder setAPIDataAccessor() {
        this.app.setDataAccessor(new APIDataAccessor("http://134.209.160.53:5000"));
        this.app.getUserManager().setUserFactory(new RemoteUserFactory());
        return this;
    }

    // Not Necessary - set by default
    public AppBuilder setDefaultHandStateFactory() {
        this.app.setHandStateFactory(new HandStateFactory());
        return this;
    }

    public AppBuilder addSignupView() {
        signupViewState = new SignupViewState("LeaderboardView", new SignupState());
        signupViewState.setState(new SignupState());

        signupView = new SignupView(signupViewState, app.getViewManager());
        app.addPanel(signupView);
        return this;
    }

    public AppBuilder addLoginView() {
        loginViewState = new LoginViewState("LoginView", new LoginState());
//      // loginViewState.setState(new LoginState());

        loginView = new LoginView(loginViewState);
        app.addPanel(loginView);
        return this;
    }

    public AppBuilder addCalculatorView() {
        // TODO - do this
        return this;
    }

    public AppBuilder addTrainerView() {
        // TODO - do this
        return this;
    }

    public AppBuilder addPuzzleRushView() {
        //TODO - do this
        return this;
    }

    public AppBuilder addLeaderboardView() {
        leaderboardViewState = new LeaderboardViewState("LeaderboardView", new LeaderboardState());
        leaderboardViewState.setState(new LeaderboardState());

        leaderboardView = new LeaderboardView(leaderboardViewState, app.getViewManager());
        app.addPanel(leaderboardView);
        return this;
    }

    public AppBuilder addLeaderboardUseCase() {
        LeaderboardOutputBoundary leaderboardOutputBoundary = new LeaderboardPresenter(leaderboardViewState);
        LeaderboardInteractor leaderboardInteractor = new LeaderboardInteractor(leaderboardOutputBoundary, app.getDataAccessor());

        LeaderboardController leaderboardController = new LeaderboardController(leaderboardInteractor, leaderboardViewState);
        leaderboardView.setLeaderboardController(leaderboardController);
        return this;
    }

    public IApp build() {
        app.pack();
        app.setVisible(true);

        return app;
    }
}
