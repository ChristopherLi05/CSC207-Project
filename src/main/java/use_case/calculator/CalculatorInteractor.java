package use_case.calculator;

import entity.calculator.Calculator;
import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import use_case.login.LoginOutputData;
import view.component.IDisplayHandComponentState;
import view.component.ITileSelectorMaster;

import java.util.List;

import static use_case.calculator.CalculatorDataAccessInterface.east;

public class CalculatorInteractor implements CalculatorInputBoundary{
    private final CalculatorOutputBoundary calculatorPresenter;

    public CalculatorInteractor(CalculatorOutputBoundary calculatorOutputBoundary) {
        this.calculatorPresenter = calculatorOutputBoundary;
    }

    @Override
    public void execute(HandState hand) {
        int score = Calculator.calculateScore(hand);
        //TODO if the handstate was not correct or sufficient
        if (score == null) {
            calculatorPresenter.prepareFailView("Invalid hand");
        } else {
            calculatorPresenter.prepareSuccessView("Score is", new CalculatorOutputData(score));
        }
    }
}
