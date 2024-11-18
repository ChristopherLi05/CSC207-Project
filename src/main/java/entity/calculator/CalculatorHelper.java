package entity.calculator;

import entity.calculator.mahjong.MahjongSuit;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalculatorHelper {
    public static List<HandGrouping> extractPairs(HandState state) {
        List<MahjongTile> tiles = state.closedTiles();
        tiles.add(state.winningTile());
        tiles.sort(Comparator.comparingInt((MahjongTile tile) -> tile.getSuit().getSort()).thenComparing(MahjongTile::getValue));

        List<HandGrouping> groups = new ArrayList<>();

        MahjongTile lastSeenTile = null;
        for (MahjongTile tile : tiles) {
            if (tile == lastSeenTile) continue;
            lastSeenTile = tile;

            if (countNumTiles(tiles, tile.getValue(), tile.getSuit()) >= 2) {
                HandGrouping grouping = new HandGrouping(new ArrayList<>(tiles));

                MahjongTile tile1 = grouping.getUngroupedTiles().remove(indexTile(grouping.getUngroupedTiles(), tile.getValue(), tile.getSuit()));
                MahjongTile tile2 = grouping.getUngroupedTiles().remove(indexTile(grouping.getUngroupedTiles(), tile.getValue(), tile.getSuit()));

                grouping.setPair(tile1, tile2);
                groups.add(grouping);
            }
        }

        if (!groups.isEmpty()) {
            return groups;
        } else {
            return null;
        }
    }

    public static int countNumTiles(List<MahjongTile> tileList, int value, MahjongSuit suit) {
        int count = 0;
        for (MahjongTile tile : tileList) {
            if (tile.getValue() == value && tile.getSuit() == suit) {
                count++;
            }
        }

        return count;
    }

    public static int indexTile(List<MahjongTile> tileList, int value, MahjongSuit suit) {
        for (int i = 0; i < tileList.size(); i++) {
            MahjongTile tile = tileList.get(i);
            if (tile.getValue() == value && tile.getSuit() == suit) {
                return i;
            }
        }

        return -1;
    }

    public static boolean containsChiiGroup(HandGrouping grouping) {
        return false;
    }

    public static boolean containsPonGroup(HandGrouping grouping) {
        return false;
    }
}
