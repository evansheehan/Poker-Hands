package test;

import main.Card;
import main.Hand;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HandTest {

    @Test
    public void basicInputString() {
        String inputString = "2H 3D 5S 9C KD";
        Card[] cards = Hand.generateHandFromString(inputString);
        for (Card card : cards) {
            System.out.println(card.getCardValue() + card.getCardSuit());
        }
    }

    @Test
    public void incorrectHandSize() {
        String inputString = "2H 3D 5S 9C KD AS";
        try {
            Card[] cards = Hand.generateHandFromString(inputString);
        }
        catch (NullPointerException e) {
            System.out.println("Caught null pointer, as expected");
        }
    }

    @Test
    public void handSortTest() {
        String inputString = "2H KD KS AC 5D";
        Card[] cards = Hand.generateHandFromString(inputString);
        //cards = Hand.sortHandBySuit(cards);
        for (Card card : cards) {
            System.out.println(card.getCardValue() + card.getCardSuit());
        }

    }

    @Test
    public void handSortTestMoreMixed() {
        String inputString = "TD 8H 2C QS 6D";
        Card[] cards = Hand.generateHandFromString(inputString);
        //cards = Hand.sortHandBySuit(cards);
        for (Card card : cards) {
            System.out.println(card.getCardValue() + card.getCardSuit());
        }

    }
}
