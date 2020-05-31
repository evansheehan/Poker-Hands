package main;

import java.util.HashSet;
import java.util.Random;

public class Hand {

    private static final int HAND_SIZE = 5;


    public static Card[] generateHandFromString(String inputString) {
        String[] stringArr = inputString.split(" ");
        Card[] cards = new Card[HAND_SIZE];
        if (stringArr.length != HAND_SIZE) {
            System.out.println("The input string is not the correct length of: " + HAND_SIZE
                + "\nReturning an empty array.");
            return cards;
        }
        cards = new Card[HAND_SIZE];
        for (int i = 0; i < HAND_SIZE; i++) {
            Card currCard = new Card(stringArr[i]);
            cards[i] = currCard;
        }
        //Currently sorting each hand that's generated...may change later.
        cards = sortHandBySuit(cards);
        return cards;
    }

    //Quick implementation of insertion sort. Efficient for this problem because hand size is small(5 cards).
    public static Card[] sortHandByValue(Card[] cardsIn) {
        Card[] cards = cardsIn;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i; j > 0 && cards[j-1].getCardValueAsInt() > cards[j].getCardValueAsInt(); j--) {
                Card currValue = cards[j];
                cards[j] = cards[j-1];
                cards[j-1] = currValue;
            }
        }
        return cards;
    }

    //Sorts by suit first (CDHS) then by rank/value of the card.
    public static Card[] sortHandBySuit(Card[] cardsIn) {
        Card[] cards = cardsIn;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i; j > 0 && cards[j-1].getCardSuitAsInt() > cards[j].getCardSuitAsInt(); j--) {
                Card currValue = cards[j];
                cards[j] = cards[j-1];
                cards[j-1] = currValue;
            }
        }

        //Loops through the previously sorted loop, sorting the values within each card's respective suit.
        //This loop can almost certainly be integrated into the above loop somehow, but the solution is evading me at the moment.
        for (int i = 0; i < cards.length; i++) {
            for (int j = i; j > 0 && cards[j-1].getCardSuitAsInt() == cards[j].getCardSuitAsInt() && cards[j-1].getCardValueAsInt() > cards[j].getCardValueAsInt(); j--) {
                Card currValue = cards[j];
                cards[j] = cards[j-1];
                cards[j-1] = currValue;
            }
        }
        return cards;
    }

    public static String generateRandomHand() {
        HashSet<String> drawnCards  = new HashSet<>();
        Random random = new Random();
        String inputString = "";
        String[] possibleSuits = {"C", "D", "H", "S"};
        while (drawnCards.size() < 5) {
            int value = random.nextInt(9) + 1;
            int suitIndex = random.nextInt(4);
            String stringToAdd = String.valueOf(value + possibleSuits[suitIndex]);
            if (!drawnCards.contains(stringToAdd)){
                inputString += stringToAdd + " ";
                drawnCards.add(stringToAdd);
            }
        }
        System.out.println(inputString);
        return inputString;
    }

    public static int getHandSize() {
        return HAND_SIZE;
    }

    /*public Card getCard(int cardIndex) {
        return cards[cardIndex];
    }

    public int numCards() {
        return cards.length;
    }*/

}
