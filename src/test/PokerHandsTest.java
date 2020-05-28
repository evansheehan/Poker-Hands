package test;

import main.Card;
import main.Hand;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PokerHandsTest {

    @Test
    public void validStraightFlush() {
        String inputString = "1H 2H 3H 4H 5H";
        Card[] cards = Hand.generateHandFromString(inputString);
        System.out.println("Test");
    }

}
