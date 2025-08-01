import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerInfo {
    private final String playerName;
    private int score = 0;
    private int moveCount = 0;
    private final List<MoveInfo> history = new ArrayList<>();

    public PlayerInfo(String playerName) {
        this.playerName = playerName;
    }


    public String getPlayerName() { return playerName; }
    public int getScore() { return score; }
    public int getMoveCount() { return moveCount; }
    public List<MoveInfo> getMoveHistory() { return Collections.unmodifiableList(history); }
    public void addScore(int points) { score += points; }
    public void incrementMove() { moveCount++; }
    public void addMove(MoveInfo move) { history.add(move); }
}
