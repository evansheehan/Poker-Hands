import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PokerHands {

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to this poker hand determiner!" +
                "\nThis program is reading the input text file in path Poker-Hands/out/artifacts/Poker-Hands_jar/" +
                "\nPlease input at least two hands to compare in the format specified" +
                " by the Poker Hands Kata page.\n");

        Scanner scan = new Scanner("");
        try {
            File file = new File("input.txt");
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        String currLine;
        while (scan.hasNextLine()) {
            currLine = scan.nextLine();
            if (currLine.equalsIgnoreCase("exit")) {
                break;
            }

            String blackHandString = "";
            String whiteHandString = "";

            try {
                blackHandString = currLine.substring(currLine.indexOf(":") + 1, currLine.indexOf("W") - 1);
                whiteHandString = currLine.substring(currLine.lastIndexOf(":") + 1, currLine.length());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                Card[] blackHand = Hand.generateHandFromString(blackHandString);
                Card[] whiteHand = Hand.generateHandFromString(whiteHandString);
                compareHands(blackHand, whiteHand);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    }

    public static void compareHands(Card[] blackHand, Card[] whiteHand) {
        int blackScore = -1;
        int whiteScore = -1;

        blackScore = checkStraightFlush(blackHand);
        whiteScore = checkStraightFlush(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with straight flush: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with straight flush: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkFourOfAKind(blackHand);
        whiteScore = checkFourOfAKind(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with four of a kind: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with four of a kind: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkFullHouse(blackHand);
        whiteScore = checkFullHouse(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with full house: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with full house: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkFlush(blackHand);
        whiteScore = checkFlush(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with flush: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with flush: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkStraight(blackHand);
        whiteScore = checkStraight(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with straight: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with straight: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkThreeOfAKind(blackHand);
        whiteScore = checkThreeOfAKind(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with three of a kind: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with three of a kind: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkTwoPairs(blackHand);
        whiteScore = checkTwoPairs(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with two pairs: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with two pairs: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        blackScore = checkPair(blackHand);
        whiteScore = checkPair(whiteHand);

        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with a pair: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with a pair: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        else if (blackScore != -1) {
            System.out.println("Tie");
            return;
        }

        compareHighCards(blackHand, whiteHand);
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkHighCard(Card[] handIn) {
        return Hand.sortHandByValue(handIn.clone())[handIn.length-1].getCardValueAsInt();
    }

    /**
     * An extra method specifically for handling hands that have similar high cards.
     * @param blackHand
     * @param whiteHand
     */
    public static void compareHighCards(Card[] blackHand, Card[] whiteHand) {
        blackHand = Hand.sortHandByValue(blackHand.clone());
        whiteHand = Hand.sortHandByValue(whiteHand.clone());

        int blackScore = blackHand[blackHand.length-1].getCardValueAsInt();
        int whiteScore = whiteHand[whiteHand.length-1].getCardValueAsInt();

        for (int i = blackHand.length-2; blackScore == whiteScore && i > 0; i--) {
            blackScore = blackHand[i].getCardValueAsInt();
            whiteScore = whiteHand[i].getCardValueAsInt();
        }
        if (blackScore > whiteScore) {
            System.out.println("Black wins. - with high card: " + Card.getCardValueAsString(blackScore));
            return;
        }
        else if (whiteScore > blackScore) {
            System.out.println("White wins. - with high card: " + Card.getCardValueAsString(whiteScore));
            return;
        }
        System.out.println("Tie");
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return Returns the rank of the first pair it sees.
     * If there is more than one pair, it will only return the lower rank.
     */
    public static int checkPair(Card[] handIn) {
        Card[] hand = Hand.sortHandByValue(handIn.clone());
        for (int i = 0; i <= Hand.getHandSize() - 2; i++) {
            int currValue = hand[i].getCardValueAsInt();
            int nextValue = hand[i+1].getCardValueAsInt();
            if (currValue == nextValue) {return currValue;}
        }
        return -1;
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkTwoPairs(Card[] handIn) {
        Card[] hand = Hand.sortHandByValue(handIn.clone());
        int pairs = 0;
        int highestRank = -1;
        for (int i = 0; i <= Hand.getHandSize() - 2; i++) {
            int currCardValue = hand[i].getCardValueAsInt();
            int nextCardValue = hand[i+1].getCardValueAsInt();
            if (currCardValue == nextCardValue) {
                pairs++;
                if (highestRank < currCardValue) {
                    highestRank = currCardValue;
                }
                i++;
            }
        }
        if (pairs == 2) {
            return highestRank;
        }
        return -1;
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkThreeOfAKind(Card[] handIn) {
        int matches = 1;
        for (int i = 0; i <= Hand.getHandSize() - 3; i++) {
            int checkValue = handIn[i].getCardValueAsInt();
            for (int j = i+1; j < handIn.length; j++) {
                if (checkValue == handIn[j].getCardValueAsInt()) {
                    matches++;
                }
            }
            if (matches == 3) {return handIn[i].getCardValueAsInt();}
            matches = 1;
        }
        return -1;
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkStraight(Card[] handIn) {
        Card[] hand = Hand.sortHandByValue(handIn.clone());
        int previousValue = hand[0].getCardValueAsInt();
        for (int i = 1; i < hand.length; i++) {
            if (previousValue + 1 != hand[i].getCardValueAsInt()) {return -1;}
            previousValue = hand[i].getCardValueAsInt();
        }
        return hand[hand.length-1].getCardValueAsInt();
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkFlush(Card[] handIn) {
        String handSuit = handIn[0].getCardSuit();
        for (int i = 1; i < handIn.length; i++) {
            if (!handIn[i].getCardSuit().equals(handSuit)) {return -1;}
        }
        return handIn[handIn.length-1].getCardValueAsInt();
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkFullHouse(Card[] handIn) {
        int threeOfAKind = checkThreeOfAKind(handIn);
        if (threeOfAKind != -1) {
            int val1 = -1;
            int val2 = -1;
            int i;
            for (i = 0; i < handIn.length && val1 == -1; i++) {
                if (handIn[i].getCardValueAsInt() != threeOfAKind) {val1 = handIn[i].getCardValueAsInt();}
            }
            for (int j = i; j < handIn.length && val2 == -1; j++) {
                if (handIn[j].getCardValueAsInt() != threeOfAKind) {val2 = handIn[j].getCardValueAsInt();}
            }
            if (val1 == val2) {return threeOfAKind;}
            return -1;
        }
        return -1;
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkFourOfAKind(Card[] handIn) {
        int matches = 1;
        for (int i = 0; i <= Hand.getHandSize() - 4; i++) {
            int checkValue = handIn[i].getCardValueAsInt();
            for (int j = i+1; j < handIn.length; j++) {
                if (checkValue == handIn[j].getCardValueAsInt()) {
                    matches++;
                }
            }
            if (matches == 4) {return handIn[i].getCardValueAsInt();}
            matches = 1;
        }
        return -1;
    }

    /**
     *
     * @param handIn Reads in an array of Card objects.
     * @return
     */
    public static int checkStraightFlush(Card[] handIn) {
        int previousValue = handIn[0].getCardValueAsInt();
        String handSuit = handIn[0].getCardSuit();
        for (int i = 1; i < handIn.length; i++) {
            if (!handIn[i].getCardSuit().equals(handSuit)) {return -1;}
            if (previousValue + 1 != handIn[i].getCardValueAsInt()) {return -1;}
            previousValue = handIn[i].getCardValueAsInt();
        }
        return handIn[handIn.length-1].getCardValueAsInt();
    }
}
