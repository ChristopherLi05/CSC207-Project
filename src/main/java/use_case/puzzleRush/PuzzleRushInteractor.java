package use_case.puzzleRush;

import entity.calculator.Calculator;

/**
 * Interactor for the Puzzle Rush use case.
 * This class handles the logic for processing a Puzzle Rush attempt, validating the proposed score
 * against the actual calculated score, and delegating the output response to the presenter.
 */
public class PuzzleRushInteractor implements PuzzleRushInputBoundary {
    private final PuzzleRushOutputBoundary puzzleRushOutputBoundary;

    /**
     * Constructs a {@code PuzzleRushInteractor} with the specified output boundary.
     *
     * @param puzzleRushOutputBoundary The output boundary to handle the response of the interactor.
     */
    public PuzzleRushInteractor(PuzzleRushOutputBoundary puzzleRushOutputBoundary) {
        this.puzzleRushOutputBoundary = puzzleRushOutputBoundary;
    }

    /**
     * Executes the Puzzle Rush use case logic.
     * Validates the user's proposed score against the calculated score for the current hand state.
     * If the proposed score is correct, the success view is prepared; otherwise, a fail view is prepared
     * with the correct score as feedback.
     *
     * @param data The input data for the Puzzle Rush attempt, including the proposed score and the hand state.
     */
    @Override
    public void execute(PuzzleRushInputData data) {
        // Calculate the actual score based on the given hand state
        int score = Calculator.calculateScore(data.getHandState());

        // Check if the proposed score matches the actual score
        if (score == data.getProposedScore()) {
            // Inform the output boundary to prepare a success view
            puzzleRushOutputBoundary.prepareSuccessView();
        } else {
            // Inform the output boundary to prepare a fail view with feedback
            puzzleRushOutputBoundary.prepareFailView("Correct score: " + score);
        }
    }
}

