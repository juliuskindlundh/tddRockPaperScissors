package rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class GameContainer {

    public GameLogic gameLogic;

    public GameContainer(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public Result playRound() {
        return gameLogic.makeMove(gameLogic.readPlayerMove(),gameLogic.generateCPUMove());
    }
}
