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

}
