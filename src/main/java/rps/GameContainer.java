package rps;
import org.springframework.stereotype.Component;

@Component
public class GameContainer {

    public GameLogic gameLogic;

    public GameContainer(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public String playBestOutOfThree(){
        int score = 0;
        int rounds = 0;
        //while ()
        return null;
    }



    public Result playRound() {
        Result result = gameLogic.makeMove(gameLogic.readPlayerMove(),gameLogic.generateCPUMove());
        System.out.println(result.name());
        return result;
    }
}
