package rps;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
public class GameLogic {

    public Random random;
    public Scanner scanner;

    GameLogic(){
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public Result makeMove(Move playerMove, Move cpuMove) {
        Result result = Result.DRAW;
        if(playerMove.equals(cpuMove)){
            return result;
        }
        switch (playerMove){
            case ROCK -> {
                switch (cpuMove) {
                    case PAPER -> result = Result.LOSE;
                    case SCISSORS -> result = Result.WIN;
                }
            }
            case PAPER -> {
                switch (cpuMove) {
                    case ROCK -> result = Result.WIN;
                    case SCISSORS -> result = Result.LOSE;
                }
            }
            case SCISSORS -> {
                switch (cpuMove) {
                    case ROCK -> result = Result.LOSE;
                    case PAPER -> result = Result.WIN;
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
            break;
            case 1: cpuMove = Move.PAPER;
            break;
            default: cpuMove = Move.SCISSORS;
        }
        System.out.println("CPU plays "+cpuMove.name());
        return cpuMove;
    }

    public Move readPlayerMove() {
        Move move = Move.NOT_A_REAL_MOVE;
        while (move.equals(Move.NOT_A_REAL_MOVE)){
            System.out.print("Make your move...");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase(Move.ROCK.name())){
                move = Move.ROCK;
            }
            else if(input.equalsIgnoreCase(Move.PAPER.name())){
                move = Move.PAPER;
            }
            else if(input.equalsIgnoreCase(Move.SCISSORS.name())){
                move = Move.SCISSORS;
            }
            else{
                System.out.println("...Not a valid move");
            }
        }
        return move;
    }

    public boolean shouldContinue(int score,int rounds){
        if(rounds == 3){
            return false;
        }
        if(score == 2 || score == -2){
            return false;
        }
        return true;
    }

    public Result playRound() {
        Result result = makeMove(readPlayerMove(),generateCPUMove());
        System.out.println(result.name());
        return result;
    }
}
