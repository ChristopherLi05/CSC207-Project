package use_case.calculator;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public class CalculatorInputData {

    private final List<MahjongTile> selectedtiles;

    //TO DO not sure if this input type is Handstate
    public CalculatorInputData(List<MahjongTile> selectedtiles) {
        this.selectedtiles = selectedtiles;
    }

    List<MahjongTile> getSelectedtiles() {
        return selectedtiles;
    }
}
