package app;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        appBuilder
//                .setInMemoryDataAccessor()
                .setAPIDataAccessor()
                .addSignupView()
                .addLoginView()
                .addCalculatorView()
                .addPuzzleRushView()
                .addLeaderboardView()
                .addTileSelectorUseCase()
                .addSignupUseCase()
                .addLoginUseCase()
                .addLeaderboardUseCase()
                .addCalculatorUseCase()
                .addPuzzleRushHandUseCase()
                .addPuzzleRushUseCase()
                .build();
    }
}
