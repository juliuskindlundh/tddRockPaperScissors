import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import rps.GameContainer;
import rps.Move;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {GameContainer.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;
    Scanner scanner;

    @BeforeEach
    public void setUp(){
        scanner = mock(Scanner.class);
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
        when(scanner.nextLine()).thenReturn("ROCK");
        assertEquals(Move.ROCK,gameContainer.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_good_input_PAPER_test(){
        when(scanner.nextLine()).thenReturn("PAPER");
        assertEquals(Move.PAPER,gameContainer.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_good_input_SCISSORS_test(){
        when(scanner.nextLine()).thenReturn("SCISSORS");
        assertEquals(Move.SCISSORS,gameContainer.readPlayerMove(scanner));
    }

    @Test
    public void process_handle_bad_input_test(){
        fail();
    }

}
