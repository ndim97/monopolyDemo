package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(rollDice());
    }

    public static void game(){

        System.out.println("MONOPOLY");
        System.out.println();

        //Preparing for the game

        int numberOfPlayers = selectNumberOfPlayers();
        int housesInBank = 34;
        int hotelsInBank = 13;

        HashMap<Integer, String> gameSquares = prepareGameSquares();
        Stack<String> chanceCards = prepareChanceCards();
        Stack<String> communityChestCards = prepareCommunityChestCards();

        //Start the game



    }

    public static HashMap<Integer,String> prepareGameSquares() {

        HashMap<Integer, String> gameSquares = new HashMap<>();

        gameSquares.put(1, "START/GO");
        gameSquares.put(2,"Old Kent Road");
        gameSquares.put(3, "COMMUNITY CHEST");
        gameSquares.put(4, "Whitechapel Road");
        gameSquares.put(5, "INCOME TAX");
        gameSquares.put(6, "Kingskross Station");
        gameSquares.put(7, "The Angel Islington");
        gameSquares.put(8, "CHANCE");
        gameSquares.put(9, "Euston Road");
        gameSquares.put(10, "Pentonville Road");
        gameSquares.put(11, "IN JAIL - JUST VISITING");
        gameSquares.put(12, "Pall Mall");
        gameSquares.put(13, "Electric Company");
        gameSquares.put(14, "Whitehall");
        gameSquares.put(15, "Northumber Land Avenue");
        gameSquares.put(16, "Marylebone Station");
        gameSquares.put(17, "Bow Street");
        gameSquares.put(18, "COMMUNITY CHEST");
        gameSquares.put(19, "Marlborough Street");
        gameSquares.put(20, "Vine Street");
        gameSquares.put(21, "FREE PARKING");
        gameSquares.put(22, "Strand");
        gameSquares.put(23, "CHANCE");
        gameSquares.put(24, "Fleet Street");
        gameSquares.put(25, "Trafalgar Square");
        gameSquares.put(26, "Fenchurch St Station");
        gameSquares.put(27, "Leicester Square");
        gameSquares.put(28, "Coventry Street");
        gameSquares.put(29, "Water Works");
        gameSquares.put(30, "Piccadilly");
        gameSquares.put(31, "GO TO JAIL");
        gameSquares.put(32, "Regent Street");
        gameSquares.put(33, "Oxford Street");
        gameSquares.put(34, "COMMUNITY CHEST");
        gameSquares.put(35, "Bond Street");
        gameSquares.put(36, "Liverpool St Station");
        gameSquares.put(37, "CHANCE");
        gameSquares.put(38, "Park Lane");
        gameSquares.put(39, "SUPER TAX");
        gameSquares.put(40, "Mayfair");

        return gameSquares;
    }

    public static Stack<String> prepareChanceCards() {

        Stack<String> chanceCards = new Stack<>();

        chanceCards.push("Advance to \"Trafalgar Square\". Collect $200");
        chanceCards.push("Advance to \"Marylebone Station\". If you pass Go, collect $200");
        chanceCards.push("Advance to the nearest Railroad. If unowned, you may buy it from the Bank. " +
                "If owned, pay wonder twice the rental to which they are otherwise entitled");
        chanceCards.push("Get Out of Jail Free! (You can keep the card or sell it.)");
        chanceCards.push("Advance to \"Mayfair\".");
        chanceCards.push("Advance to Go. (Collect $200))");
        chanceCards.push("Pay the housing tax -$150");
        chanceCards.push("Bank pays you dividend of $50");
        chanceCards.push("Go to Jail! (Go directly to Jail, do not pass Go, do not collect $200)");
        chanceCards.push("You have won a crossword puzzle contest. Collect 100 $");
        chanceCards.push("Make general repairs on all your property. For each house pay $25. " +
                "For each hotel pay $100");
        chanceCards.push("Your building loan matures. Collect $150");
        chanceCards.push("Go Back 3 Spaces");
        chanceCards.push(" Advance token to nearest Utility. If unowned, you may buy it from the Bank. " +
                "If owned, throw dice and pay owner a total ten times amount thrown.");
        chanceCards.push("Advance to \"Pall Mall\". If you pass Go, collect $200");
        chanceCards.push("Speeding fine $15");

        //Shuffle the cards
        Collections.shuffle(chanceCards);

        return chanceCards;
    }

    public static Stack<String> prepareCommunityChestCards() {

        Stack<String> communityChestCards = new Stack<>();

        communityChestCards.push("From sale of stock you get $50.");
        communityChestCards.push("Income tax refund. Collect $20.");
        communityChestCards.push("You have won second prize in a beauty contest. Collect $10.");
        communityChestCards.push("Bank error in your favour. Collect $200.");
        communityChestCards.push("It is your happy day! Collect $10 from every player.");
        communityChestCards.push("Pay school fees of $50.");
        communityChestCards.push("Receive $25 consultancy fee.");
        communityChestCards.push("You inherit $100.");
        communityChestCards.push("Get Out of Jail Free! (You can keep the card or sell it.)");
        communityChestCards.push("Holiday fund matures. Receive $100");
        communityChestCards.push("Advance to Go. (Collect £200)");
        communityChestCards.push("Pay a fine of $10 or get a CHANCE card.");
        communityChestCards.push("Go to Jail! (Go directly to jail, do not pass Go, do not collect £200.)");
        communityChestCards.push("Life insurance matures. Collect $100");
        communityChestCards.push("Pay housing fees of $100)");
        communityChestCards.push("Drunkenness fine $15");

        //Shuffle the cards
        Collections.shuffle(communityChestCards);

        return communityChestCards;
    }

    public static int selectNumberOfPlayers() {

        int numberOfPlayers;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Please, enter the number of players [2-4]: ");
            numberOfPlayers = sc.nextInt();

            if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
                return numberOfPlayers;
            } else {
                System.out.println("The number of players must be between 2 and 4!");
                return selectNumberOfPlayers();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input! Enter digit!");
            return selectNumberOfPlayers();
        }
    }

    public static int rollDice() {

        Random rand = new Random();

        int dice1 = rand.nextInt((6 - 1) + 1) + 1;
        int dice2 = rand.nextInt((6 - 1) + 1) + 1;

        int totalNumberOfMoves = dice1 + dice2;

        return totalNumberOfMoves;
    }
}
