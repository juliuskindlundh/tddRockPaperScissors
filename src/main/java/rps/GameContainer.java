package rps;
import org.springframework.stereotype.Component;

@Component
public class GameContainer {

    public GameLogic gameLogic;

    public GameContainer(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public Result playBestOutOfThree() {
        int score = 0;
        int rounds = 0;
        while (gameLogic.shouldContinue(score, rounds)) {
            Result result = gameLogic.playRound();
            System.out.println("Result:"+result);
            if(result.equals(Result.WIN)){
                score++;
            }
            else if(result.equals(Result.LOSE)){
                score--;
            }
            rounds++;
        }
        System.out.println(score);
        if (score == 0) {
            return Result.DRAW;
        } else if (score < 0) {
            return Result.LOSE;
        } else {
            return Result.WIN;
        }
    }
}
