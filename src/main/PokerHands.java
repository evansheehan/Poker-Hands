package main;

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

    public boolean checkFourOfAKind(Hand hand) {
        /*for (Card card : hand) {

        }*/
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
            if (hand[i].getCardSuit() != handSuit) {return false;}
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return false;}
        }
        return true;
    }
}
