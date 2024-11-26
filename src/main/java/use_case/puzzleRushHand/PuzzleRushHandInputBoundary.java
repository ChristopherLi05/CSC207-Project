package use_case.puzzleRushHand;

/**
 * Input boundary interface for handling Puzzle Rush hand-related logic.
 * Defines the method to execute operations involving time and score
 * for a single hand during a Puzzle Rush game.
 */
public interface PuzzleRushHandInputBoundary {

    /**
     * Executes the logic for handling the state of a Puzzle Rush hand.
     * This method should process the given time left and current score,
     * potentially updating the game state or triggering specific actions.
     *
     * @param timeLeft  The amount of time left (in seconds) for the current hand.
     * @param currScore The current score achieved in the game so far.
     */
    void execute(int timeLeft, int currScore);
}