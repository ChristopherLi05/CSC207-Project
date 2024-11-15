package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.CalculatorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TileSelectorComponent extends JPanel implements ActionListener {
    private final ITileSelectorMaster master;
    private final List<MahjongTileInputButton> buttons = new ArrayList<>();

    private boolean containsAka = false;
    private ITileSelectorMaster.SelectorType selectorType = ITileSelectorMaster.SelectorType.NONE;

    public TileSelectorComponent(ITileSelectorMaster master) {
        this.master = master;
        setLayout(new GridLayout(4, 9)); // Example layout for Mahjong tiles

        // Initialize buttons for each MahjongTile in the enum
        for (MahjongTile tile : MahjongTile.values()) {
            MahjongTileInputButton button = new MahjongTileInputButton(tile);
            button.addActionListener(this);
            buttons.add(button);
            add(button);

            // Check for aka (red-dora) tiles
            if (tile.isAka()) {
                containsAka = true;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MahjongTileInputButton) {
            MahjongTile tile = ((MahjongTileInputButton) e.getSource()).getMahjongTile();

            if (selectorType == ITileSelectorMaster.SelectorType.NONE) {
                master.addClosedTile(tile);
            } else if (selectorType == ITileSelectorMaster.SelectorType.CHII) {
                // Will add later.
            } else if (selectorType == ITileSelectorMaster.SelectorType.PON) {
                MahjongGroup group;

                if (tile.isAka()) {
                    MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
                    group = new MahjongGroup(tile, tempTile, tempTile);
                } else if (tile.getValue() == 5 && containsAka) {
                    MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
                    group = new MahjongGroup(tempTile, tile, tile);
                } else {
                    group = new MahjongGroup(tile, tile, tile);
                }

                master.addPonGroup(group);
            } else if (selectorType == ITileSelectorMaster.SelectorType.CLOSED_KAN) {
                MahjongGroup group = new MahjongGroup(tile, tile, tile, tile);
                master.addClosedKanGroup(group);
            } else if (selectorType == ITileSelectorMaster.SelectorType.OPEN_KAN) {
                MahjongGroup group = new MahjongGroup(tile, tile, tile, tile);
                master.addOpenKanGroup(group);
            }
        }
    }
}
