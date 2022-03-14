import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameLogic;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {GameLogic.class})
public class GameLogicTest {

    @Autowired
    GameLogic gameLogic;

    @Test
    public void test(){
        assertNotNull(gameLogic);
    }
}
