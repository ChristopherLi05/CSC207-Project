package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TileSelectorComponent extends JPanel implements ActionListener {
    private final ITileSelectorMaster master;
    private final List<MahjongTileInputButton> buttons = new ArrayList<>();
    private final List<MahjongTile> chiiTiles = new ArrayList<>();

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

        JCheckBox isOpenCheckbox = new JCheckBox("Is Open", true);
        isOpenCheckbox.addActionListener(e -> setSelectorType(
                isOpenCheckbox.isSelected() ? ITileSelectorMaster.SelectorType.OPEN_KAN : ITileSelectorMaster.SelectorType.CLOSED_KAN
        ));
        controlPanel.add(isOpenCheckbox);

        add(controlPanel, BorderLayout.NORTH);

        // Action type buttons
        JButton chiiButton = new JButton("Chi");
        chiiButton.addActionListener(e -> setSelectorType(ITileSelectorMaster.SelectorType.CHII));
        controlPanel.add(chiiButton);

        JButton ponButton = new JButton("Pon");
        ponButton.addActionListener(e -> setSelectorType(ITileSelectorMaster.SelectorType.PON));
        controlPanel.add(ponButton);

        JButton closedKanButton = new JButton("Closed Kan");
        closedKanButton.addActionListener(e -> setSelectorType(ITileSelectorMaster.SelectorType.CLOSED_KAN));
        controlPanel.add(closedKanButton);

        JButton openKanButton = new JButton("Open Kan");
        openKanButton.addActionListener(e -> setSelectorType(ITileSelectorMaster.SelectorType.OPEN_KAN));
        controlPanel.add(openKanButton);

        // Tile panel with grid layout for Mahjong tiles
        JPanel tilePanel = new JPanel(new GridLayout(4, 9));

        // Initialize buttons for each MahjongTile in enum
        for (MahjongTile tile : MahjongTile.values()) {
            MahjongTileInputButton button = new MahjongTileInputButton(tile);
            button.addActionListener(this);
            buttons.add(button);
            tilePanel.add(button);

            // Check for aka (red dora) tiles
            if (tile.isAka()) {
                containsAka = true;
            }
        }

        add(tilePanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof MahjongTileInputButton) {
            MahjongTile tile = ((MahjongTileInputButton) e.getSource()).getMahjongTile();

            if (selectorType == ITileSelectorMaster.SelectorType.NONE) {
                master.addClosedTile(tile);
            } else if (selectorType == ITileSelectorMaster.SelectorType.CHII) {
                addChiiTile(tile);
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

    private void addChiiTile(MahjongTile tile) {
        chiiTiles.add(tile);

        // Check if we have three tiles for CHII
        if (chiiTiles.size() == 3) {
            // Check if tiles form valid sequence
            chiiTiles.sort(Comparator.comparingInt(MahjongTile::getValue));

            boolean isSameSuit = chiiTiles.get(0).getSuit() == chiiTiles.get(1).getSuit()
                    && chiiTiles.get(1).getSuit() == chiiTiles.get(2).getSuit();
            boolean isSequential = chiiTiles.get(1).getValue() == chiiTiles.get(0).getValue() + 1
                    && chiiTiles.get(2).getValue() == chiiTiles.get(1).getValue() + 1;

            if (isSameSuit && isSequential) {
                MahjongGroup chiiGroup = new MahjongGroup(chiiTiles.get(0), chiiTiles.get(1), chiiTiles.get(2));
                master.addChiiGroup(chiiGroup);
            } else {
                // Handle invalid sequence selection
                System.out.println("Invalid sequence for CHII. Please select consecutive tiles of the same suit.");
            }
            chiiTiles.clear(); // Reset for next CHII selection
        }
    }

    public void setSelectorType(ITileSelectorMaster.SelectorType selectorType) {
        this.selectorType = selectorType;
    }

    public ITileSelectorMaster.SelectorType getSelectorType() {
        return selectorType;
    }
}
