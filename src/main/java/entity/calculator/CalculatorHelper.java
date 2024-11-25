package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongSuit;
import entity.calculator.mahjong.MahjongTile;

import java.util.ArrayList;
import java.util.Collections;
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

                MahjongTile tile1 = grouping.extractTile(tile.getValue(), tile.getSuit());
                MahjongTile tile2 = grouping.extractTile(tile.getValue(), tile.getSuit());

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

    public static List<HandGrouping> extractGroup(HandGrouping state) {
        if (state.getUngroupedTiles().isEmpty()) return Collections.singletonList(state);

        List<HandGrouping> extractedGroupings = new ArrayList<>();

        if (containsChiiGroup(state)) {
            extractedGroupings.add(extractChiiGroup(state));
        }

        if (containsPonGroup(state)) {
            extractedGroupings.add(extractPonGroup(state));
        }

        List<HandGrouping> finishedGroupings = new ArrayList<>();
        for (HandGrouping grouping : extractedGroupings) {
            finishedGroupings.addAll(extractGroup(grouping));
        }

        return finishedGroupings;
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

    public static boolean containsChiiGroup(HandGrouping grouping) {
        if (grouping.getFirstTile().getValue() <= 0 || grouping.getFirstTile().getValue() > 7) return false;
        return (countNumTiles(grouping.getUngroupedTiles(), grouping.getFirstTile().getValue() + 1, grouping.getFirstTile().getSuit()) > 0 &&
                countNumTiles(grouping.getUngroupedTiles(), grouping.getFirstTile().getValue() + 2, grouping.getFirstTile().getSuit()) > 0);
    }

    public static HandGrouping extractChiiGroup(HandGrouping grouping) {
        HandGrouping copy = grouping.copy();

        MahjongTile tile1 = grouping.getUngroupedTiles().remove(0);
        MahjongTile tile2 = grouping.extractTile(tile1.getValue() + 1, tile1.getSuit());
        MahjongTile tile3 = grouping.extractTile(tile1.getValue() + 2, tile1.getSuit());

        copy.addGroup(new MahjongGroup(tile1, tile2, tile3));
        return copy;
    }

    public static boolean containsPonGroup(HandGrouping grouping) {
        return countNumTiles(grouping.getUngroupedTiles(), grouping.getFirstTile().getValue(), grouping.getFirstTile().getSuit()) >= 3;
    }

    public static HandGrouping extractPonGroup(HandGrouping grouping) {
        HandGrouping copy = grouping.copy();

        MahjongTile tile1 = grouping.getUngroupedTiles().remove(0);
        MahjongTile tile2 = grouping.extractTile(tile1.getValue(), tile1.getSuit());
        MahjongTile tile3 = grouping.extractTile(tile1.getValue(), tile1.getSuit());

        copy.addGroup(new MahjongGroup(tile1, tile2, tile3));
        return copy;
    }
}
