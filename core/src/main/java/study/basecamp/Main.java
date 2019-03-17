package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";



    public static void main(String[] args) {
        log.info("Guess Number");

        // create context
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

     //    get bean
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);


        //get bean my
        GameImpl gameImp = context.getBean(GameImpl.class);
        // biz logic
        // int guess = numberGenerator.next(); // було


        int guess = gameImp.checkUserIn();
        log.info("My guess = {}", guess);

        // get bean

        Game game = context.getBean(Game.class);

        game.setGuess(guess);

        log.info("Result = {}", game.isGameWon() ? "Win" : "Lose");

        // close context
        context.close();



    }
}
