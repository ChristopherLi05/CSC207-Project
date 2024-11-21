package use_case.addtile;

import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorMaster;

public class AddTileInputData {
    private final MahjongTile tile;
    private final boolean isAka;
    private final ITileSelectorMaster.SelectorType selectorType;

    public AddTileInputData(MahjongTile tile, boolean isAka, ITileSelectorMaster.SelectorType selectorType) {
        this.tile = tile;
        this.isAka = isAka;
        this.selectorType = selectorType;

    }

    public ITileSelectorMaster.SelectorType getSelectorType() {return selectorType;}

    public MahjongTile getTile() {return tile;}

    public boolean isAka() {return isAka;}
}
