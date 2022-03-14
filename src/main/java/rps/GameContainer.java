package rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GameContainer {

    Random random;

    GameContainer(){
        random = new Random();
    }

    public Move generateCPUMove() {
        int a = random.nextInt(3);
        Move cpuMove;
        switch (a){
            case 0: cpuMove = Move.ROCK;
            case 1: cpuMove = Move.PAPER;
            default: cpuMove = Move.SCISSORS;
        }
        return cpuMove;
    }
}
