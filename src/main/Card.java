package main;

public class Card {
    private String cardValue = "-1";
    private String cardSuit = "";

    public Card(String cardString) {
        if (cardString.length() != 2) {
            System.out.println("Card length does not equal 2: " + cardString
                    + "...returning without instantiating card values.");
            return;
        }
        String localCardValue = cardString.substring(0, 1);
        String localCardSuit = cardString.substring(1, 2);

        //Also T J Q K A
        if (localCardValue.matches("[1-9 | TJQKA]")) {
            cardValue = localCardValue;
        }
        else {
            System.out.println("Not a valid card value");
        }

        //H S C D
        if (localCardSuit.matches("[HSCD]")) {
            cardSuit = localCardSuit.toUpperCase();
        }
        else {
            System.out.println("Not a valid card suit");
        }
    }

    public String getCardValue() {
        return cardValue;
    }

    public int getCardValueAsInt() {
        if (cardValue.matches("[TJQKA]")) {
            switch (cardValue) {
                case "T":
                    return 10;
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                case "A":
                    return 14;
            }
        }
        return Integer.parseInt(cardValue);
    }

    public int getCardSuitAsInt() {
        switch (cardSuit) {
            case "C":
                return 1;
            case "D":
                return 2;
            case "H":
                return 3;
            case "S":
                return 4;
        }
        System.out.println("Something went wrong...card suit doesn't match cases");
        return -1;
    }

    public String getCardSuit() {
        return cardSuit;
    }
}
