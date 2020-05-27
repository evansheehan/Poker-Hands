package main;

public class Hand {

    private static final int HAND_SIZE = 5;


    public static Card[] generateHandFromString(String inputString) {
        String[] stringArr = inputString.split(" ");
        if (stringArr.length != HAND_SIZE) {
            System.out.println("The input string is not the correct length of: " + HAND_SIZE);
            return null;
        }
        Card[] cards = new Card[HAND_SIZE];
        for (int i = 0; i < HAND_SIZE; i++) {
            Card currCard = new Card(stringArr[i]);
            cards[i] = currCard;
        }
        return cards;
    }
    /*public Card getCard(int cardIndex) {
        return cards[cardIndex];
    }

    public int numCards() {
        return cards.length;
    }*/

}
