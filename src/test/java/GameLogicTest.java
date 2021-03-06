import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameLogic;
import rps.Move;
import rps.Result;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        assertEquals(Result.WIN,gameLogic.makeMove(Move.ROCK,Move.SCISSORS));
        assertEquals(Result.WIN,gameLogic.makeMove(Move.PAPER,Move.ROCK));
        assertEquals(Result.WIN,gameLogic.makeMove(Move.SCISSORS,Move.PAPER));
    }

    @Test
    public void make_move_computer_wins_test(){
        assertEquals(Result.LOSE,gameLogic.makeMove(Move.ROCK,Move.PAPER));
        assertEquals(Result.LOSE,gameLogic.makeMove(Move.PAPER,Move.SCISSORS));
        assertEquals(Result.LOSE,gameLogic.makeMove(Move.SCISSORS,Move.ROCK));
    }

    @Test
    public void make_move_draw_test(){
        assertEquals(Result.DRAW,gameLogic.makeMove(Move.ROCK,Move.ROCK));
        assertEquals(Result.DRAW,gameLogic.makeMove(Move.PAPER,Move.PAPER));
        assertEquals(Result.DRAW,gameLogic.makeMove(Move.SCISSORS,Move.SCISSORS));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    public void generate_cpu_move(Integer randomNumber){
        gameLogic.random = mock(Random.class);
        when(gameLogic.random.nextInt(3)).thenReturn(randomNumber);
        assertEquals(randomNumber,gameLogic.generateCPUMove().value);
    }

    @Test
    public void process_handle_good_input_ROCK_test(){
        String input = Move.ROCK.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameLogic.scanner = new Scanner(System.in);
        assertEquals(Move.ROCK,gameLogic.readPlayerMove());
    }

    @Test
    public void process_handle_good_input_PAPER_test(){
        String input = Move.PAPER.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameLogic.scanner = new Scanner(System.in);
        assertEquals(Move.PAPER,gameLogic.readPlayerMove());
    }

    @Test
    public void process_handle_good_input_SCISSORS_test(){
        String input = Move.SCISSORS.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameLogic.scanner = new Scanner(System.in);
        assertEquals(Move.SCISSORS,gameLogic.readPlayerMove());
    }

    @ParameterizedTest
    @MethodSource("shouldContinueProvider")
    public void shouldContinue_test(ArgRes argRes){
        assertEquals(argRes.result,gameLogic.shouldContinue(argRes.score, argRes.rounds));
    }

    private static Stream<ArgRes> shouldContinueProvider(){
        ArgRes[] argRes = {
                new ArgRes(0,0,true),
                new ArgRes(0,1,true),
                new ArgRes(0,2,true),
                new ArgRes(0,3,false),
                new ArgRes(1,1,true),
                new ArgRes(2,2,false),
                new ArgRes(-1,1,true),
                new ArgRes(-2,2,false),
                new ArgRes(1,2,true),
        };
        return Arrays.stream(argRes);
    }

    private static class ArgRes{
        public int score;
        public int rounds;
        public boolean result;

        public ArgRes(int score, int rounds, Boolean result) {
            this.score = score;
            this.rounds = rounds;
            this.result = result;
        }
    }

    @Test
    public void do_one_round_result_draw_test(){
        String input = Move.ROCK.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameLogic.scanner = new Scanner(System.in);
        gameLogic.random = mock(Random.class);
        when(gameLogic.random.nextInt(3)).thenReturn(0);
        assertEquals(Result.DRAW,gameLogic.playRound());
    }

    @Test
    public void do_one_round_result_player_lose_test(){
        String input = Move.ROCK.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameLogic.scanner = new Scanner(System.in);
        gameLogic.random = mock(Random.class);
        when(gameLogic.random.nextInt(3)).thenReturn(1);
        assertEquals(Result.LOSE,gameLogic.playRound());
    }

    @Test
    public void do_one_round_result_player_win_test(){
        String input = Move.ROCK.name();
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        gameLogic.scanner = new Scanner(System.in);
        gameLogic.random = mock(Random.class);
        when(gameLogic.random.nextInt(3)).thenReturn(2);
        assertEquals(Result.WIN,gameLogic.playRound());
    }
}
