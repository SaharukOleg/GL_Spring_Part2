package study.basecamp.service;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component

public class GameService {

    private final Random random = new Random();
    private String result;

    public void isGameWon(String num) {

        int number = random.nextInt(2);
        int guess = Integer.parseInt(num);

        result = (guess == number) ? "Winner!" : "Looser!";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
}
}
