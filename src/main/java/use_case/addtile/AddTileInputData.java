package use_case.addtile;

import entity.calculator.mahjong.MahjongTile;
import view.component.ITileSelectorMaster;

public class AddTileInputData {
    private final MahjongTile tileClicked;
    private final boolean isAka;
    private final ITileSelectorMaster.SelectorType selectorType;

    public AddTileInputData(MahjongTile tileClicked, boolean isAka, ITileSelectorMaster.SelectorType selectorType) {
        this.tileClicked = tileClicked;
        this.isAka = isAka;
        this.selectorType = selectorType;

    }

    public ITileSelectorMaster.SelectorType getSelectorType() {return selectorType;}

    public MahjongTile getTileClicked() {return tileClicked;}
}
