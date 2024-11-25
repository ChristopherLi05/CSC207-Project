package use_case.puzzleRushHand;

import entity.calculator.IHandStateFactory;

public class PuzzleRushHandInteractor implements PuzzleRushHandInputBoundary {
    private final PuzzleRushHandOutputBoundary puzzleRushPresenter;
    private final IHandStateFactory handStateFactory;

    private String[] hands = {
            "1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1",
            "4s4s2p3p4p6p7p8p4m5m  4srs6s 3m 9m  ww ew 1",
            "8s8s3s4s7s8s9s7m8m9m  gdgdgd rp 9m  ww ew 1",
            "2s3s5s6s7s2p3p4p5p6p7p3m3m  5s5s5s 6s 4s  ww ew 1",
            "1s2s6s6s2p2p5m6m7m  6m7m8m 3s 9m  ww ew 1",
            "7s9srp5p5p6p7p6m6m6m9m9m9m   8s 9m  ww ew 1",
    };

    public PuzzleRushHandInteractor(PuzzleRushHandOutputBoundary puzzleRushHandOutputBoundary, IHandStateFactory handStateFactory) {
        this.puzzleRushPresenter = puzzleRushHandOutputBoundary;
        this.handStateFactory = handStateFactory;
    }

    @Override
    public void execute(int timeLeft, int currScore) {
        puzzleRushPresenter.prepareSuccessView(new PuzzleRushHandOutputData(handStateFactory.createHandState(hands[(int) (Math.random() * 6)]), timeLeft, currScore));
    }
}
