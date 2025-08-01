import java.util.List;

public class GameLogic {
    private final GameBoard board;
    private final PlayerInfo player;
    private final CombinationChecker checker;
    private final BonusService bonusService;

    public GameLogic(GameBoard board, PlayerInfo player, CombinationChecker checker, BonusService bonusService) {
        this.board = board;
        this.player = player;
        this.checker = checker;
        this.bonusService = bonusService;
    }

    public boolean isGameOver() {
        return !checker.hasPossibleMoves(board);
    }

    public boolean makeMove(int row1, int col1, int row2, int col2) {
        // 1. Проверить валидность перестановки
        // 2. Сделать swap
        board.swapFields(row1, col1, row2, col2);

        // 3. Найти комбинации, если есть — обработать
        List<Combination> combs = checker.findCombinations(board);
        if (combs.isEmpty()) {
            // Откатить ход, если ничего не произошло (по правилам)
            board.swapFields(row1, col1, row2, col2);
            return false;
        }

        // 4. Удалить комбинации, начислить очки, проверить бонусы
        int points = 0;
        for (Combination comb : combs) {
            board.removeCombination(comb);
            points += comb.getSize() * 10; // простое начисление
            Bonus bonus = bonusService.createBonus(comb);
            if (bonus != null) {
                // Присваиваем бонус одной из ячеек комбинации
                comb.getFields().get(0).setBonus(bonus);
            }
        }
        player.addScore(points);
        player.incrementMove();
        player.addMove(new MoveInfo(row1, col1, row2, col2, points, null)); // бонус можно добавить при усложнении

        // 5. Сдвинуть элементы и заполнить поле
        board.dropElements();
        board.fillEmpty();

        return true;
    }

    public GameBoard getBoard() {
        return board;
    }

    public PlayerInfo getPlayer() {
        return player;
    }
}
