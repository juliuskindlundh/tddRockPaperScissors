import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameContainer;
import rps.GameLogic;
import rps.Result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = {GameContainer.class,GameLogic.class})
public class GameContainerTest {

    GameContainer gameContainer;

    @BeforeEach
    public void setUp(){
        gameContainer = new GameContainer(mock(GameLogic.class));
    }

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }

    @ParameterizedTest
    @ValueSource(strings = {"WIN","LOSE","DRAW"})
    public void play_best_out_of_3_rounds_win_test(String input){
        when(gameContainer.gameLogic.shouldContinue(anyInt(),anyInt())).thenReturn(true).thenReturn(true).thenReturn(false);
        when(gameContainer.gameLogic.playRound()).thenReturn(Result.valueOf(input));
        assertEquals(Result.valueOf(input),gameContainer.playBestOutOfThree());
    }
}
