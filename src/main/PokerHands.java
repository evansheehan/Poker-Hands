package main;

import java.util.HashMap;
import java.util.HashSet;

public class PokerHands {

    private Card[] blackHand;
    private Card[] whiteHand;

    public static void main(String[] args) {

    }

    public int checkHighCard(Card[] hand) {
        return hand[hand.length].getCardValueAsInt();
    }

    public int checkPair(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return -1;
    }

    public int checkTwoPairs(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return -1;
    }

    public int checkThreeOfAKind(Card[] hand) {
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

    public boolean checkStraight(Card[] hand) {
        int previousValue = hand[0].getCardValueAsInt();
        for (int i = 1; i < hand.length; i++) {
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return false;}
            previousValue = hand[i].getCardValueAsInt();
        }
        return true;
    }

    public boolean checkFlush(Card[] hand) {
        String handSuit = hand[0].getCardSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getCardSuit().equals(handSuit)) return false;
        }
        return true;
    }

    public int checkFourOfAKind(Card[] hand) {
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

    public boolean checkFullHouse(Card[] hand) {
        if (checkThreeOfAKind(hand) != -1) {

        }
        return false;
    }

    public int checkStraightFlush(Card[] hand) {
        //int handRank = hand[hand.length-1].getCardValueAsInt();
        int previousValue = hand[0].getCardValueAsInt();
        String handSuit = hand[0].getCardSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getCardSuit().equals(handSuit)) {return -1;}
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return -1;}
            previousValue = hand[i].getCardValueAsInt();
        }
        return hand[hand.length].getCardValueAsInt();
    }
}
