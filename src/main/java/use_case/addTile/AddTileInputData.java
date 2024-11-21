package use_case.addTile;

import view.component.ITileSelectorMaster;
import view.component.MahjongTileInputButton;

public class AddTileInputData {
    private final MahjongTileInputButton tileClicked;
    private final boolean isAka;
    private final ITileSelectorMaster.SelectorType selectorType;

    public AddTileInputData(Object tileClicked, boolean isAka, ITileSelectorMaster.SelectorType selectorType) {
        this.tileClicked = (MahjongTileInputButton) tileClicked;
        this.isAka = isAka;
        this.selectorType = selectorType;

    }

    public ITileSelectorMaster.SelectorType getSelectorType() {return selectorType;}
}
