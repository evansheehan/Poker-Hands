package test;

import main.Card;
import main.Hand;
import main.PokerHands;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PokerHandsTest {

    @Test
    public void validStraightFlushNumericalValues() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "1H 2H 3H 4H 5H";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(true, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void validStraightFlushNumericalAndLetteredValues() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "9H TH JH QH KH";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(true, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void validStraightFlushNumericalAndLetteredValuesUnordered() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "TH JH KH QH 9H";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(true, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void invalidStraightFlush() {
        PokerHands pokerHands = new PokerHands();
        Card[] cards;
        String inputString;

        inputString = "1H 2H %H 4H 5H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(false, pokerHands.checkStraightFlush(cards));

        inputString = "5H 2H 3H 4H 5H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(false, pokerHands.checkStraightFlush(cards));

        inputString = "1H 3H 4H 5H 6H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(false, pokerHands.checkStraightFlush(cards));

        inputString = "1H 2H KH 5H 6H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(false, pokerHands.checkStraightFlush(cards));

        inputString = "2H 3S 4H 5H 6H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(false, pokerHands.checkStraightFlush(cards));
    }

}
