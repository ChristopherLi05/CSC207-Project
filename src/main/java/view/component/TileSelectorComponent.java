package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;
import java.awt.*;

public class TileSelectorComponent extends JPanel {
    private final ITileSelectorMaster master;

    private boolean containsAka = false;
    private ITileSelectorMaster.SelectorType selectorType = ITileSelectorMaster.SelectorType.NONE;

    public TileSelectorComponent(ITileSelectorMaster master) {
        this.master = master;
        setLayout(new BorderLayout());

        // Control panel with action type buttons and checkboxes
        JPanel controlPanel = new JPanel(new FlowLayout());

        // Checkboxes
        JCheckBox containsAkaCheckbox = new JCheckBox("Contains Aka");
        containsAkaCheckbox.addActionListener(e -> containsAka = containsAkaCheckbox.isSelected());
        controlPanel.add(containsAkaCheckbox);

        // Action type buttons
        JButton chiiButton = new JButton("Chi");
        chiiButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.CHII));
        controlPanel.add(chiiButton);

        JButton ponButton = new JButton("Pon");
        ponButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.PON));
        controlPanel.add(ponButton);

        JButton closedKanButton = new JButton("Closed Kan");
        closedKanButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.CLOSED_KAN));
        controlPanel.add(closedKanButton);

        JButton openKanButton = new JButton("Open Kan");
        openKanButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.OPEN_KAN));
        controlPanel.add(openKanButton);

        // Adding button to control panel
        add(controlPanel, BorderLayout.NORTH);

        // Tile panel with grid layout for Mahjong tiles
        JPanel tilePanel = new JPanel(new GridLayout(4, 9));

        // Initialize buttons for each MahjongTile in enum
        for (MahjongTile tile : MahjongTile.values()) {
            MahjongTileInputButton button = getMahjongTileInputButton(tile);
            tilePanel.add(button);
        }

        tilePanel.add(new JLabel(""), 30);

        add(tilePanel, BorderLayout.CENTER);
    }

    private MahjongTileInputButton getMahjongTileInputButton(MahjongTile tile) {
        MahjongTileInputButton button = new MahjongTileInputButton(tile);
        button.addActionListener(e -> {
            if (e.getSource() instanceof MahjongTileInputButton) {
                MahjongTile tile1 = ((MahjongTileInputButton) e.getSource()).getMahjongTile();

                if (selectorType == ITileSelectorMaster.SelectorType.NONE) {
                    addClosedTile(tile1);
                } else if (selectorType == ITileSelectorMaster.SelectorType.CHII) {
                    addChii(tile1);
                } else if (selectorType == ITileSelectorMaster.SelectorType.PON) {
                    addPon(tile1);
                } else if (selectorType == ITileSelectorMaster.SelectorType.CLOSED_KAN) {
                    addClosedKan(tile1);
                } else if (selectorType == ITileSelectorMaster.SelectorType.OPEN_KAN) {
                    addOpenKan(tile1);
                }
            }
        });
        return button;
    }

    public void toggleSelectorType(ITileSelectorMaster.SelectorType selectorType) {
        this.selectorType = selectorType == this.selectorType ? ITileSelectorMaster.SelectorType.NONE : selectorType;
    }

    private void addClosedTile(MahjongTile tile) {
        master.addClosedTile(tile);
    }

    private void addChii(MahjongTile tile) {
        if (tile.getValue() < 1 || tile.getValue() > 7) return;

        MahjongTile[] tiles = new MahjongTile[3];
        tiles[0] = tile;

        for (int i = 1; i < 3; i++) {
            if (i + tile.getValue() == 5 && containsAka) {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), true);
            } else {
                tiles[i] = MahjongTile.getMahjongTile(i + tile.getValue(), tile.getSuit(), false);
            }
        }

        MahjongGroup group = new MahjongGroup(tiles);
        master.addChiiGroup(group);
    }

    private void addPon(MahjongTile tile) {
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
    }

    private void addClosedKan(MahjongTile tile) {
        MahjongGroup group = createKanGroup(tile);
        master.addClosedKanGroup(group);
    }

    private void addOpenKan(MahjongTile tile) {
        MahjongGroup group = createKanGroup(tile);
        master.addOpenKanGroup(group);
    }

    private MahjongGroup createKanGroup(MahjongTile tile) {
        MahjongGroup group;

        if (tile.isAka()) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), false);
            group = new MahjongGroup(tile, tempTile, tempTile, tempTile);
        } else if (tile.getValue() == 5 && containsAka) {
            MahjongTile tempTile = MahjongTile.getMahjongTile(tile.getValue(), tile.getSuit(), true);
            group = new MahjongGroup(tempTile, tile, tile, tile);
        } else {
            group = new MahjongGroup(tile, tile, tile, tile);
        }
        return group;
    }

    public ITileSelectorMaster.SelectorType getSelectorType() {
        return selectorType;
    }
}
