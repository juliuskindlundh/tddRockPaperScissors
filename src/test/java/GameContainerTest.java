import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rps.GameContainer;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = {GameContainer.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }
}
