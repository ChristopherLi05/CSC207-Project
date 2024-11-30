package view.component;

import entity.calculator.mahjong.MahjongTile;
import interface_adapter.calculator.CalculatorViewState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Tile Selector Component ; Class that handles the tile selector
 */
public class TileSelectorComponent extends JPanel {
    private final Color UNTOGGLE_COLOR = new Color(0xFFFFFF);
    private final Color TOGGLE_COLOR = new Color(0x89CFF0);

    private final CalculatorViewState calculatorViewState;

    private final JButton chiiButton;
    private final JButton ponButton;
    private final JButton closedKanButton;
    private final JButton openKanButton;

    /**
     * Constructs TileSelectorComponent object with specified view state and action listener.
     *
     * @param calculatorViewState the concrete observer that observes the calculator state
     * @param tileListener the action listener that handles tile selection events
     */
    public TileSelectorComponent(CalculatorViewState calculatorViewState, ActionListener tileListener) {
        this.calculatorViewState = calculatorViewState;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Control panel with action type buttons and checkboxes
        JPanel controlPanel = new JPanel(new FlowLayout());

        JCheckBox containsAkaCheckbox = new JCheckBox("Contains Aka");
        containsAkaCheckbox.setFont(new Font("Arial", Font.PLAIN, 30));
        containsAkaCheckbox.addActionListener(e -> calculatorViewState.getState().setAka(containsAkaCheckbox.isSelected()));
        controlPanel.add(containsAkaCheckbox);

        // Action type buttons
        chiiButton = new JButton("Chii");
        chiiButton.setFont(new Font("Arial", Font.PLAIN, 30));
        chiiButton.addActionListener(e -> toggleSelectorType(TileSelectorComponentState.SelectorType.CHII));
        chiiButton.setFocusPainted(false);
        controlPanel.add(chiiButton);

        ponButton = new JButton("Pon");
        ponButton.setFont(new Font("Arial", Font.PLAIN, 30));
        ponButton.addActionListener(e -> toggleSelectorType(TileSelectorComponentState.SelectorType.PON));
        ponButton.setFocusPainted(false);
        controlPanel.add(ponButton);

        closedKanButton = new JButton("Closed Kan");
        closedKanButton.setFont(new Font("Arial", Font.PLAIN, 30));
        closedKanButton.addActionListener(e -> toggleSelectorType(TileSelectorComponentState.SelectorType.CLOSED_KAN));
        closedKanButton.setFocusPainted(false);
        controlPanel.add(closedKanButton);

        openKanButton = new JButton("Open Kan");
        openKanButton.setFont(new Font("Arial", Font.PLAIN, 30));
        openKanButton.addActionListener(e -> toggleSelectorType(TileSelectorComponentState.SelectorType.OPEN_KAN));
        openKanButton.setFocusPainted(false);
        controlPanel.add(openKanButton);

        toggleSelectorType(TileSelectorComponentState.SelectorType.NONE);

        // Adding button to control panel
        add(controlPanel);

        // Tile panel with grid layout for Mahjong tiles
        JPanel tilePanel = new JPanel(new GridLayout(4, 9));

        // Initialize buttons for each MahjongTile in enum
        for (MahjongTile tile : MahjongTile.values()) {
            MahjongTileInputButton button = new MahjongTileInputButton(tile);
            button.addActionListener(tileListener);
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {

                    button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));// Highlight with a blue border
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// Remove border
                    button.setBackground(Color.WHITE); // Reset background to white
                    button.setOpaque(true);
                    button.setPreferredSize(new Dimension(61, 88));
                    button.setSize(new Dimension(61, 88));
                    button.setMargin(new Insets(3, 3, 3, 3));
                }
            });
            tilePanel.add(button);
        }

        tilePanel.add(new JLabel(""), 30);
        tilePanel.add(new JLabel(""), 34);

        add(tilePanel);

        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    /**
     * Toggles selector type for tile selection.
     * @param newSelectorType the new selector type to be set
     */
    public void toggleSelectorType(TileSelectorComponentState.SelectorType newSelectorType) {
        TileSelectorComponentState.SelectorType oldSelectorType = calculatorViewState.getState().getSelectorType();
        calculatorViewState.getState().setSelectorType(oldSelectorType == newSelectorType ? TileSelectorComponentState.SelectorType.NONE : newSelectorType);
        newSelectorType = calculatorViewState.getState().getSelectorType();

        this.chiiButton.setBackground(newSelectorType == TileSelectorComponentState.SelectorType.CHII ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.ponButton.setBackground(newSelectorType == TileSelectorComponentState.SelectorType.PON ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.closedKanButton.setBackground(newSelectorType == TileSelectorComponentState.SelectorType.CLOSED_KAN ? TOGGLE_COLOR : UNTOGGLE_COLOR);
        this.openKanButton.setBackground(newSelectorType == TileSelectorComponentState.SelectorType.OPEN_KAN ? TOGGLE_COLOR : UNTOGGLE_COLOR);
    }
}
