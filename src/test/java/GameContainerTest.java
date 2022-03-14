import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import rps.GameContainer;
import rps.Move;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


@SpringBootTest(classes = {GameContainer.class})
public class GameContainerTest {

    @Autowired
    GameContainer gameContainer;

    @Test
    public void test(){
        assertNotNull(gameContainer);
    }

    @Test
    public void generate_cpu_move(){
        Assertions.assertInstanceOf(Move.class,gameContainer.generateCPUMove());
    }

    @Test
    public void process_handle__good_input_test(){
        fail();
    }

    @Test
    public void process_handle_bad_input_test(){
        fail();
    }

}
