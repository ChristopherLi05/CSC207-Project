package use_case.puzzleRushHand;

import entity.calculator.IHandStateFactory;

public class PuzzleRushHandInteractor implements PuzzleRushHandInputBoundary {
    private final PuzzleRushHandOutputBoundary puzzleRushPresenter;
    private final IHandStateFactory handStateFactory;

    public PuzzleRushHandInteractor(PuzzleRushHandOutputBoundary puzzleRushHandOutputBoundary, IHandStateFactory handStateFactory) {
        this.puzzleRushPresenter = puzzleRushHandOutputBoundary;
        this.handStateFactory = handStateFactory;
    }

    @Override
    public void execute(int timeLeft, int currScore) {
        puzzleRushPresenter.prepareSuccessView(new PuzzleRushHandOutputData(handStateFactory.createHandState("1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1"), timeLeft, currScore));
    }
}
