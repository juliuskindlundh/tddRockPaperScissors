import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameContainer;
import rps.GameLogic;
import rps.Move;
import rps.Result;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {GameContainer.class,GameLogic.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;
    Scanner scanner;

    @BeforeEach
    public void setUp(){
        gameContainer.gameLogic = mock(GameLogic.class);
        scanner = new Scanner(System.in);
    }

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }

    @Test
    public void do_one_round_test(){
        when(gameContainer.gameLogic.generateCPUMove()).thenReturn(Move.ROCK);
        when(gameContainer.gameLogic.readPlayerMove(scanner)).thenReturn(Move.ROCK);
        assertEquals(Result.DRAW,gameContainer.playRound());

    }



}
