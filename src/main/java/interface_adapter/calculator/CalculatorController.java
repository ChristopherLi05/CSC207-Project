package interface_adapter.calculator;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongTile;
import use_case.calculator.CalculatorInputBoundary;
import use_case.calculator.CalculatorInputData;

import java.util.List;

public class CalculatorController {
    private final CalculatorInputBoundary calculatorUseCaseInteractor;

    public CalculatorController(CalculatorInputBoundary calculatorUseCaseInteractor) {
        this.calculatorUseCaseInteractor = calculatorUseCaseInteractor;
    }

//TODO
    public void execute() {

        calculatorUseCaseInteractor.execute();
    }
}
