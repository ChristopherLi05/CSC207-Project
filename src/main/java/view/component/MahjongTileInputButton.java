package view.component;

import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class MahjongTileInputButton extends JButton {
    private final MahjongTile mahjongTile;

    public MahjongTileInputButton(MahjongTile tile) {
        this.mahjongTile = tile;

        // Load tile image
        ImageIcon tileImage = new ImageIcon(Objects.requireNonNull(getClass().getResource(tile.getFilePath())));
        setIcon(tileImage);
        setPreferredSize(new Dimension(61, 88));
        setBackground(new Color(255, 255, 255));
        setFocusPainted(false);

        setMargin(new Insets(3, 3, 3, 3));
    }

    public MahjongTile getMahjongTile() {
        return mahjongTile;
    }
}
