package study.basecamp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import study.basecamp.service.GameService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "study.basecamp")
public class WebConfig {
    @Bean
    public GameService gameService() {
        return new GameService();
    }
}
