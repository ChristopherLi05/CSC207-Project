package interface_adapter.calculator;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import use_case.calculator.CalculatorInputBoundary;
import use_case.calculator.CalculatorInputData;
import use_case.login.LoginInputData;

import java.util.ArrayList;
import java.util.List;

import static entity.calculator.mahjong.MahjongTile.EAST_WIND;

/**
 * Controller class for handling the Calculator use case.
 * This class acts as a bridge between the user interface and the business logic,
 * delegating the task of score calculation to the use case interactor.
 */
public class CalculatorController {

    /**
     * The input boundary for the Calculator use case, enabling dependency inversion.
     */
    private final CalculatorInputBoundary calculatorUseCaseInteractor;

    /**
     * Constructs a CalculatorController with the specified use case interactor.
     *
     * @param calculatorUseCaseInteractor the interactor responsible for processing the calculator logic
     */
    public CalculatorController(CalculatorInputBoundary calculatorUseCaseInteractor) {
        this.calculatorUseCaseInteractor = calculatorUseCaseInteractor;
    }

    /**
     * Executes the calculator use case with the provided hand state.
     *
     * @param closedTiles closedtiles for handstate
     * @param closedGroups closedGroups for handstate
     * @param openGroups openGroups for handstate
     * @param winningTile winningtile for handstate
     */
    public void execute(List<MahjongTile> closedTiles, List<MahjongGroup> closedGroups, List<MahjongGroup> openGroups, MahjongTile winningTile) {
        final CalculatorInputData calculatorInputData = new CalculatorInputData(closedTiles, closedGroups, openGroups, winningTile);
        calculatorUseCaseInteractor.execute(calculatorInputData);
    }

    public void reset() {calculatorUseCaseInteractor.reset();}
}
