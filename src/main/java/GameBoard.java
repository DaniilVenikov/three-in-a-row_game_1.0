import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private final int width;
    private final int height;
    private final Field[][] fields;
    private final ElementType[] availableTypes;
    private final Random rnd = new Random();

    public GameBoard(int width, int height, ElementType[] types) {
        this.width = width;
        this.height = height;
        this.availableTypes = types;
        this.fields = new Field[height][width];
        fillRandom();
    }

    private void fillRandom() {
        for (int r = 0; r < height; r++)
            for (int c = 0; c < width; c++)
                fields[r][c] = new Field(availableTypes[rnd.nextInt(availableTypes.length)]);
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public Field getField(int row, int col) { return fields[row][col]; }

    public boolean hasPossibleMoves() {
        // Простейшая реализация — всегда true, детальная логика в CombinationChecker
        return true;
    }

    public List<Combination> findCombinations() {
        // Используется внешний CombinationChecker
        return new ArrayList<>();
    }

    public void swapFields(int row1, int col1, int row2, int col2) {
        Field temp = fields[row1][col1];
        fields[row1][col1] = fields[row2][col2];
        fields[row2][col2] = temp;
    }

    public void removeCombination(Combination comb) {
        for (Field f : comb.getFields()) {
            f.setElementType(null);
            f.setBonus(null);
        }
    }

    public void dropElements() {
        for (int c = 0; c < width; c++) {
            int freeRow = height - 1;
            for (int r = height - 1; r >= 0; r--) {
                if (!fields[r][c].isEmpty()) {
                    fields[freeRow][c].setElementType(fields[r][c].getElementType());
                    fields[freeRow][c].setBonus(fields[r][c].getBonus());
                    freeRow--;
                }
            }
            // Освобождаем верхние
            for (int r = freeRow; r >= 0; r--) {
                fields[r][c].setElementType(null);
                fields[r][c].setBonus(null);
            }
        }
    }

    public void fillEmpty() {
        for (int r = 0; r < height; r++)
            for (int c = 0; c < width; c++)
                if (fields[r][c].isEmpty())
                    fields[r][c].setElementType(availableTypes[rnd.nextInt(availableTypes.length)]);
    }
}
