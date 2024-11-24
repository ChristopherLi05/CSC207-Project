package use_case.puzzleRush;

import entity.calculator.IHandStateFactory;

public class PuzzleRushInteractor implements PuzzleRushInputBoundary {
    private final PuzzleRushOutputBoundary puzzleRushPresenter;
    private final IHandStateFactory handStateFactory;

    public PuzzleRushInteractor(PuzzleRushOutputBoundary puzzleRushOutputBoundary, IHandStateFactory handStateFactory) {
        this.puzzleRushPresenter = puzzleRushOutputBoundary;
        this.handStateFactory = handStateFactory;
    }

    @Override
    public void execute() {
        puzzleRushPresenter.prepareSuccessView(new PuzzleRushOutputData(handStateFactory.createHandState("1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1")));
    }
}
