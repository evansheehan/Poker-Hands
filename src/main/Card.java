public class Card {
    private String cardValue = "-1";
    private String cardSuit = "";

    public Card(String cardString) {
        cardString = cardString.replaceAll("\\s", "");
        if (cardString.length() != 2) {
            throw new IllegalArgumentException("Card length must equal 2: A card value and a card suit.");
        }
        String localCardValue = cardString.substring(0, 1);
        String localCardSuit = cardString.substring(1, 2);

        //Values 2-9 + Ten, Jack, Queen, King, and Ace
        if (localCardValue.matches("[2-9 | TJQKA | tjqka]")) {
            cardValue = localCardValue.toUpperCase();
        }
        else {
            //System.out.println("Not a valid card value");
            throw new IllegalArgumentException("Not a valid card value");
        }

        //Hearts, Spades, Clubs, and Diamonds
        if (localCardSuit.matches("[HSCD | hcsd]")) {
            cardSuit = localCardSuit.toUpperCase();
        }
        else {
            //System.out.println("Not a valid card suit");
            throw new IllegalArgumentException("Not a valid card value");
        }
    }

    public String getCardValue() {
        return cardValue;
    }

    public String getCardSuit() {
        return cardSuit;
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

    public static String getCardValueAsString(int cardValue) {
        if (cardValue < 10) {
            return String.valueOf(cardValue);
        }
        switch(cardValue) {
            case 10:
                return "Ten";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
        }
        throw new IllegalArgumentException("Something went wrong...card value doesn't match cases.");
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
        throw new IllegalArgumentException("Something went wrong...card suit doesn't match cases.");
    }
}
