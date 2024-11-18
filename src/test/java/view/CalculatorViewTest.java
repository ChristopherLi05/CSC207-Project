package view;

import interface_adapter.calculator.CalculatorState;
import org.junit.jupiter.api.Test;
import view.CalculatorView;
import view.component.DisplayHandComponent;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.mahjong.MahjongGroup;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorViewTest {
    private CalculatorView calculatorView;
    private CalculatorState calculatorState
    private DisplayHandComponent displayHandComponent;

    @Test
    void testAddTileToDisplay() {
        calculatorState.addClosedTile(MahjongTile.ONE_MAN);
        assertEquals(1, displayHandComponent.getSelectedTiles().size());
    }

    @Test
    void testAddChiGroupToDisplay() {
        MahjongGroup chiiGroup = new MahjongGroup(MahjongTile.ONE_MAN, MahjongTile.TWO_MAN, MahjongTile.THREE_MAN);
        calculatorState.addChiiGroup(chiiGroup);
        assertEquals(3, displayHandComponent.getSelectedTiles().size());
    }

    @Test
    void testClearDisplay() {
        calculatorState.addClosedTile(MahjongTile.ONE_MAN);
        calculatorView.getDisplayHandComponent().clearSelectedTiles();
        assertEquals(0, displayHandComponent.getSelectedTiles().size());
    }
}
