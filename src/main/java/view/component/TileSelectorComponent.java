package view.component;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import interface_adapter.calculator.CalculatorViewState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TileSelectorComponent extends JPanel {
    private final Color UNTOGGLE_COLOR = new Color(0xFFFFFF);
    private final Color TOGGLE_COLOR = new Color(0x89CFF0);

    private final ITileSelectorMaster master;

    private boolean containsAka = false;
    private ITileSelectorMaster.SelectorType selectorType = ITileSelectorMaster.SelectorType.NONE;

    private final JButton chiiButton;
    private final JButton ponButton;
    private final JButton closedKanButton;
    private final JButton openKanButton;

    public TileSelectorComponent(CalculatorViewState calculatorViewState) {
        this.master = master;
        setLayout(new BorderLayout());

        // Control panel with action type buttons and checkboxes
        JPanel controlPanel = new JPanel(new FlowLayout());

        // Checkboxes
        JCheckBox containsAkaCheckbox = new JCheckBox("Contains Aka");
        containsAkaCheckbox.addActionListener(e -> containsAka = containsAkaCheckbox.isSelected());
        controlPanel.add(containsAkaCheckbox);

        // Action type buttons
        chiiButton = new JButton("Chii");
        chiiButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.CHII));
        chiiButton.setFocusPainted(false);
        controlPanel.add(chiiButton);

        ponButton = new JButton("Pon");
        ponButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.PON));
        ponButton.setFocusPainted(false);
        controlPanel.add(ponButton);

        closedKanButton = new JButton("Closed Kan");
        closedKanButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.CLOSED_KAN));
        closedKanButton.setFocusPainted(false);
        controlPanel.add(closedKanButton);

        openKanButton = new JButton("Open Kan");
        openKanButton.addActionListener(e -> toggleSelectorType(ITileSelectorMaster.SelectorType.OPEN_KAN));
        openKanButton.setFocusPainted(false);
        controlPanel.add(openKanButton);

        toggleSelectorType(ITileSelectorMaster.SelectorType.NONE);

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
        tilePanel.add(new JLabel(""), 34);

        add(tilePanel, BorderLayout.CENTER);

        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private MahjongTileInputButton getMahjongTileInputButton(MahjongTile tile) {
        MahjongTileInputButton button = new MahjongTileInputButton(tile);
        button.addActionListener(e -> {
            // Send to use case interactor
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

        this.chiiButton.setBackground(this.selectorType == ITileSelectorMaster.SelectorType.CHII ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.ponButton.setBackground(this.selectorType == ITileSelectorMaster.SelectorType.PON ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.closedKanButton.setBackground(this.selectorType == ITileSelectorMaster.SelectorType.CLOSED_KAN ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.openKanButton.setBackground(this.selectorType == ITileSelectorMaster.SelectorType.OPEN_KAN ? TOGGLE_COLOR : UNTOGGLE_COLOR);
    }

    public ITileSelectorMaster.SelectorType getSelectorType() {
        return selectorType;
    }

    public boolean containsAka() {return containsAka;}
}
