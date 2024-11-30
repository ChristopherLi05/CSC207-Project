package interface_adapter.puzzleRushHand;

import use_case.puzzleRushHand.PuzzleRushHandInputBoundary;

/**
 * The {@code PuzzleRushHandController} class handles the interaction between the view layer and
 * the use case for managing the hand state in Puzzle Rush.
 * It invokes the necessary actions to update the hand state by interacting with the input boundary.
 */
public class PuzzleRushHandController {

    private final PuzzleRushHandInputBoundary puzzleRushHandInputBoundary;

    /**
     * Constructs a new {@code PuzzleRushHandController} with the specified input boundary.
     *
     * @param puzzleRushHandInputBoundary the input boundary for handling Puzzle Rush hand-related logic
     */
    public PuzzleRushHandController(PuzzleRushHandInputBoundary puzzleRushHandInputBoundary) {
        this.puzzleRushHandInputBoundary = puzzleRushHandInputBoundary;
    }

    /**
     * Executes the process of updating the hand state by invoking the input boundary with the specified
     * time left and current score.
     *
     * @param timeLeft the remaining time for the Puzzle Rush game
     * @param currScore the current score of the player in the game
     */
    public void execute(int timeLeft, int currScore) {
        puzzleRushHandInputBoundary.execute(timeLeft, currScore);
    }
}
