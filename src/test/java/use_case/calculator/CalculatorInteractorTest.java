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
        List<MahjongTile> closedTiles = Arrays.asList(RED_DRAGON, RED_DRAGON);
        List<MahjongGroup> closedGroups = Arrays.asList(new MahjongGroup(ONE_PIN, ONE_PIN, ONE_PIN, ONE_PIN), new MahjongGroup(GREEN_DRAGON, GREEN_DRAGON, GREEN_DRAGON), new MahjongGroup(ONE_MAN, ONE_MAN, ONE_MAN, ONE_MAN));
        List<MahjongGroup> openGroups = new ArrayList<>();
        MahjongTile winningTile = ONE_MAN;
        HandState handState = handStateFactory.createHandState(closedTiles, closedGroups, openGroups, winningTile, new ArrayList<>(), new ArrayList<>(), EAST_WIND, EAST_WIND, true, false, false, false, false, false, false, false, false); // Create a valid hand state mock or object
        int validScore = 48000;

        CalculatorOutputBoundary presenter = new CalculatorOutputBoundary() {
            @Override
            public void prepareFailView(String error) { fail("Failure view is unexpected."); }

            @Override
            public void prepareSuccessView(String message, CalculatorOutputData outputData) {
                assertEquals("Score is ", message);
                assertEquals(validScore, outputData.getScore());
            }
        };

        // Simulating Calculator.calculateScore to return a valid score
        CalculatorInteractor interactor = new CalculatorInteractor(presenter) {
        };
        // Act
        interactor.execute(handState);
    }
}
