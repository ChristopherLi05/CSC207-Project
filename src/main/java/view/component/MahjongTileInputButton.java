package view.component;

import entity.calculator.mahjong.MahjongTile;

import javax.swing.*;

public class MahjongTileInputButton extends JButton {
    private final MahjongTile mahjongTile;

    public MahjongTileInputButton(MahjongTile tile) {
        this.mahjongTile = tile;

        // TODO: add button init stuff here (e.g. background image, etc)
    }

    public MahjongTile getMahjongTile() {
        return mahjongTile;
    }
}
