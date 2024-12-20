package use_case.calculator;

import entity.calculator.Calculator;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.List;

import static entity.calculator.mahjong.MahjongTile.EAST_WIND;

/**
 * Interactor for the Calculator use case.
 * This class handles the calculation of the score based on the given {@link HandState}.
 * It coordinates with the output boundary to present the result.
 */
public class CalculatorInteractor implements CalculatorInputBoundary {

    /** The output boundary for presenting the result of the calculation. */
    private final CalculatorOutputBoundary calculatorPresenter;
    private final IHandStateFactory handStateFactory;

    /**
     * Constructs a new {@code CalculatorInteractor} with the provided output boundary.
     *
     * @param calculatorOutputBoundary The output boundary to be used for presenting the result.
     */
    public CalculatorInteractor(CalculatorOutputBoundary calculatorOutputBoundary, IHandStateFactory handStateFactory) {
        this.calculatorPresenter = calculatorOutputBoundary;
        this.handStateFactory = handStateFactory;
    }

    /**
     * Executes the calculation logic to compute the score for the provided hand.
     * If the score is valid, it sends the result to the presenter. If the score is zero,
     * it prepares a failure view with an error message.
     *
     * @param input The {@link CalculatorInputData} representing the hand to be evaluated.
     */
    @Override
    public void execute(CalculatorInputData input) {
        // Calculate the score for the given hand
        List<MahjongTile> closedTiles = input.getClosedTiles();
        List<MahjongGroup> closedGroups = input.getClosedGroups();
        List<MahjongGroup> openGroups = input.getOpenGroups();
        MahjongTile winningTile = input.getWinningTile();

        HandState handstate = handStateFactory.createHandState(closedTiles, closedGroups, openGroups, winningTile, new ArrayList<>(), new ArrayList<>(), EAST_WIND, EAST_WIND, true, false, false, false, false, false, false, false, false);

        int score = Calculator.calculateScore(handstate);
        if (score > 0) {
            calculatorPresenter.prepareSuccessView("Score is ", new CalculatorOutputData(score));
        } else {
            calculatorPresenter.prepareFailView("This is not a valid hand");
        }
    }

    @Override
    public void reset() {
        calculatorPresenter.prepareSuccessView("Score is ", new CalculatorOutputData(0));
    }
}