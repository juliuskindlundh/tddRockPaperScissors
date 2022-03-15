import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameContainer;
import rps.GameLogic;
import rps.Move;
import rps.Result;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {GameContainer.class,GameLogic.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;

    @BeforeEach
    public void setUp(){
        gameContainer.gameLogic = mock(GameLogic.class);
    }

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }

    @Test
    public void do_one_round_result_draw_test(){
        when(gameContainer.gameLogic.readPlayerMove()).thenReturn(Move.ROCK);
        when(gameContainer.gameLogic.generateCPUMove()).thenReturn(Move.ROCK);
        when(gameContainer.gameLogic.makeMove(Move.ROCK,Move.ROCK)).thenReturn(Result.DRAW);
        assertEquals(Result.DRAW,gameContainer.playRound());
    }

    @Test
    public void do_one_round_result_player_lose_test(){
        when(gameContainer.gameLogic.readPlayerMove()).thenReturn(Move.ROCK);
        when(gameContainer.gameLogic.generateCPUMove()).thenReturn(Move.PAPER);
        when(gameContainer.gameLogic.makeMove(Move.ROCK,Move.PAPER)).thenReturn(Result.LOSE);
        assertEquals(Result.LOSE,gameContainer.playRound());
    }

    @Test
    public void do_one_round_result_player_win_test(){
        when(gameContainer.gameLogic.readPlayerMove()).thenReturn(Move.ROCK);
        when(gameContainer.gameLogic.generateCPUMove()).thenReturn(Move.SCISSORS);
        when(gameContainer.gameLogic.makeMove(Move.ROCK,Move.SCISSORS)).thenReturn(Result.WIN);
        assertEquals(Result.WIN,gameContainer.playRound());
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings = {"WIN","LOSE","DRAW"})
    public void play_best_out_of_3_rounds_win_test(String input){
        when(gameContainer.playRound()).thenReturn(Result.valueOf(input));
        assertEquals(Result.valueOf(input),gameContainer.playBestOutOfThree());

    }



}
