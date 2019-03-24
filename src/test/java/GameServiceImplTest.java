import org.junit.BeforeClass;
import org.junit.Test;
import study.basecamp.service.GameService;

import static org.junit.Assert.*;

public class GameServiceImplTest {


    private static GameService game;

    @BeforeClass
    public static void init() {
        game = new GameService();
    }

    @Test
    public void whenGameIsCheatedResultIsReturned() {
        String guess = "100";
        game.isGameWon(guess);
        String result = game.getResult();
        assertEquals("Looser!", result);
    }

    @Test
    public void whenGameIsWonResultIsReturned1() {
        String guess = "1";
        game.isGameWon(guess);
        String result = game.getResult();
        assertNotEquals(guess, result);
    }

    @Test
    public void whenWinTest() {
        game.setResult("10");
        String res = game.getResult();
        assertEquals(game.getResult(), res);

    }


}
