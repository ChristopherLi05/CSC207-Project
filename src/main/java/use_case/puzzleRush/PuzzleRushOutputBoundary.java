package use_case.puzzleRush;

/**
 * Output boundary interface for the Puzzle Rush use case.
 * Defines methods for preparing responses to be displayed to the user
 * based on the result of a Puzzle Rush attempt.
 */
public interface PuzzleRushOutputBoundary {

    /**
     * Prepares the view to display a success message when the proposed score is correct.
     * This method should be implemented to handle the successful outcome of the Puzzle Rush attempt.
     */
    void prepareSuccessView();

    /**
     * Prepares the view to display a failure message when the proposed score is incorrect.
     * This method should provide feedback, including the correct score or other relevant details.
     *
     * @param message A message describing why the attempt failed, typically including the correct score.
     */
    void prepareFailView(String message);
}