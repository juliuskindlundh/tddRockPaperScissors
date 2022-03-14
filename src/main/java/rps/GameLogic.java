package rps;

import org.springframework.stereotype.Component;

@Component
public class GameLogic {

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
}
