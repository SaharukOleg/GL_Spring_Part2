package study.basecamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.basecamp.classImpl.GameImpl;
import study.basecamp.classImpl.NumberGeneratorImpl;
@Configuration
public class BeanCreator {


    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

//        @Bean("game")
//        public GameImpl gameImpl(){
//            return new GameImpl();
//        }
}