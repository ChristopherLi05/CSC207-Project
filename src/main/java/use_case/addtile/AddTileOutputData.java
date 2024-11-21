package use_case.addtile;

import entity.calculator.mahjong.MahjongGroup;

public class AddTileOutputData {
    public Object newTiles;

    public AddTileOutputData(Object newTiles) {
        if (newTiles instanceof MahjongGroup) {

        }
    }
}
