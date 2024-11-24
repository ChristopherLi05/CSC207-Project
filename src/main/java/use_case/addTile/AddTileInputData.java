package use_case.addTile;

import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorComponentState;

public class AddTileInputData {
    private final MahjongTile tile;
    private final boolean isAka;
    private final ITileSelectorComponentState.SelectorType selectorType;

    public AddTileInputData(MahjongTile tile, boolean isAka, ITileSelectorComponentState.SelectorType selectorType) {
        this.tile = tile;
        this.isAka = isAka;
        this.selectorType = selectorType;
    }

    public ITileSelectorComponentState.SelectorType getSelectorType() {
        return selectorType;
    }

    public MahjongTile getTile() {
        return tile;
    }

    public boolean isAka() {
        return isAka;
    }
}
