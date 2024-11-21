package interface_adapter.addtile;

import entity.calculator.mahjong.MahjongGroup;
import use_case.addtile.AddTileInputBoundary;
import use_case.addtile.AddTileOutputBoundary;
import use_case.addtile.AddTileOutputData;

public class AddTilePresenter implements AddTileOutputBoundary {

    @Override
    public void execute(AddTileOutputData outputData) {
        if (outputData instanceof MahjongGroup) {

        }
    }
}
