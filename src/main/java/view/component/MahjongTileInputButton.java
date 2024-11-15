package view.component;

import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;
import java.awt.*;

public class MahjongTileInputButton extends JButton {
    private final MahjongTile mahjongTile;

    public MahjongTileInputButton(MahjongTile tile) {
        this.mahjongTile = tile;

        // Load tile image
        ImageIcon tileImage = new ImageIcon(getClass().getResource("/" + tile.getFilePath()));
        setIcon(tileImage);
        setPreferredSize(new Dimension(60, 60));
        setText(tile.name());
    }

    public MahjongTile getMahjongTile() {
        return mahjongTile;
    }
}
