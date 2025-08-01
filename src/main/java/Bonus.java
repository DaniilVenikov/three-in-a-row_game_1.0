public class Bonus {
    public String getName() {
        return "RowBonus";
    }


    public void activate(GameBoard board, int row, int col) {
        for (int c = 0; c < board.getWidth(); c++) {
            board.getField(row, c).setElementType(null);
            board.getField(row, c).setBonus(null);
        }
    }
}
