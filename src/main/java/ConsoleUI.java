import java.util.Scanner;

public class ConsoleUI {
    private final GameLogic logic;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(GameLogic logic) {
        this.logic = logic;
    }

    public void run() {
        System.out.println("Добро пожаловать в игру Три-в-ряд!");

        while (!logic.isGameOver()) {
            printBoard();
            System.out.println("Ваш счёт: " + logic.getPlayer().getScore() +
                    " | Ходов: " + logic.getPlayer().getMoveCount());
            System.out.print("Введите две координаты (например, 0 0 0 1): ");
            int row1 = scanner.nextInt();
            int col1 = scanner.nextInt();
            int row2 = scanner.nextInt();
            int col2 = scanner.nextInt();

            boolean ok = logic.makeMove(row1, col1, row2, col2);
            if (!ok) {
                System.out.println("Нельзя сделать такой ход!");
            }
        }

        System.out.println("Игра окончена!");
        printBoard();
        System.out.println("Итоговый счёт: " + logic.getPlayer().getScore());
        System.out.println("Всего ходов: " + logic.getPlayer().getMoveCount());
    }

    private void printBoard() {
        GameBoard board = logic.getBoard();
        for (int r = 0; r < board.getHeight(); r++) {
            for (int c = 0; c < board.getWidth(); c++) {
                Field f = board.getField(r, c);
                System.out.print(
                        (f.getElementType() == null ? "." : f.getElementType().name()) + " "
                );
            }
            System.out.println();
        }
    }
}
