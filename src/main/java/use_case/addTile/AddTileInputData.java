package use_case.addTile;

import entity.calculator.mahjong.MahjongTile;
import view.component.TileSelectorComponentState;

public class AddTileInputData {
    private final MahjongTile tile;
    private final boolean isAka;
    private final TileSelectorComponentState.SelectorType selectorType;

    public AddTileInputData(MahjongTile tile, boolean isAka, TileSelectorComponentState.SelectorType selectorType) {
        this.tile = tile;
        this.isAka = isAka;
        this.selectorType = selectorType;

    }

    public TileSelectorComponentState.SelectorType getSelectorType() {return selectorType;}

    public MahjongTile getTile() {return tile;}

    public boolean isAka() {return isAka;}
}
