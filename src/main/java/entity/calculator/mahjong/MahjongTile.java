package entity.calculator.mahjong;

public enum MahjongTile {
    ONE_MAN("1m", "tile/Man1.png", MahjongSuit.MAN, 1, 1),
    TWO_MAN("2m", "tile/Man2.png", MahjongSuit.MAN, 2, 1),
    THREE_MAN("3m", "tile/Man3.png", MahjongSuit.MAN, 3, 1),
    FOUR_MAN("4m", "tile/Man4.png", MahjongSuit.MAN, 4, 1),
    FIVE_MAN("5m", "tile/Man5.png", MahjongSuit.MAN, 5, 1),
    RED_FIVE_MAN("rm", "tile/Man5-Dora.png", MahjongSuit.MAN, 5, 1, true),
    SIX_MAN("6m", "tile/Man6.png", MahjongSuit.MAN, 6, 1),
    SEVEN_MAN("7m", "tile/Man7.png", MahjongSuit.MAN, 7, 1),
    EIGHT_MAN("8m", "tile/Man8.png", MahjongSuit.MAN, 8, 1),
    NINE_MAN("9m", "tile/Man9.png", MahjongSuit.MAN, 9, 1),
    ONE_SOU("1s", "tile/Sou1.png", MahjongSuit.SOU, 1, 2),
    TWO_SOU("2s", "tile/Sou2.png", MahjongSuit.SOU, 2, 2),
    THREE_SOU("3s", "tile/Sou3.png", MahjongSuit.SOU, 3, 2),
    FOUR_SOU("4s", "tile/Sou4.png", MahjongSuit.SOU, 4, 2),
    FIVE_SOU("5s", "tile/Sou5.png", MahjongSuit.SOU, 5, 2),
    RED_FIVE_SOU("rs", "tile/Sou5-Dora.png", MahjongSuit.SOU, 5, 2, true),
    SIX_SOU("6s", "tile/Sou6.png", MahjongSuit.SOU, 6, 2),
    SEVEN_SOU("7s", "tile/Sou7.png", MahjongSuit.SOU, 7, 2),
    EIGHT_SOU("8s", "tile/Sou8.png", MahjongSuit.SOU, 8, 2),
    NINE_SOU("9s", "tile/Sou9.png", MahjongSuit.SOU, 9, 2),
    ONE_PIN("1p", "tile/Pin1.png", MahjongSuit.PIN, 1, 3),
    TWO_PIN("2p", "tile/Pin2.png", MahjongSuit.PIN, 2, 3),
    THREE_PIN("3p", "tile/Pin3.png", MahjongSuit.PIN, 3, 3),
    FOUR_PIN("4p", "tile/Pin4.png", MahjongSuit.PIN, 4, 3),
    FIVE_PIN("5p", "tile/Pin5.png", MahjongSuit.PIN, 5, 3),
    RED_FIVE_PIN("rp", "tile/Pin5-Dora.png", MahjongSuit.PIN, 5, 3, true),
    SIX_PIN("6p", "tile/Pin6.png", MahjongSuit.PIN, 6, 3),
    SEVEN_PIN("7p", "tile/Pin7.png", MahjongSuit.PIN, 7, 3),
    EIGHT_PIN("8p", "tile/Pin8.png", MahjongSuit.PIN, 8, 3),
    NINE_PIN("9p", "tile/Pin9.png", MahjongSuit.PIN, 9, 3),
    GREEN_DRAGON("gd", "tile/Hatsu.png", MahjongSuit.DRAGON),
    RED_DRAGON("rd", "tile/Chun.png", MahjongSuit.DRAGON),
    WHITE_DRAGON("wd", "tile/Haku.png", MahjongSuit.DRAGON),
    EAST_WIND("ew", "tile/Ton.png", MahjongSuit.WIND),
    SOUTH_WIND("sw", "tile/Nan.png", MahjongSuit.WIND),
    WEST_WIND("ww", "tile/Shaa.png", MahjongSuit.WIND),
    NORTH_WIND("nw", "tile/Pei.png", MahjongSuit.WIND);

    private final String serialize;
    private final String filePath;
    private final int value;
    private final boolean terminal;
    private final MahjongSuit suit;
    private final boolean aka;
    private final int rank;

    MahjongTile(String serialize, String filePath, MahjongSuit suit) {
        this(serialize, filePath, suit, -1, -1, false);
    }

    MahjongTile(String serialize, String filePath, MahjongSuit suit, int value, int rank) {
        this(serialize, filePath, suit, rank, value, false);
    }

    MahjongTile(String serialize, String filePath, MahjongSuit suit, int value, int rank, boolean aka) {
        this.serialize = serialize;
        this.filePath = filePath;
        this.rank = rank;
        this.value = value;
        this.suit = suit;
        this.terminal = value == 1 || value == 9;
        this.aka = aka;
    }

    public String getSerialization() {
        return serialize;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getValue() {
        return value;
    }

    public MahjongSuit getSuit() {
        return suit;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public boolean isAka() {
        return aka;
    }

    public int getRank() { return rank; }

    public static MahjongTile getMahjongTile(String serialize) {
        for (MahjongTile tile : MahjongTile.values()) {
            if (tile.getSerialization().equals(serialize)) {
                return tile;
            }
        }

        return null;
    }

    public int getSuitOrder() {
        return switch (suit) {
            case MAN -> 1;
            case SOU -> 2;
            case PIN -> 3;
            case DRAGON -> 4;
            case WIND -> 5;
            default -> Integer.MAX_VALUE;
        };
    }
}
