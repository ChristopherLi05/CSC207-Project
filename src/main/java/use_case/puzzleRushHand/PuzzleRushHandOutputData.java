package use_case.puzzleRushHand;

import entity.calculator.HandState;

/**
 * Data transfer object (DTO) for Puzzle Rush hand output.
 * Encapsulates the data required to present a new Puzzle Rush hand, along with
 * the remaining time and current score in the game.
 */
public class PuzzleRushHandOutputData {

    /** The newly generated hand state for the current Puzzle Rush round. */
    private final HandState newHandState;

    /** The amount of time left (in seconds) for the current round. */
    private final int timeLeft;

    /** The current score achieved in the Puzzle Rush game so far. */
    private final int currScore;

    /**
     * Constructs a new {@code PuzzleRushHandOutputData} object.
     *
     * @param newHandState The new {@link HandState} generated for the current round.
     * @param timeLeft     The amount of time left (in seconds) for the current round.
     * @param currScore    The current score achieved in the Puzzle Rush game so far.
     */
    public PuzzleRushHandOutputData(HandState newHandState, int timeLeft, int currScore) {
        this.newHandState = newHandState;
        this.timeLeft = timeLeft;
        this.currScore = currScore;
    }

    /**
     * Returns the newly generated hand state for the current round.
     *
     * @return A {@link HandState} object representing the new hand.
     */
    public HandState getNewHandState() {
        return newHandState;
    }

    /**
     * Returns the amount of time left for the current round.
     *
     * @return The remaining time in seconds.
     */
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * Returns the current score achieved so far in the Puzzle Rush game.
     *
     * @return The current score as an integer.
     */
    public int getCurrScore() {
        return currScore;
    }
}
