package use_case.calculator;

public interface CalculatorOutputBoundary {
    void prepareSuccessView(CalculatorOutputData outputData);

    void prepareFailView(String errorMessage);
}