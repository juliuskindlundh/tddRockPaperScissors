package rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

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

    public Move readPlayerMove(Scanner scanner) {
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase(Move.ROCK.name())){
            return Move.ROCK;
        }
        else if(input.equalsIgnoreCase(Move.PAPER.name())){
            return Move.PAPER;
        }
        else if(input.equalsIgnoreCase(Move.SCISSORS.name())){
            return Move.SCISSORS;
        }
        else {
            return Move.NOT_A_REAL_MOVE;
        }
    }
}
