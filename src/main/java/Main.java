public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(8, 8, ElementType.values());
        PlayerInfo player = new PlayerInfo("Игрок");
        BonusService bonusService = new BonusService();
        CombinationChecker checker = new CombinationChecker();
        GameLogic logic = new GameLogic(board, player, checker, bonusService);
        ConsoleUI ui = new ConsoleUI(logic);
        ui.run();
    }
}
