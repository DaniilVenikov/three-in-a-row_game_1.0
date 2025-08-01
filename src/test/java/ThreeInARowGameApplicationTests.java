import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreeInARowGameApplicationTests {
    @Test
    public void testInitialBoardNoCombinations() {
        GameBoard board = new GameBoard(8, 8, ElementType.values());
        CombinationChecker checker = new CombinationChecker();
        List<Combination> combinations = checker.findCombinations(board);

        //assertTrue(combinations.isEmpty());
    }

    @Test
    public void testSwapAndFindCombination() {
        GameBoard board = new GameBoard(8, 8, ElementType.values());
        CombinationChecker checker = new CombinationChecker();

        board.swapFields(0,2,0,3);

        List<Combination> combs = checker.findCombinations(board);
        assertFalse(combs.isEmpty());
    }

    @Test
    public void testAddScoreAndHistory() {
        PlayerInfo player = new PlayerInfo("Test");
        int prevScore = player.getScore();
        MoveInfo move = new MoveInfo(0, 0, 0, 1, 30, null);

        player.addMove(move);
        player.addScore(move.getPoints());

        assertEquals(prevScore + 30, player.getScore());
        assertEquals(1, player.getMoveHistory().size());
    }

    @Test
    public void testBonusActivation() {
        GameBoard board = new GameBoard(8, 8, ElementType.values());
        Bonus bonus = new Bonus();
        Field field = board.getField(2,3);
        field.setBonus(bonus);

        bonus.activate(board, 2, 3);

        for (int col = 0; col < board.getWidth(); col++) {
            assertTrue(board.getField(2, col).isEmpty());
        }
    }
}
