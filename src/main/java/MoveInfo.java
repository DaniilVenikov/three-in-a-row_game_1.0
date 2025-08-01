public class MoveInfo {
    private final int row1, col1, row2, col2, points;
    private final Bonus bonusUsed;

    public MoveInfo(int row1, int col1, int row2, int col2, int points, Bonus bonusUsed) {
        this.row1 = row1; this.col1 = col1;
        this.row2 = row2; this.col2 = col2;
        this.points = points;
        this.bonusUsed = bonusUsed;
    }

    public int getRow1() { return row1; }

    public int getCol1() { return col1; }

    public int getRow2() { return row2; }

    public int getCol2() { return col2; }

    public int getPoints() { return points; }

    public Bonus getBonusUsed() { return bonusUsed; }
}
