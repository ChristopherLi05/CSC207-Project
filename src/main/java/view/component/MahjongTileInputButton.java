package view.component;

import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;
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
    }

    public MahjongTile getMahjongTile() {
        return mahjongTile;
    }
}
