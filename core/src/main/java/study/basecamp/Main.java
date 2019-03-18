package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.basecamp.classImpl.GameImpl;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);




    public static void main(String[] args) {
        log.info("Guess Number");

        // create context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanCreator.class);

//        NumberGenerator numberGenerator
//                = context.getBean("numberGenerator", NumberGenerator.class);


        //get bean my
        GameImpl gameImp = context.getBean(GameImpl.class);
        // biz logic
        // int guess = numberGenerator.next(); // було


        int guess = gameImp.checkUserIn();
        log.info("My guess = {}", guess);





      //  log.info("Result = {}", gameImp.isGameWon() ? "Win" : "Lose");

        // close context
        context.close();



    }
}
