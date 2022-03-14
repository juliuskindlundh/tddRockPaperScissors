import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameLogic;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(gameLogic.makeMove("ROCK","SCISSORS"));
        assertTrue(gameLogic.makeMove("PAPER","ROCK"));
        assertTrue(gameLogic.makeMove("SCISSORS","PAPER"));
    }

    @Test
    public void make_move_computer_wins_test(){
        assertTrue(gameLogic.makeMove("ROCK","PAPER"));
        assertTrue(gameLogic.makeMove("PAPER","SCISSORS"));
        assertTrue(gameLogic.makeMove("SCISSORS","ROCK"));
    }

    @Test
    public void make_move_draw_test(){
        assertTrue(gameLogic.makeMove("ROCK","ROCK"));
        assertTrue(gameLogic.makeMove("PAPER","PAPER"));
        assertTrue(gameLogic.makeMove("SCISSORS","SCISSORS"));
    }
}
