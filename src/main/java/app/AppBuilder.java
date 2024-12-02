package app;

import data_access.APIDataAccessor;
import data_access.DummyDataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.user.LocalUserFactory;
import entity.user.RemoteUserFactory;
import entity.user.DefaultUserManager;
import interface_adapter.addTile.AddTileController;
import interface_adapter.addTile.AddTilePresenter;
import interface_adapter.calculator.CalculatorController;
import interface_adapter.calculator.CalculatorPresenter;
import interface_adapter.calculator.CalculatorState;
import interface_adapter.calculator.CalculatorViewState;
import interface_adapter.leaderboard.*;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewState;
import interface_adapter.puzzleRush.PuzzleRushController;
import interface_adapter.puzzleRush.PuzzleRushPresenter;
import interface_adapter.puzzleRushHand.PuzzleRushHandController;
import interface_adapter.puzzleRushHand.PuzzleRushHandPresenter;
import interface_adapter.puzzleRush.PuzzleRushState;
import interface_adapter.puzzleRush.PuzzleRushViewState;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewState;
import use_case.addTile.AddTileInteractor;
import use_case.addTile.AddTileOutputBoundary;
import use_case.calculator.CalculatorInteractor;
import use_case.calculator.CalculatorOutputBoundary;
import use_case.leaderboard.LeaderboardInteractor;
import use_case.leaderboard.LeaderboardOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.puzzleRush.PuzzleRushInteractor;
import use_case.puzzleRush.PuzzleRushOutputBoundary;
import use_case.puzzleRushHand.PuzzleRushHandInteractor;
import use_case.puzzleRushHand.PuzzleRushHandOutputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
public class AppBuilder {
    private final DefaultApp app;
    private BuildState buildState = BuildState.START;

    // Views
    private LoginView loginView;
    private LeaderboardView leaderboardView;
    private SignupView signupView;
    private CalculatorView calculatorView;
    private PuzzleRushView puzzleRushView;

    // ViewStates
    private LoginViewState loginViewState;
    private LeaderboardViewState leaderboardViewState;
    private SignupViewState signupViewState;
    private CalculatorViewState calculatorViewState;
    private PuzzleRushViewState puzzleRushViewState;

    public AppBuilder() {
        this(new DefaultApp("Mahjong Point Calculator"));
    }

    public AppBuilder(DefaultApp app) {
        this.app = app;
    }

    /**
     * Sets default user manager
     *
     * @return app
     */
    public AppBuilder setDefaultUserManager() {
        ensureState(BuildState.ATTR);
        this.app.setUserManager(new DefaultUserManager(this.app.getUserManager().getUserFactory()));
        return this;
    }

    /**
     * Sets dummy data accessor (for testing only)
     *
     * @return app
     */
    public AppBuilder setDummyDataAccessor() {
        ensureState(BuildState.ATTR);
        this.app.setDataAccessor(new DummyDataAccessor());
        return this;
    }

    /**
     * Sets in memory data accessor (default)
     *
     * @return app
     */
    public AppBuilder setInMemoryDataAccessor() {
        ensureState(BuildState.ATTR);
        this.app.setDataAccessor(new InMemoryDataAccessor());
        this.app.getUserManager().setUserFactory(new LocalUserFactory());
        return this;
    }

    /**
     * Sets api data accessor for api usage
     *
     * @return app
     */
    public AppBuilder setAPIDataAccessor() {
        ensureState(BuildState.ATTR);
        this.app.setDataAccessor(new APIDataAccessor("http://134.209.160.53:5000"));
        this.app.getUserManager().setUserFactory(new RemoteUserFactory());
        return this;
    }

    /**
     * Sets default hand state factory (default)
     *
     * @return app
     */
    public AppBuilder setDefaultHandStateFactory() {
        ensureState(BuildState.ATTR);
        this.app.setHandStateFactory(new HandStateFactory());
        return this;
    }

    /**
     * Adds signup view
     *
     * @return app
     */
    public AppBuilder addSignupView() {
        ensureState(BuildState.VIEW);
        signupViewState = new SignupViewState("SignupView", new SignupState());
        signupView = new SignupView(signupViewState, app.getViewManager());
        app.addPanel(signupView);
        return this;
    }

    /**
     * Adds login view
     *
     * @return app
     */
    public AppBuilder addLoginView() {
        ensureState(BuildState.VIEW);
        loginViewState = new LoginViewState("LoginView", new LoginState());
        loginView = new LoginView(loginViewState);
        app.addPanel(loginView);
        return this;
    }

    /**
     * Adds calculator view
     *
     * @return app
     */
    public AppBuilder addCalculatorView() {
        ensureState(BuildState.VIEW);
        calculatorViewState = new CalculatorViewState("CalculatorView", new CalculatorState());
        calculatorView = new CalculatorView(calculatorViewState, app.getViewManager(), app.getHandStateFactory());
        app.addPanel(calculatorView);
        return this;
    }

    /**
     * Adds puzzle rush view
     *
     * @return app
     */
    public AppBuilder addPuzzleRushView() {
        ensureState(BuildState.VIEW);
        puzzleRushViewState = new PuzzleRushViewState("PuzzleRushView", new PuzzleRushState(app.getHandStateFactory().createHandState("1p1p2p2p3p3p9p 4p4p4p4p 5p5p5p 9p 9m  ww ew 1")));
        puzzleRushView = new PuzzleRushView(puzzleRushViewState, app.getViewManager(), app);
        app.addPanel(puzzleRushView);
        return this;
    }

    /**
     * Adds leaderboard view
     *
     * @return app
     */
    public AppBuilder addLeaderboardView() {
        ensureState(BuildState.VIEW);
        leaderboardViewState = new LeaderboardViewState("LeaderboardView", new LeaderboardState());
        leaderboardView = new LeaderboardView(leaderboardViewState, app.getViewManager());
        app.addPanel(leaderboardView);
        return this;
    }

    /**
     * Adds signup use case
     *
     * @return app
     */
    public AppBuilder addSignupUseCase() {
        ensureState(BuildState.USE_CASE);
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(app.getViewManager(), app.getUserManager(), calculatorViewState, loginViewState);
        SignupInteractor signupInteractor = new SignupInteractor(signupOutputBoundary, app.getDataAccessor());

        SignupController signupController = new SignupController(signupInteractor);
        signupView.setSignupController(signupController);

        return this;
    }

    /**
     * Adds tile selector use case
     *
     * @return app
     */
    public AppBuilder addTileSelectorUseCase() {
        ensureState(BuildState.USE_CASE);
        AddTileOutputBoundary addTileOutputBoundary = new AddTilePresenter(calculatorViewState);
        AddTileInteractor addTileInteractor = new AddTileInteractor(addTileOutputBoundary);

        AddTileController addTileController = new AddTileController(addTileInteractor);
        calculatorView.setAddTileController(addTileController);

        return this;
    }

    /**
     * Adds calculator use case
     *
     * @return app
     */
    public AppBuilder addCalculatorUseCase() {
        ensureState(BuildState.USE_CASE);
        CalculatorOutputBoundary calculatorOutputBoundary = new CalculatorPresenter(calculatorViewState);
        CalculatorInteractor calculatorInteractor = new CalculatorInteractor(calculatorOutputBoundary, app.getHandStateFactory());

        CalculatorController calculatorController = new CalculatorController(calculatorInteractor);
        calculatorView.setCalculatorController(calculatorController);
        return this;
    }

    /**
     * Adds leaderboard use case
     *
     * @return app
     */
    public AppBuilder addLeaderboardUseCase() {
        ensureState(BuildState.USE_CASE);
        LeaderboardOutputBoundary leaderboardOutputBoundary = new LeaderboardPresenter(leaderboardViewState);
        LeaderboardInteractor leaderboardInteractor = new LeaderboardInteractor(leaderboardOutputBoundary, app.getDataAccessor());

        LeaderboardController leaderboardController = new LeaderboardController(new LeaderboardExecutor(), leaderboardInteractor);
        leaderboardView.setLeaderboardController(leaderboardController);
        return this;
    }

    /**
     * Adds login use case
     *
     * @return app
     */
    public AppBuilder addLoginUseCase() {
        ensureState(BuildState.USE_CASE);
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(app, loginViewState, signupViewState, calculatorViewState);
        LoginInteractor loginInteractor = new LoginInteractor(app, loginOutputBoundary);
        LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds puzzle rush use case
     *
     * @return app
     */
    public AppBuilder addPuzzleRushUseCase() {
        ensureState(BuildState.USE_CASE);
        PuzzleRushOutputBoundary puzzleRushHandOutputBoundary = new PuzzleRushPresenter(puzzleRushViewState);
        PuzzleRushInteractor puzzleRushInteractor = new PuzzleRushInteractor(puzzleRushHandOutputBoundary);

        PuzzleRushController controller = new PuzzleRushController(puzzleRushInteractor);
        puzzleRushView.setPuzzleRushController(controller);
        return this;
    }

    /**
     * Adds puzzle rush hand use case
     *
     * @return app
     */
    public AppBuilder addPuzzleRushHandUseCase() {
        ensureState(BuildState.USE_CASE);
        PuzzleRushHandOutputBoundary puzzleRushHandOutputBoundary = new PuzzleRushHandPresenter(puzzleRushViewState);
        PuzzleRushHandInteractor puzzleRushInteractor = new PuzzleRushHandInteractor(puzzleRushHandOutputBoundary, app.getHandStateFactory());

        PuzzleRushHandController controller = new PuzzleRushHandController(puzzleRushInteractor);
        puzzleRushView.setPuzzleRushHandController(controller);
        return this;
    }

    /**
     * Builds the app
     *
     * @return app
     */
    public App build() {
        ensureState(BuildState.BUILD);

        app.pack();
        app.setVisible(true);

        return app;
    }

    /**
     * Internal method to ensure that the app is being built in the correct order. It should be START -> ATTR -> VIEW -> USE_CASE -> BUILD
     * since use cases will depend on views
     */
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
