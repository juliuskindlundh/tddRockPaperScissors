import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameContainer;
import rps.Move;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {GameContainer.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;
    Scanner scanner;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }

    @Test
    public void generate_cpu_move(){
        Assertions.assertInstanceOf(Move.class,gameContainer.generateCPUMove());
    }

    @Test
    public void process_handle_good_input_ROCK_test(){
        String input = Move.ROCK.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.ROCK,gameContainer.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_good_input_PAPER_test(){
        String input = Move.PAPER.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.PAPER,gameContainer.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_good_input_SCISSORS_test(){
        String input = Move.SCISSORS.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.SCISSORS,gameContainer.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_bad_input_test(){
        String input = "Move.SCISSORS.name()";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        scanner = new Scanner(System.in);
        assertEquals(Move.NOT_A_REAL_MOVE,gameContainer.readPlayerMove(scanner));
    }

}
