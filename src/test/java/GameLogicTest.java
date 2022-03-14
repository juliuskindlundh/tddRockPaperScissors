import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameLogic;

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
        assertEquals(1,gameLogic.makeMove("ROCK","SCISSORS"));
        assertEquals(1,gameLogic.makeMove("PAPER","ROCK"));
        assertEquals(1,gameLogic.makeMove("SCISSORS","PAPER"));
    }

    @Test
    public void make_move_computer_wins_test(){
        assertEquals(-1,gameLogic.makeMove("ROCK","PAPER"));
        assertEquals(-1,gameLogic.makeMove("PAPER","SCISSORS"));
        assertEquals(-1,gameLogic.makeMove("SCISSORS","ROCK"));
    }

    @Test
    public void make_move_draw_test(){
        assertEquals(0,gameLogic.makeMove("ROCK","ROCK"));
        assertEquals(0,gameLogic.makeMove("PAPER","PAPER"));
        assertEquals(0,gameLogic.makeMove("SCISSORS","SCISSORS"));
    }
}
