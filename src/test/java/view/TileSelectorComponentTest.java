package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.component.TileSelectorComponent;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.mahjong.MahjongGroup;
import view.component.TileSelectorComponentState;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TileSelectorComponentTest {
    private TileSelectorComponent tileSelectorComponent;

    @BeforeEach
    void setUp() {
        tileSelectorComponent = new TileSelectorComponent(new TileSelectorComponentState() {
            @Override
            public void addClosedTile(MahjongTile mahjongTile) {}

            @Override
            public void addChiiGroup(MahjongGroup mahjongGroup) {}

            @Override
            public void addPonGroup(MahjongGroup mahjongGroup) {}

            @Override
            public void addClosedKanGroup(MahjongGroup mahjongGroup) {}

            @Override
            public void addOpenKanGroup(MahjongGroup mahjongGroup) {}
        });
    }

    @Test
    void testContainsAkaCheckbox() {
        JCheckBox containsAkaCheckbox = (JCheckBox) ((JPanel) tileSelectorComponent.getComponent(0)).getComponent(0);
        containsAkaCheckbox.setSelected(true);
        assertTrue(containsAkaCheckbox.isSelected());
    }

    @Test
    void testSelectorType() {
        tileSelectorComponent.setSelectorType(TileSelectorComponentState.SelectorType.CHII);
        assertEquals(TileSelectorComponentState.SelectorType.CHII, tileSelectorComponent.getSelectorType());
    }
}