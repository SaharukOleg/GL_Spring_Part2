package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GameImpl implements Game {

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Autowired
    private NumberGenerator numberGenerator;

    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    private int limit = 10; // винести

    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public int checkUserIn() {
        while (limit >= 0) {
            System.out.println("enter number");

            try {
                guess = new Scanner(System.in).nextInt();
                if (guess == number) {
                    System.out.println("YOU WIN !!!");
                    break;
                } else {
                    System.out.println("you lose");
                    limit--;
                }
                if (guess > number) {
                    System.out.println(("Too High. Try a lower number."));
                } else System.out.println("Too Low. Try a higher number.");
            } catch (InputMismatchException ex) {
                System.out.println("enter digits !!!");
                continue;
            }
        }
        return guess;
    }


    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }

}
