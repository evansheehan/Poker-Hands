package test;

import main.Card;
import main.Hand;
import main.PokerHands;
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;
import java.util.HashSet;

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
        String inputString = Hand.generateRandomHand();
        Card[] cards = Hand.generateHandFromString(inputString);
        outputHandValues(cards);
    }

    @Test
    public void outputHandValuesManual() {
        String inputString = "4H 1H 5S 7H 7D ";
        Card[] cards = Hand.generateHandFromString(inputString);
        outputHandValues(cards);
    }

    @Test
    public void probabilityStressTest() {
        int numIterations = 500000;
        int pair = 0;
        int twoPair = 0;
        int threeOfAKind = 0;
        int straight = 0;
        int flush = 0;
        int fullHouse = 0;
        int fourOfAKind = 0;
        int straightFlush = 0;
        for (int i = 0; i < numIterations; i++) {
            String randomHandString = Hand.generateRandomHand();
            Card[] randomHand = Hand.generateHandFromString(randomHandString);
            if (PokerHands.checkPair(randomHand) != -1) {pair++;}
            if (PokerHands.checkTwoPairs(randomHand) != -1) {twoPair++;}
            if (PokerHands.checkThreeOfAKind(randomHand) != -1) {threeOfAKind++;}
            if (PokerHands.checkStraight(randomHand) != -1) {straight++;}
            if (PokerHands.checkFlush(randomHand) != -1) {flush++;}
            if (PokerHands.checkFullHouse(randomHand) != -1) {fullHouse++;}
            if (PokerHands.checkFourOfAKind(randomHand) != -1) {fourOfAKind++;}
            if (PokerHands.checkStraightFlush(randomHand) != -1) {straightFlush++;}
        }
        System.out.println("Pair probability: " + (float)pair/numIterations);
        System.out.println("Two pair probability: " + (float)twoPair/numIterations);
        System.out.println("Three of a kind probability: " + (float)threeOfAKind/numIterations);
        System.out.println("Straight probability: " + (float)straight/numIterations);
        System.out.println("Flush probability: " + (float)flush/numIterations);
        System.out.println("Full House probability: " + (float)fullHouse/numIterations);
        System.out.println("Four of a kind probability: " + (float)fourOfAKind/numIterations);
        System.out.println("Straight Flush probability: " + (float)straightFlush/numIterations);
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
}
