package use_case.puzzleRushHand;

import entity.calculator.IHandStateFactory;

/**
 * Interactor for handling Puzzle Rush hand-related logic.
 * Responsible for generating and providing a random hand, along with time and score data,
 * to the output boundary for presentation.
 */
public class PuzzleRushHandInteractor implements PuzzleRushHandInputBoundary {

    /** The output boundary responsible for presenting the Puzzle Rush hand data. */
    private final PuzzleRushHandOutputBoundary puzzleRushPresenter;

    /** Factory for creating hand states from string representations. */
    private final IHandStateFactory handStateFactory;

    /** Array of predefined Puzzle Rush hands represented as strings. */
    private final String[] hands = {
            "1s1s2s2s3s3s6s 4s4s4s4s 5s5s5s 6s 9m  ww ew 1",
            "4s4s2p3p4p6p7p8p4m5m  4srs6s 3m 9m  ww ew 1",
            "8s8s3s4s7s8s9s7m8m9m  gdgdgd rp 9m  ww ew 1",
            "2s3s5s6s7s2p3p4p5p6p7p3m3m  5s5s5s 6s 4s  ww ew 1",
            "1s2s6s6s2p2p5m6m7m  6m7m8m 3s 9m  ww ew 1",
            "7s9srp5p5p6p7p6m6m6m9m9m9m   8s 9m  ww ew 1",
    };

    /**
     * Constructs a new {@code PuzzleRushHandInteractor}.
     *
     * @param puzzleRushHandOutputBoundary The output boundary for presenting the generated hand data.
     * @param handStateFactory             Factory for creating hand state objects from string representations.
     */
    public PuzzleRushHandInteractor(PuzzleRushHandOutputBoundary puzzleRushHandOutputBoundary, IHandStateFactory handStateFactory) {
        this.puzzleRushPresenter = puzzleRushHandOutputBoundary;
        this.handStateFactory = handStateFactory;
    }

    /**
     * Executes the logic for generating a random Puzzle Rush hand and passing it,
     * along with the time left and current score, to the output boundary for presentation.
     *
     * @param timeLeft  The amount of time left (in seconds) for the current hand.
     * @param currScore The current score achieved in the game so far.
     */
    @Override
    public void execute(int timeLeft, int currScore) {
        // Generate a random hand from the predefined hands array.
        String randomHand = hands[(int) (Math.random() * hands.length)];

        // Create a hand state from the random hand string.
        var handState = handStateFactory.createHandState(randomHand);

        // Prepare the success view with the generated hand state, time left, and current score.
        puzzleRushPresenter.prepareSuccessView(new PuzzleRushHandOutputData(handState, timeLeft, currScore));
    }
}
