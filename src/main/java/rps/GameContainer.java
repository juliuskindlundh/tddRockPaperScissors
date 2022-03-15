package rps;
import org.springframework.stereotype.Component;
@Component
public class GameContainer {

    public GameLogic gameLogic;

    public GameContainer(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public Result playBestOutOfThree() {
        System.out.println("Lets play som ROCK PAPER SCISSORS!");
        int score = 0;
        int rounds = 0;
        while (gameLogic.shouldContinue(score, rounds)) {
            Result result = gameLogic.playRound();
            if(result.equals(Result.WIN)){
                score++;
            }
            else if(result.equals(Result.LOSE)){
                score--;
            }
            rounds++;
        }
        if (score == 0) {
            return Result.DRAW;
        } else if (score < 0) {
            return Result.LOSE;
        } else {
            return Result.WIN;
        }
    }
}
