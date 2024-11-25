package use_case.puzzleRush;

import entity.calculator.Calculator;

public class PuzzleRushInteractor implements PuzzleRushInputBoundary {
    private final PuzzleRushOutputBoundary puzzleRushOutputBoundary;

    public PuzzleRushInteractor(PuzzleRushOutputBoundary puzzleRushOutputBoundary) {
        this.puzzleRushOutputBoundary = puzzleRushOutputBoundary;
    }

    @Override
    public void execute(PuzzleRushInputData data) {
        int score = Calculator.calculateScore(data.getHandState());

        if (score == data.getProposedScore()) {
            puzzleRushOutputBoundary.prepareSuccessView();
        } else {
            puzzleRushOutputBoundary.prepareFailView("Correct score: " + score);
        }
    }
}
