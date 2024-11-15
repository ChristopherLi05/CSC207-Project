package view.component;

import entity.calculator.mahjong.MahjongTile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DisplayHandComponent extends JPanel {
    private final List<MahjongTile> selectedTiles = new ArrayList<>();
    private final JPanel tileDisplayPanel;

    public DisplayHandComponent() {
        setLayout(new BorderLayout());

        // Panel that displays selected tiles
        tileDisplayPanel = new JPanel(new FlowLayout());
        add(tileDisplayPanel, BorderLayout.CENTER);

        // Clear button that removes all cards from display panel
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelectedTiles();
            }
        });
        add(clearButton, BorderLayout.SOUTH);
    }

    // Method that adds tile to selectedTiles and updates display when user selects tile.
    public void addTile(MahjongTile tile) {
        selectedTiles.add(tile);
        updateTileDisplay();
    }

    // Refreshes display panel to show current selected tiles.
    private void updateTileDisplay() {
        tileDisplayPanel.removeAll();
        for (MahjongTile tile : selectedTiles) {
            JLabel tileLabel = new JLabel(new ImageIcon(tile.getFilePath()));
            tileDisplayPanel.add(tileLabel);
        }
        tileDisplayPanel.revalidate();
        tileDisplayPanel.repaint();
    }

    // Resets display panel.
    public void clearSelectedTiles() {
        selectedTiles.clear();
        updateTileDisplay();
    }
}
