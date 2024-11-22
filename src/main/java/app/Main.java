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
                .addTrainerView()
                .addPuzzleRushView()
                .addLeaderboardView()
                .addLoginUseCase()
                .addLeaderboardUseCase()
                .build();
    }
}
