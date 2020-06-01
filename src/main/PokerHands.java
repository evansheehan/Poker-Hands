package main;

import java.util.HashMap;
import java.util.HashSet;

public class PokerHands {

    private Card[] blackHand;
    private Card[] whiteHand;

    public static void main(String[] args) {

    }

    public static int checkHighCard(Card[] hand) {
        return Hand.sortHandByValue(hand)[hand.length-1].getCardValueAsInt();
    }

    public static int checkPair(Card[] hand) {
        int matches = 1;
        for (int i = 0; i <= Hand.getHandSize() - 2; i++) {
            int checkValue = hand[i].getCardValueAsInt();
            for (int j = i+1; j < Hand.getHandSize(); j++) {
                if (checkValue == hand[j].getCardValueAsInt()) {
                    matches++;
                }
            }
            if (matches == 2) {return hand[i].getCardValueAsInt();}
            matches = 1;
        }
        return -1;
    }

    public static int checkTwoPairs(Card[] hand) {
        int firstPair = checkPair(hand);
        if (firstPair != -1) {
            int val1 = -1;
            int val2 = -1;
            for (int i = 0; i <= Hand.getHandSize() - 2; i++) {
                if (hand[i].getCardValueAsInt() != firstPair) {
                    if (val1 == -1) {
                        val1 = hand[i].getCardValueAsInt();
                    }
                    else if (val2 == -1) {
                        val2 = hand[i].getCardValueAsInt();
                    }
                    else if (hand[i].getCardValueAsInt() == val1 | hand[i].getCardValueAsInt() == val2) {
                        return hand[i].getCardValueAsInt();
                    }
                }
            }
        }
        return -1;
    }

    public static int checkThreeOfAKind(Card[] hand) {
        int matches = 1;
        for (int i = 0; i <= Hand.getHandSize() - 3; i++) {
            int checkValue = hand[i].getCardValueAsInt();
            for (int j = i+1; j < hand.length; j++) {
                if (checkValue == hand[j].getCardValueAsInt()) {
                    matches++;
                }
            }
            if (matches == 3) {return hand[i].getCardValueAsInt();}
            matches = 1;
        }
        return -1;
    }

    public static int checkStraight(Card[] hand) {
        int previousValue = hand[0].getCardValueAsInt();
        for (int i = 1; i < hand.length; i++) {
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return -1;}
            previousValue = hand[i].getCardValueAsInt();
        }
        return hand[hand.length-1].getCardValueAsInt();
    }

    public static int checkFlush(Card[] hand) {
        String handSuit = hand[0].getCardSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getCardSuit().equals(handSuit)) return -1;
        }
        return hand[hand.length-1].getCardValueAsInt();
    }

    public static int checkFullHouse(Card[] hand) {
        int threeOfAKind = checkThreeOfAKind(hand);
        if (threeOfAKind != -1) {
            int val1 = -1;
            int val2 = -1;
            int i;
            for (i = 0; i < hand.length && val1 == -1; i++) {
                if (hand[i].getCardValueAsInt() != threeOfAKind) {val1 = hand[i].getCardValueAsInt();}
            }
            for (i = i; i < hand.length && val2 == -1; i++) {
                if (hand[i].getCardValueAsInt() != threeOfAKind) {val2 = hand[i].getCardValueAsInt();}
            }
            if (val1 == val2) {return threeOfAKind;}
            return -1;
        }
        return -1;
    }

    public static int checkFourOfAKind(Card[] hand) {
        int matches = 1;
        for (int i = 0; i <= Hand.getHandSize() - 4; i++) {
            int checkValue = hand[i].getCardValueAsInt();
            for (int j = i+1; j < hand.length; j++) {
                if (checkValue == hand[j].getCardValueAsInt()) {
                    matches++;
                }
            }
            if (matches == 4) {return hand[i].getCardValueAsInt();}
            matches = 1;
        }
        return -1;
    }

    public static int checkStraightFlush(Card[] hand) {
        int previousValue = hand[0].getCardValueAsInt();
        String handSuit = hand[0].getCardSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getCardSuit().equals(handSuit)) {return -1;}
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return -1;}
            previousValue = hand[i].getCardValueAsInt();
        }
        return hand[hand.length-1].getCardValueAsInt();
    }
}
