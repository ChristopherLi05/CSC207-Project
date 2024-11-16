package app;

import data_access.APIDataAccessor;
import data_access.DummyDataAccessor;
import data_access.InMemoryDataAccessor;
import entity.calculator.HandStateFactory;
import entity.user.LocalUserFactory;
import entity.user.RemoteUserFactory;
import entity.user.UserManager;

public class AppBuilder {
    private final App app;

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
        // TODO - do this
        return this;
    }

    public AppBuilder addLoginView() {
        // TODO - do this
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
        // TODO - do this
        return this;
    }

    public IApp build() {
        app.pack();
        app.setVisible(true);

        return app;
    }
}
