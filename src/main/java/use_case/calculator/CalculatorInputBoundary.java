package use_case.calculator;

import entity.calculator.Calculator;
import entity.calculator.HandState;

public interface CalculatorInputBoundary {
    void execute(HandState hand);
}
