package interface_adapter.puzzleRush;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongTile;
import view.component.IDisplayHandComponentState;

import java.util.List;

public class PuzzleRushState implements IDisplayHandComponentState {
    @Override
    public List<MahjongTile> getClosedTiles() {
        return List.of();
    }

    @Override
    public List<MahjongGroup> getClosedGroup() {
        return List.of();
    }

    @Override
    public List<MahjongGroup> getOpenGroups() {
        return List.of();
    }

    @Override
    public MahjongTile getWinningTile() {
        return null;
    }
}
