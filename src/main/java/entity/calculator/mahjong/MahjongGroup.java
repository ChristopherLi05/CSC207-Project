package entity.calculator.mahjong;

/**
 * Represents a group of Mahjong tiles, which can contain either 3 or 4 tiles.
 * This class is used to model sets or sequences of tiles in a Mahjong hand.
 */
public class MahjongGroup {
    private final MahjongTile[] tiles;

    /**
     * Constructs a MahjongGroup with an array of tiles.
     *
     * @param tiles an array of MahjongTile objects. The array must have a length of 3 or 4.
     * @throws IllegalArgumentException if the length of the tile array is not 3 or 4.
     */
    public MahjongGroup(MahjongTile[] tiles) {
        if (tiles.length != 3 && tiles.length != 4) {
            throw new IllegalArgumentException("Invalid tile length, length is " + tiles.length + " (expected 3 or 4)");
        }

        this.tiles = tiles;
    }

    /**
     * Constructs a MahjongGroup with 3 tiles.
     *
     * @param tile1 the first tile in the group.
     * @param tile2 the second tile in the group.
     * @param tile3 the third tile in the group.
     */
    public MahjongGroup(MahjongTile tile1, MahjongTile tile2, MahjongTile tile3) {
        this.tiles = new MahjongTile[]{tile1, tile2, tile3};
    }

    /**
     * Constructs a MahjongGroup with 4 tiles.
     *
     * @param tile1 the first tile in the group.
     * @param tile2 the second tile in the group.
     * @param tile3 the third tile in the group.
     * @param tile4 the fourth tile in the group.
     */
    public MahjongGroup(MahjongTile tile1, MahjongTile tile2, MahjongTile tile3, MahjongTile tile4) {
        this.tiles = new MahjongTile[]{tile1, tile2, tile3, tile4};
    }

    /**
     * Returns the array of Mahjong tiles in this group.
     *
     * @return an array of MahjongTile objects.
     */
    public MahjongTile[] getTiles() {
        return tiles;
    }

    /**
     * Returns the Mahjong tile at the specified index.
     *
     * @param index the index of the tile to retrieve.
     * @return the MahjongTile at the specified index.
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds.
     */
    public MahjongTile getTile(int index) {
        return tiles[index];
    }

    /**
     * Replaces the Mahjong tile at the specified index with a new tile.
     *
     * @param index the index of the tile to replace.
     * @param tile  the new MahjongTile to set.
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds.
     */
    public void setTile(int index, MahjongTile tile) {
        tiles[index] = tile;
    }

    /**
     * Returns a serialized representation of the MahjongGroup.
     * The serialization is a concatenation of the serialized representations of each tile.
     *
     * @return a String representing the serialized MahjongGroup.
     */
    public String getSerialization() {
        StringBuilder builder = new StringBuilder();
        for (MahjongTile tile : tiles) {
            builder.append(tile.getSerialization());
        }

        return builder.toString();
    }

    /**
     * Returns a string representation of the MahjongGroup.
     * This includes the serialized form of the group wrapped in "MahjongGroup(...)".
     *
     * @return a String representing the MahjongGroup.
     */
    @Override
    public String toString() {
        return "MahjongGroup(" + getSerialization() + ")";
    }
}
