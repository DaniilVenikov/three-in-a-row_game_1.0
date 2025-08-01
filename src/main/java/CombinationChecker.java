import java.util.ArrayList;
import java.util.List;

public class CombinationChecker {

    public List<Combination> findCombinations(GameBoard board) {
        List<Combination> result = new ArrayList<>();
        int width = board.getWidth();
        int height = board.getHeight();

        // Ищем горизонтальные тройки
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width - 2; c++) {
                Field f1 = board.getField(r, c);
                Field f2 = board.getField(r, c + 1);
                Field f3 = board.getField(r, c + 2);
                if (!f1.isEmpty() && f1.getElementType() == f2.getElementType() && f2.getElementType() == f3.getElementType()) {
                    List<Field> comb = new ArrayList<>();
                    comb.add(f1); comb.add(f2); comb.add(f3);
                    result.add(new Combination(comb, f1.getElementType()));
                }
            }
        }
        // (По аналогии добавить вертикальные и сложные формы)
        return result;
    }

    public boolean hasPossibleMoves(GameBoard board) {
        // Для простоты: считаем есть, если можно сделать хотя бы одну тройку перестановкой (упрощённая версия)
        // В настоящей игре — сложная логика перебора
        return !findCombinations(board).isEmpty();
    }
}
