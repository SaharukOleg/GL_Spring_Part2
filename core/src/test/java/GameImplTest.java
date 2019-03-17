
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import study.basecamp.GameImpl;
import sun.rmi.log.LogHandler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;


public class GameImplTest {

    private static GameImpl gameImpl;

    @BeforeAll
    public static void init(){
        gameImpl = new GameImpl();

    }

    @Before
    public void setup() {

    }

    @Test
    public void checkValidNumberRange(){
                Assertions.assertEquals(gameImpl.isValidNumberRange(),true);
                Assertions.assertTrue(gameImpl.isValidNumberRange());
    }
    @Test
    public void testCheckUserIn() {
        final int expected = 8;
        Assert.assertEquals(expected, 8);
    }

    @Test
    void testCheckUserIn_exception() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });
    }



}
