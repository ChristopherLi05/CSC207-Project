package app;

public class Main {
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
