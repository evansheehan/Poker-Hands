package main;

public class Card {
    private int cardValue = 0;
    private String cardSuit = "";

    public Card(String cardString) {
        if (cardString.length() != 2) {
            System.out.println("Read invalid card value: " + cardString
                + "...returning without instantiating card.");
            return;
        }
        cardValue = Integer.parseInt(cardString.substring(0, 0));
        cardSuit = cardString.substring(1, 1);
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getCardSuit() {
        return cardSuit;
    }
}
