package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addLoginView()
                .addSignupView()
                .addCalculatorView()
                .addLeaderboardView()
                .addPuzzleRushView()
                .addTrainerView()
                .addSignupUseCase()
                .addLoginUseCase()
                .addLogoutUseCase()
                .addCalculatorUseCase
                .addLeaderboardUseCase
                .addPuzzleRushUseCase
                .addTrainerUseCase
                .build();

        application.pack();
        application.setVisible(true);
    }
}
