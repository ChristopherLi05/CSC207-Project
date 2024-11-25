package use_case.calculator;

public interface CalculatorOutputBoundary {
    void prepareSuccessView(String successMessage, CalculatorOutputData outputData);

    void prepareFailView(String errorMessage);
}