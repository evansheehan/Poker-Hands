package test;

import main.Card;
import main.Hand;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
    public void emptyHandString() {
        String inputString = "";
        try {
            Card[] cards = Hand.generateHandFromString(inputString);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void lowercaseSuits() {
        String inputString = "2h 3d 5s 9c Kd ";
        Card[] cards = Hand.generateHandFromString(inputString);
        if (cards.length != 5) {fail();}
    }

    @Test
    public void lowercaseValues() {
        String inputString = "tH jH qS tC kD ";
        Card[] cards = Hand.generateHandFromString(inputString);
        if (cards.length != 5) {fail();}
    }

    @Test
    public void lowercaseValuesAndSuits() {
        String inputString = "th jh qs tc kd ";
        Card[] cards = Hand.generateHandFromString(inputString);
        if (cards.length != 5) {fail();}
    }

    @Test
    public void mixedCaseValuesAndSuits() {
        String inputString = "tH Jh qs TC kD ";
        Card[] cards = Hand.generateHandFromString(inputString);
        if (cards.length != 5) {fail();}
    }


    @Test
    public void incorrectHandSize() {
        String inputString = "2H 3D 5S 9C KD AS";
        try {
            Card[] cards = Hand.generateHandFromString(inputString);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail();
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
