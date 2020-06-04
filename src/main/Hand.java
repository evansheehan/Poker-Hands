import java.util.HashSet;
import java.util.Random;

public class Hand {

    private static final int HAND_SIZE = 5;

    /**
     *
     * @param inputString Reads a String to be translated into card objects.
     * @return Returns an array of Card objects.
     */
    public static Card[] generateHandFromString(String inputString) {
        HashSet<String> seenCards = new HashSet<>();
        inputString = inputString.trim();
        String[] stringArr = inputString.split(" ");
        Card[] cards = new Card[HAND_SIZE];
        if (stringArr.length != HAND_SIZE) {
            throw new IllegalArgumentException("The input string is not the correct length of: " + HAND_SIZE);
        }
        cards = new Card[HAND_SIZE];
        for (int i = 0; i < HAND_SIZE; i++) {
            if (seenCards.contains(stringArr[i])) {
                throw new IllegalArgumentException("A hand may not contain two of the same cards!");
            }
            Card currCard = new Card(stringArr[i]);
            cards[i] = currCard;
            seenCards.add(stringArr[i]);
        }
        //Currently sorting each hand that's generated...may change later.
        if (cards.length != 0) {
            cards = sortHandBySuit(cards);
        }
        return cards;
    }


    /**
     * Uses insertion sort, which is quick for small arrays.
     * @param cardsIn
     * @return Returns a copy of the input array sorted by the card values.
     */
    public static Card[] sortHandByValue(Card[] cardsIn) {
        Card[] cards = cardsIn.clone();
        for (int i = 0; i < cards.length; i++) {
            for (int j = i; j > 0 && cards[j-1].getCardValueAsInt() > cards[j].getCardValueAsInt(); j--) {
                Card currValue = cards[j];
                cards[j] = cards[j-1];
                cards[j-1] = currValue;
            }
        }
        return cards;
    }

    /**
     * Uses insertion sort, which is quick for small arrays.
     * First sorts the array by suit in alphabetical order (C -> D -> H -> S).
     * Afterwards, sorts by value within each group of suits.
     * @param cardsIn
     * @return Returns a copy of the input array sorted by the card suits.
     */
    public static Card[] sortHandBySuit(Card[] cardsIn) {
        Card[] cards = cardsIn.clone();
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

    /**
     *
     * @return Returns a string of 5 randomly drawn unique cards.
     */
    public static String generateRandomHand() {
        HashSet<String> drawnCards  = new HashSet<>();
        Random random = new Random();
        String inputString = "";
        String[] possibleValues = {"2", "3", "4", "5", "6", "7", "8", "9",
            "T", "J", "Q", "K", "A"};
        String[] possibleSuits = {"C", "D", "H", "S"};
        while (drawnCards.size() < 5) {
            int valueIndex = random.nextInt(possibleValues.length);
            int suitIndex = random.nextInt(possibleSuits.length);
            String stringToAdd = possibleValues[valueIndex] + possibleSuits[suitIndex];
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
