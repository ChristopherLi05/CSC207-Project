package use_case.calculator;

import entity.calculator.Calculator;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorMaster;

import java.util.List;

import static use_case.calculator.CalculatorDataAccessInterface.east;

public class CalculatorInteractor implements CalculatorInputBoundary{
    private final CalculatorOutputBoundary calculatorPresenter;
    private final CalculatorDataAccessInterface dataAccessinterface;
    private final IHandStateFactory handStateFactory;

    public CalculatorInteractor(CalculatorOutputBoundary calculatorOutputBoundary,
                                ITileSelectorMaster DataAccessinterface,
                                IHandStateFactory handStateFactory) {
        this.calculatorPresenter = calculatorOutputBoundary;
        this.handStateFactory = handStateFactory;
    }

    @Override
    public void execute(CalculatorInputData inputData) {
        List<MahjongTile> selectedtiles = inputData.getSelectedtiles();
//            String closedTiles = dataAccessinterface.getClosedTiles();
//            String closedGroup = dataAccessinterface.getClosedGroup();
//            String openGroup = dataAccessinterface.getOpenGroups();
//            String winningTile = dataAccessinterface.getWinningTile();
//TODO MOdify selectedtiles to make handstate
        HandState handstate =
                handStateFactory.createHandState(closedTiles, closedGroup, openGroup, winningTile,
                        '', '', "ew", "ew", 0x1);
        int score = Calculator.calculateScore(handstate);
        calculatorPresenter.prepareSuccessView(new CalculatorOutputData(score, false));
    }
}
