package use_case.addtile;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;

public class AddTileOutputData {
    private String type = null;
    private Object newTiles = null;

    public AddTileOutputData(Object newTiles) {
        this.newTiles = newTiles;
        if (newTiles instanceof MahjongGroup) {
            this.type = "group";
        }
        else if (newTiles instanceof MahjongTile) {
            this.type = "tile";
        }
        else {
            this.type = "none";
        }
    }
}
