import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.fail;


public class PokerHandsTest {

    private boolean runStressTest = true;

    @Test
    public void highCardInMiddle() {
        String inputString = "2H 2D KD TH 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, PokerHands.checkHighCard(cards));
    }

    @Test
    public void highCardBeginning() {
        String inputString = "KH 2D 2H TH 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, PokerHands.checkHighCard(cards));
    }

    @Test
    public void highCardEnd() {
        String inputString = "2H 2D 3D TH KS";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, PokerHands.checkHighCard(cards));
    }

    @Test
    public void highCardDuplicate() {
        String inputString = "2H 2D KD TH KS";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, PokerHands.checkHighCard(cards));
    }

    @Test
    public void pairAtBeginning() {
        String inputString = "2H 2D KD TH KS";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, PokerHands.checkPair(cards));
    }

    @Test
    public void pairAtEnd() {
        String inputString = "JH QD KD 2H 2S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, PokerHands.checkPair(cards));
    }

    @Test
    public void pairAtBeginningAndEnd() {
        String inputString = "2H QD KD JH 2S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, PokerHands.checkPair(cards));
    }

    @Test
    public void validTwoPair() {
        String inputString = "2H QD KD KH 2S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, PokerHands.checkTwoPairs(cards));
    }

    //This is checking if a four of a kind also reads true as a two pair.
    @Test
    public void twoPairSameValue() {
        String inputString = "2H 2D 2S 2C 4S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, PokerHands.checkTwoPairs(cards));
    }

    @Test
    public void twoPairSameValueSplit() {
        String inputString = "2H 2D 4S 2C 2S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, PokerHands.checkTwoPairs(cards));
    }

    @Test
    public void twoPairSameValueAtEnd() {
        String inputString = "4H 2H 2D 2C 2S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, PokerHands.checkTwoPairs(cards));
    }

    @Test
    public void twoPairMixed() {
        String inputString = "KH 2H QD 2C KS";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(13, PokerHands.checkTwoPairs(cards));
    }

    @Test
    public void twoPairIncomplete() {
        String inputString = "2H 2D 2S 3C 4S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, PokerHands.checkTwoPairs(cards));
    }

    @Test
    public void validStraightUnordered() {
        String inputString = "3S 2D 5C 4C 6D";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(6, PokerHands.checkStraight(cards));
    }

    @Test
    public void threeOfAKindBeginning() {
        String inputString = "3S 3D 3C 4C 6D";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(3, PokerHands.checkThreeOfAKind(cards));
    }

    @Test
    public void threeOfAKindEnd() {
        String inputString = "AS 5D 3S 3C 3D";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(3, PokerHands.checkThreeOfAKind(cards));
    }

    @Test
    public void threeOfAKindFourSimilar() {
        String inputString = "AS 3H 3S 3C 3D";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(3, PokerHands.checkThreeOfAKind(cards));
    }

    @Test
    public void invalidThreeOfAKind() {
        String inputString = "AS 3H AD 3C 2D";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, PokerHands.checkThreeOfAKind(cards));
    }

    @Test
    public void validStraightBackwards() {
        String inputString = "AS KD QC JC TD";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(14, PokerHands.checkStraight(cards));
    }

    @Test
    public void validStraightForwards() {
        String inputString = "TS JD QC KC AD";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(14, PokerHands.checkStraight(cards));
    }

    @Test
    public void invalidStraightAtEnd() {
        String inputString = "TS JD QC KC KD";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, PokerHands.checkStraight(cards));
    }

    @Test
    public void validFourOfAKind() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "2H 2D 2C 2S 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(2, pokerHands.checkFourOfAKind(cards));
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
    public void invalidFourOfAKind() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "2H 2D 2C 3C 3S";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(-1, pokerHands.checkFourOfAKind(cards));
    }

    @Test
    public void validStraightFlushNumericalValues() {
        PokerHands pokerHands = new PokerHands();
        String inputString = "2H 3H 4H 5H 6H";
        Card[] cards = Hand.generateHandFromString(inputString);
        Assert.assertEquals(6, pokerHands.checkStraightFlush(cards));
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

        try {
            inputString = "2D 2H %H 4H 5H";
            cards = Hand.generateHandFromString(inputString);
            Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

            inputString = "5H 2H 3H 4H 5H";
            cards = Hand.generateHandFromString(inputString);
            Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

            inputString = "2H 3H 4H 5H 6H";
            cards = Hand.generateHandFromString(inputString);
            Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

            inputString = "2H 2D KH 5H 6H";
            cards = Hand.generateHandFromString(inputString);
            Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));

            inputString = "2H 3S 4H 5H 6H";
            cards = Hand.generateHandFromString(inputString);
            Assert.assertEquals(-1, pokerHands.checkStraightFlush(cards));
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void outputHandValuesRandom() {
        String inputString = Hand.generateRandomHand();
        Card[] cards = Hand.generateHandFromString(inputString);
        //outputHandValues(cards);
    }

    @Test
    public void outputHandValuesManual() {
        String inputString = "4H 2H 5S 7H 7D ";
        Card[] cards = Hand.generateHandFromString(inputString);
        //outputHandValues(cards);
    }

    @Test
    public void probabilityStressTest() {

        if (!runStressTest) {return;}

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
        System.out.println("Pair probability: " + String.format("%.4f", ((float)pair/numIterations)*100) + "%");
        System.out.println("Two pair probability: " + String.format("%.4f", ((float)twoPair/numIterations)*100) + "%");
        System.out.println("Three of a kind probability: " + String.format("%.4f", ((float)threeOfAKind/numIterations)*100) + "%");
        System.out.println("Straight probability: " + String.format("%.4f", ((float)straight/numIterations)*100) + "%");
        System.out.println("Flush probability: " + String.format("%.4f", ((float)flush/numIterations)*100) + "%");
        System.out.println("Full House probability: " + String.format("%.4f", ((float)fullHouse/numIterations)*100) + "%");
        System.out.println("Four of a kind probability: " + String.format("%.4f", ((float)fourOfAKind/numIterations)*100) + "%");
        System.out.println("Straight Flush probability: " + String.format("%.4f", ((float)straightFlush/numIterations)*100) + "%");
    }

    //Hands can currently draw duplicates for simplicity.
    @Test
    public void comparisonStressTest() {
        int numIterations = 100;

        for (int i = 0; i < numIterations; i++) {
            String blackHandString = Hand.generateRandomHand();
            String whiteHandString = Hand.generateRandomHand();
            Card[] blackHand = Hand.generateHandFromString(blackHandString);
            Card[] whiteHand = Hand.generateHandFromString(whiteHandString);
            PokerHands.compareHands(blackHand, whiteHand);
        }
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
