package use_case.addtile;

import entity.calculator.mahjong.MahjongGroup;

public class AddTileOutputData {
    private String type = null;
    private Object newTiles = null;

    public AddTileOutputData(Object newTiles) {
        if (newTiles instanceof MahjongGroup) {
            this.type = "group";
            this.newTiles = newTiles;
        }
    }
}
