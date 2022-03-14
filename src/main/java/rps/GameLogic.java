package rps;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
public class GameLogic {

    Random random;
    GameLogic(){
        random = new Random();
    }

    public int makeMove(Move playerMove, Move cpuMove) {
        int result = 0;
        if(playerMove.equals(cpuMove)){
            return result;
        }
        switch (playerMove){
            case ROCK -> {
                switch (cpuMove) {
                    case PAPER -> result = -1;
                    case SCISSORS -> result = 1;
                }
            }
            case PAPER -> {
                switch (cpuMove) {
                    case ROCK -> result = 1;
                    case SCISSORS -> result = -1;
                }
            }
            case SCISSORS -> {
                switch (cpuMove) {
                    case ROCK -> result = -1;
                    case PAPER -> result = 1;
                }
            }
        }
        return result;
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
