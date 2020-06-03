package test;

import main.Card;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CardTest {

    @Test
    public void incorrectCardLengthExtraSpaceAfter() {
        String cardString = "2H ";
        try {
            Card card = new Card(cardString);
        }
        catch (IllegalArgumentException e){fail();}
    }

    @Test
    public void incorrectCardLengthExtraSpaceBefore() {
        String cardString = " 2H";
        try {
            Card card = new Card(cardString);
        }
        catch (IllegalArgumentException e){fail();}
    }

    @Test
    public void incorrectCardLengthExtraDigit() {
        String cardString = "52H";
        try {
            Card card = new Card(cardString);
        }
        catch (IllegalArgumentException e){return;}
        fail();
    }

    @Test
    public void incorrectValueZero() {
        String cardString = "0H";
        try {
            Card card = new Card(cardString);
        }
        catch (IllegalArgumentException e){return;}
        fail();
    }

    @Test
    public void incorrectValueNonDigit() {
        String cardString = "VH";
        try {
            Card card = new Card(cardString);
        }
        catch (IllegalArgumentException e){return;}
        fail();
    }

    @Test
    public void incorrectValueSpecialCharacter() {
        String cardString = "%H";
        try {
            Card card = new Card(cardString);
        }
        catch (IllegalArgumentException e){return;}
        fail();
    }

    @Test
    public void correctValueLowercaseSuit() {
        String cardString = "4h";
        Card card = new Card(cardString);
        Assert.assertEquals(4, card.getCardValueAsInt());
    }

    @Test
    public void correctLowercaseValue() {
        String cardString = "tH";
        Card card = new Card(cardString);
        Assert.assertEquals(10, card.getCardValueAsInt());
    }

    @Test
    public void correctValueCorrectSuit() {
        String cardString = "4H";
        Card card = new Card(cardString);
        Assert.assertEquals(4, card.getCardValueAsInt());
    }

    @Test
    public void correctLetterValueCorrectSuit() {
        String cardString = "TD";
        Card card = new Card(cardString);
        Assert.assertEquals(10, card.getCardValueAsInt());
    }

}
