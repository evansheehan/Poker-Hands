package test;

import main.Card;
import main.Hand;
import main.PokerHands;
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

public class PokerHandsTest {

    @Test
    public void validFourOfAKind() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "1H 1D 1C 1S 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(1, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void validFourOfAKindSplit() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "KH KD 3C KS KC";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void validFourOfAKindWrongStart() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "3C KD KH KS KC";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void invalidFourOfAKing() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "1H 1D 1C 3C 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void validStraightFlushNumericalValues() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "1H 2H 3H 4H 5H";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(5, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void validStraightFlushNumericalAndLetteredValues() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "9H TH JH QH KH";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void validStraightFlushNumericalAndLetteredValuesUnordered() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "TH JH KH QH 9H";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void invalidStraightFlush() {
        PokerHands pokerHands = new PokerHands();
        Card[] cards;
        String inputString;

        inputString = "1H 2H %H 4H 5H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

        inputString = "5H 2H 3H 4H 5H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

        inputString = "1H 3H 4H 5H 6H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

        inputString = "1H 2H KH 5H 6H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

        inputString = "2H 3S 4H 5H 6H";
        cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));
    }

    @Test
    public void outputHandValuesRandom() {
        String inputString = generateRandomHand();
        Card[] cards = Hand.generateHandFromString(inputString);
        outputHandValues(cards);
    }

    @Test
    public void outputHandValuesManual() {
        String inputString = "4H 1H 5S 7H 7D ";
        Card[] cards = Hand.generateHandFromString(inputString);
        outputHandValues(cards);
    }

    public void outputHandValues(Card[] cards) {
        System.out.println("High Card Returns: " + PokerHands.checkHighCard(cards));
        System.out.println("Pair Check Returns: " + PokerHands.checkPair(cards));
        System.out.println("Two Pair Check Returns: " + PokerHands.checkTwoPairs(cards));
        System.out.println("Three of a Kind Check Returns: " + PokerHands.checkThreeOfAKind(cards));
        System.out.println("Straight Check Returns: " + PokerHands.checkStraight(cards));
        System.out.println("Flush Check Returns: " + PokerHands.checkFlush(cards));
        System.out.println("Full House Check Returns: " + PokerHands.checkFullHouse(cards));
        System.out.println("Four of a Kind Check Returns: " + PokerHands.checkFourOfAKind(cards));
        System.out.println("Straight Flush Check Returns: " + PokerHands.checkStraightFlush(cards));
    }

    //Doesn't currently generate only unique cards
    public String generateRandomHand() {
        Random random = new Random();
        String inputString = "";
        String[] possibleSuits = {"C", "D", "H", "S"};
        for (int i = 0; i < Hand.getHandSize(); i++) {
            int value = random.nextInt(9) + 1;
            int suitIndex = random.nextInt(4);
            inputString += String.valueOf(value) + possibleSuits[suitIndex] + " ";
        }
        System.out.println(inputString);
        return inputString;
    }

}
