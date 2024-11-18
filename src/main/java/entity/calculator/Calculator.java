package entity.calculator;

import entity.calculator.mahjong.MahjongGroup;
import entity.calculator.mahjong.MahjongSuit;
import entity.calculator.mahjong.MahjongTile;
import entity.calculator.yaku.IYakuTestCase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    private static final List<IYakuTestCase> yakuList = new ArrayList<IYakuTestCase>();

    /***
     * Determine whether the three tiles can be grouped in ascending order.
     * The three tiles are in ascending order.
     * @param tile the tile to consider
     * @param tiles the remaining tiles
     * @return true if they can be grouped in ascending order
     */
    private static boolean canGroupChii(MahjongTile tile, List<MahjongTile> tiles) {
        if (!tile.getSuit().equals(MahjongSuit.DRAGON) && !tile.getSuit().equals(MahjongSuit.WIND)) {
            if (tile.getValue() != 8 && tile.getValue() != 9) {
                if (tileListIndex(tile.getValue()+1, tile.getSuit(), tiles) != -1 &&
                        tileListIndex(tile.getValue()+2, tile.getSuit(), tiles) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int tileListIndex(int value, MahjongSuit suit, List<MahjongTile> tiles) {
        for (int i=0; i<tiles.size(); i++) {
            if (tiles.get(i).getValue() == value && tiles.get(i).getSuit().equals(suit)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean canGroupPon(MahjongTile tile, List<MahjongTile> tiles) {
        //TODO: Implement canGroupPon
        return true;
    }

    private static List<MahjongTile> orderTiles(List<MahjongTile> tiles) {
        if (tiles == null) return new ArrayList<>();

        List<MahjongTile> orderedTiles = new ArrayList<>(tiles);
        orderedTiles.sort(Comparator.comparingInt(MahjongTile::getSuitOrder)
                .thenComparingInt(MahjongTile::getRank));
        return orderedTiles;
    }

    private static List<MahjongGroup> createGroups(HandState hand) {
        List<MahjongGroup> groups = new ArrayList<>();
        List<MahjongTile> tiles = orderTiles(hand.closedTiles());

        if (tiles.size() < 3) {
            return groups;
        }

        return groups;
    }

    public static int calculateHan(HandState hand) {
        int han = 20;
        //TODO: Check pinfu and chitoi case
        if (hand.tsumo()) {
            han += 2;
        } else if (hand.ron() && hand.openGroups().isEmpty()) {
            han += 10;
        }
        return han;
    }

    public static int calculateFu(HandState hand) {
        return 0;
    }

    public static int calculateScore(HandState hand) {
        return 0;
    }

    static {
        // Initialize all of the yaku test cases here
    }
}
