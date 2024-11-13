package entity.calculator.mahjong;

public class MahjongGroup {
    private final MahjongTile[] tiles;

    public MahjongGroup(MahjongTile[] tiles) {
        if (tiles.length != 3 && tiles.length != 4) {
            throw new IllegalArgumentException("Invalid tile length, length is " + tiles.length + " (expected 3 or 4)");
        }

        this.tiles = tiles;
    }

    public MahjongGroup(MahjongTile tile1, MahjongTile tile2, MahjongTile tile3) {
        this.tiles = new MahjongTile[]{tile1, tile2, tile3};
    }

    public MahjongGroup(MahjongTile tile1, MahjongTile tile2, MahjongTile tile3, MahjongTile tile4) {
        this.tiles = new MahjongTile[]{tile1, tile2, tile3, tile4};
    }

    public String getSerialization() {
        StringBuilder builder = new StringBuilder();
        for (MahjongTile tile : tiles) {
            builder.append(tile.getSerialization());
        }

        return builder.toString();
    }
}
