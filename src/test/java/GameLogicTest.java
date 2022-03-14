import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameLogic;
import rps.Move;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {GameLogic.class})
public class GameLogicTest {

    @Autowired
    GameLogic gameLogic;

    @Test
    public void test(){
        assertNotNull(gameLogic);
    }

    @Test
    public void make_move_player_wins_test(){
        assertEquals(1,gameLogic.makeMove(Move.ROCK,Move.SCISSORS));
        assertEquals(1,gameLogic.makeMove(Move.PAPER,Move.ROCK));
        assertEquals(1,gameLogic.makeMove(Move.SCISSORS,Move.PAPER));
    }

    @Test
    public void make_move_computer_wins_test(){
        assertEquals(-1,gameLogic.makeMove(Move.ROCK,Move.PAPER));
        assertEquals(-1,gameLogic.makeMove(Move.PAPER,Move.SCISSORS));
        assertEquals(-1,gameLogic.makeMove(Move.SCISSORS,Move.ROCK));
    }

    @Test
    public void make_move_draw_test(){
        assertEquals(0,gameLogic.makeMove(Move.ROCK,Move.ROCK));
        assertEquals(0,gameLogic.makeMove(Move.PAPER,Move.PAPER));
        assertEquals(0,gameLogic.makeMove(Move.SCISSORS,Move.SCISSORS));
    }
}
