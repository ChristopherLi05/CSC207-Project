package use_case.puzzleRushHand;

/**
 * Output boundary interface for handling the presentation logic of Puzzle Rush hand data.
 * Provides methods to handle successful and unsuccessful scenarios during the game.
 */
public interface PuzzleRushHandOutputBoundary {

    /**
     * Prepares the view to display the successful generation of a Puzzle Rush hand.
     * This method is called when a new hand, along with related game data, is ready to be presented.
     *
     * @param outputData The output data containing the hand state, time left, and current score.
     */
    void prepareSuccessView(PuzzleRushHandOutputData outputData);

    /**
     * Prepares the view to display an error message when the hand generation or processing fails.
     * This method is called to provide feedback in the event of an error or unexpected situation.
     *
     * @param errorMessage A string describing the error or issue that occurred.
     */
    void prepareFailView(String errorMessage);
}