package main;

import java.util.HashMap;
import java.util.HashSet;

public class PokerHands {

    private Card[] blackHand;
    private Card[] whiteHand;

    public static void main(String[] args) {

    }

    public boolean checkHighCard(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkPair(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkTwoPairs(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkThreeOfAKind(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkStraight(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkFlush(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkFourOfAKind(Card[] hand) {
        int matches = 1;
        for (int i = 0; i <= Hand.getHandSize() - 4; i++) {
            int checkValue = hand[i].getCardValueAsInt();
            for (int j = i+1; j < hand.length; j++) {
                if (checkValue == hand[j].getCardValueAsInt()) {
                    matches++;
                }
            }
            if (matches == 4) {return true;}
            matches = 1;
        }
        return false;
    }

    public boolean checkFullHouse(Hand hand) {
        /*for (Card card : hand) {

        }*/
        return false;
    }

    public boolean checkStraightFlush(Card[] hand) {
        int handRank = hand[hand.length-1].getCardValueAsInt();
        int previousValue = hand[0].getCardValueAsInt();
        String handSuit = hand[0].getCardSuit();
        for (int i = 1; i < hand.length; i++) {
            if (!hand[i].getCardSuit().equals(handSuit)) {return false;}
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return false;}
            previousValue = hand[i].getCardValueAsInt();
        }
        return true;
    }
}
