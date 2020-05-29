package test;

import main.Card;
import main.Hand;
import main.PokerHands;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PokerHandsTest {

    @Test
    public void validFourOfAKind() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "1H 1D 1C 1S 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(true, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void validFourOfAKindSplit() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "KH KD 3C KS KC";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(true, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void validFourOfAKindWrongStart() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "3C KD KH KS KC";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(true, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void invalidFourOfAKing() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "1H 1D 1C 3C 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(false, pokerHands.checkFourOfAKind(cards));
    }

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
