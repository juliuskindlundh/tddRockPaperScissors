package rps;

public class App {
    public static void main(String[] args){
       Result result = new GameContainer(new GameLogic()).playBestOutOfThree();
       switch (result){
           case WIN -> {
               System.out.println("Congratulations you are victorious");
           }
           case LOSE -> {
               System.out.println("Better luck next time");
           }
           case DRAW -> {
               System.out.println("It is a draw");
           }
       }
    }
}
