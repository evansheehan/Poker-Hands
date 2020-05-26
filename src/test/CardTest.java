package test;

import main.Card;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void incorrectCardLengthExtraSpaceAfter() {
        String cardString = "2H ";
        Card card = new Card(cardString);
        Assert.assertEquals(card.getCardValue(), -1);
    }

    @Test
    public void incorrectCardLengthExtraSpaceBefore() {
        String cardString = " 2H";
        Card card = new Card(cardString);
        Assert.assertEquals(card.getCardValue(), -1);
    }

    @Test
    public void incorrectCardLengthExtraDigit() {
        String cardString = "52H";
        Card card = new Card(cardString);
        Assert.assertEquals(card.getCardValue(), -1);
    }

    @Test
    public void incorrectValueZero() {
        String cardString = "0H";
        Card card = new Card(cardString);
        Assert.assertEquals(card.getCardValue(), -1);
    }

    @Test
    public void incorrectValueNonDigit() {
        String cardString = "AH";
        Card card = new Card(cardString);
        Assert.assertEquals(card.getCardValue(), -1);
    }

    @Test
    public void correctValueCorrectSuit() {
        String cardString = "4H";
        Card card = new Card(cardString);
        Assert.assertEquals(card.getCardValue(), 4);
    }

}
