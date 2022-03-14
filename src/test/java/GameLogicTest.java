import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameLogic;
import rps.Move;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {GameLogic.class})
public class GameLogicTest {

    @Autowired
    GameLogic gameLogic;
    Scanner scanner;

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

    @Test
    public void generate_cpu_move(){
        Assertions.assertInstanceOf(Move.class,gameLogic.generateCPUMove());
    }

    @Test
    public void process_handle_good_input_ROCK_test(){
        String input = Move.ROCK.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.ROCK,gameLogic.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_good_input_PAPER_test(){
        String input = Move.PAPER.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.PAPER,gameLogic.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_good_input_SCISSORS_test(){
        String input = Move.SCISSORS.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.SCISSORS,gameLogic.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_bad_input_test(){
        String input = "Move.SCISSORS.name()";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.NOT_A_REAL_MOVE,gameLogic.readPlayerMove(scanner));
    }
}
