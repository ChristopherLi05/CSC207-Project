package use_case.calculator;

import static entity.calculator.mahjong.MahjongTile.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import entity.calculator.HandState;
import entity.calculator.HandStateFactory;
import entity.calculator.IHandStateFactory;
import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorInteractorTest {

    @Test
    void testExecute_WithValidScore() {
        // Arrange
        IHandStateFactory handStateFactory = new HandStateFactory();
        List<MahjongTile> closedTiles = List.of(MahjongTile.ONE_SOU);
        List<MahjongGroup> closedGroups = List.of(new MahjongGroup(MahjongTile.TWO_MAN, MahjongTile.TWO_MAN, MahjongTile.TWO_MAN));
        List<MahjongGroup> openGroups = new ArrayList<>();
        MahjongTile winningTile = MahjongTile.ONE_SOU;
        int validScore = 18000;

        CalculatorOutputBoundary presenter = new CalculatorOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                fail("Failure view is unexpected.");
            }

            @Override
            public void prepareSuccessView(String message, CalculatorOutputData outputData) {
                assertEquals("Score is ", message);
                assertEquals(validScore, outputData.getScore());
            }
        };

        // Simulating Calculator.calculateScore to return a valid score
        CalculatorInteractor interactor = new CalculatorInteractor(presenter, handStateFactory) {
        };
        CalculatorInputData calculatorInputData = new CalculatorInputData(closedTiles, closedGroups, openGroups, winningTile);
        // Act
        interactor.execute(calculatorInputData);
    }

    @Test
    void testExecute_WithInValidScore() {
        // Arrange
        IHandStateFactory handStateFactory = new HandStateFactory();
        List<MahjongTile> closedTiles = new ArrayList<>();
        List<MahjongGroup> closedGroups = new ArrayList<>();
        List<MahjongGroup> openGroups = new ArrayList<>();
        MahjongTile winningTile = MahjongTile.ONE_SOU;
        int validScore = 0;

        CalculatorOutputBoundary presenter = new CalculatorOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                assertEquals("This is not a valid hand", error);
            }

            @Override
            public void prepareSuccessView(String message, CalculatorOutputData outputData) {
                fail("Success view is unexpected.");
            }
        };

        // Simulating Calculator.calculateScore to return a valid score
        CalculatorInteractor interactor = new CalculatorInteractor(presenter, handStateFactory) {
        };
        CalculatorInputData calculatorInputData = new CalculatorInputData(closedTiles, closedGroups, openGroups, winningTile);
        // Act
        interactor.execute(calculatorInputData);
    }

    @Test
    void testreset() {
        IHandStateFactory handStateFactory = new HandStateFactory();
        int validScore = 0;

        CalculatorOutputBoundary presenter = new CalculatorOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                fail("Failure view is unexpected.");
            }

            @Override
            public void prepareSuccessView(String message, CalculatorOutputData outputData) {
                assertEquals("Score is ", message);
                assertEquals(validScore, outputData.getScore());
            }
        };

        // Simulating Calculator.calculateScore to return a valid score
        CalculatorInteractor interactor = new CalculatorInteractor(presenter, handStateFactory) {
        };
        // Act
        interactor.reset();
    }
}
