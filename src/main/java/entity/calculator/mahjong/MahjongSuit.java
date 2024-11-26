package entity.calculator.mahjong;

public enum MahjongSuit {
    MAN(false, 0), PIN(false, 1), SOU(false, 2), DRAGON(true, 3), WIND(true, 4);

    private final boolean honor;
    private final int sort;

    MahjongSuit(boolean honor, int sort) {
        this.honor = honor;
        this.sort = sort;
    }

    public boolean isHonor() {
        return honor;
    }

    public int getSort() {
        return sort;
    }
}
