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
            "1s1m2m3m4m5m6m7m8m9mgdgdgd   1s 9m  ew ew 1",  // 1500
            "2p2p3p3p4p4p5p5p5p6m  5p6p7p 6m 9m  ew ew 1",  // 1500
            "1s1s1s2p3p4p5pwdwdwdgdgdgd   5p 6m 9m  ew ew 1", // 3000
            "1s1s1s2s2s2s3s3s3s4s5s6s7s   7s 6m 9m ew ew 1", // 18000
            "1m1m1m2m2m2m3m3m3ms7m  4m5m6m 7m 6m 9m ew ew 1" // 12000
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
