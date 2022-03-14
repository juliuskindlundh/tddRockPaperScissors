import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameContainer;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {GameContainer.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }

    @Test
    public void test_run_with_all_draw(){
        assertEquals(GameEnding.DRAW,gameContainer.run());
    }



}
