package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        game();
    }

    public static void game() {

        System.out.println("MONOPOLY");
        System.out.println();

        //Preparing for the game

        int numberOfPlayers = selectNumberOfPlayers();
        HashMap<Integer, String> playersNames = enterPlayersNames(numberOfPlayers);
        HashMap<String, Integer> playersCurrentPositionOnGameBoard = createHashMapForInitialPlayerPositionsOnGameBoard(playersNames);
        HashMap<Integer, Integer> playersMoney = prepareInitialPlayersMoney(numberOfPlayers);

        int housesInBank = 34;
        int hotelsInBank = 13;

        HashMap<Integer, String> gameSquares = prepareGameSquares();
        HashMap<Integer, Integer> squaresPrice = prepareSquaresPrice();
        Stack<String> chanceCards = prepareChanceCards();
        Stack<String> communityChestCards = prepareCommunityChestCards();

        HashMap<Integer, String> squaresOwners = createHashMapForInitialSquareOwners(gameSquares);

        //Start the game

        showMessageForStartTheGame(gameSquares);

        moveTracker(numberOfPlayers, playersNames, gameSquares, playersCurrentPositionOnGameBoard,
                playersMoney, squaresOwners, squaresPrice);

        
    }

    public static HashMap<Integer, String> prepareGameSquares() {

        HashMap<Integer, String> gameSquares = new HashMap<>();

        gameSquares.put(1, "START/GO");
        gameSquares.put(2, "Old Kent Road");
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

    public static HashMap<Integer, Integer> prepareSquaresPrice() {
        HashMap<Integer, Integer> squaresPrice = new HashMap<>();

        squaresPrice.put(1, null);
        squaresPrice.put(2, 60);
        squaresPrice.put(3, null);
        squaresPrice.put(4, 60);
        squaresPrice.put(5, null);
        squaresPrice.put(6, 200);
        squaresPrice.put(7, 100);
        squaresPrice.put(8, null);
        squaresPrice.put(9, 100);
        squaresPrice.put(10, 120);
        squaresPrice.put(11, null);
        squaresPrice.put(12, 140);
        squaresPrice.put(13, 150);
        squaresPrice.put(14, 140);
        squaresPrice.put(15, 160);
        squaresPrice.put(16, 200);
        squaresPrice.put(17, 180);
        squaresPrice.put(18, null);
        squaresPrice.put(19, 180);
        squaresPrice.put(20, 200);
        squaresPrice.put(21, null);
        squaresPrice.put(22, 220);
        squaresPrice.put(23, null);
        squaresPrice.put(24, 220);
        squaresPrice.put(25, 240);
        squaresPrice.put(26, 200);
        squaresPrice.put(27, 260);
        squaresPrice.put(28, 260);
        squaresPrice.put(29, 150);
        squaresPrice.put(30, 280);
        squaresPrice.put(31, null);
        squaresPrice.put(32, 300);
        squaresPrice.put(33, 300);
        squaresPrice.put(34, null);
        squaresPrice.put(35, 320);
        squaresPrice.put(36, 200);
        squaresPrice.put(37, null);
        squaresPrice.put(38, 350);
        squaresPrice.put(39, null);
        squaresPrice.put(40, 400);

        return squaresPrice;
    }

    public static int selectNumberOfPlayers() {

        int numberOfPlayers;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Please, enter the number of players [2-4]: ");
            numberOfPlayers = sc.nextInt();

            if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
                return numberOfPlayers;
            }

            else {
                System.out.println("The number of players must be between 2 and 4!");
                return selectNumberOfPlayers();
            }
        }

        catch (InputMismatchException e) {
            System.out.println("Wrong input! Enter digit!");
            return selectNumberOfPlayers();
        }
    }

    public static HashMap<Integer, String> enterPlayersNames(int numberOfPlayers) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> playersNames = new HashMap<>();

        System.out.println("Now, enter your names...");

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Player " + i + ", enter your name: ");
            String playerName = sc.nextLine();

            if (playerName.length() < 2) {
                System.out.println("Name is too short! Please, enter a valid name!");
                i--;
                continue;
            }

            else if (playersNames.containsValue(playerName)) {
                System.out.println("Name is already exists! Please, enter a different name!");
                i--;
                continue;
            }

            playersNames.put(i, playerName);
        }

        return playersNames;
    }

    public static void showMessageForStartTheGame(HashMap<Integer, String> gameSquares) {
        System.out.println("\nYou are ready to start the game!");
        System.out.println("At the moment, you are all in position \"" + gameSquares.get(1) + "\".");
        System.out.println("Let's start!");
    }

    public static int rollDice() {

        Random rand = new Random();

        int dice1 = rand.nextInt((6 - 1) + 1) + 1;
        int dice2 = rand.nextInt((6 - 1) + 1) + 1;

        return dice1 + dice2;
    }


    public static void moveTracker(int numberOfPlayers, HashMap<Integer, String> playersNames,
                                   HashMap<Integer, String> gameSquares,
                                   HashMap<String, Integer> playersCurrentPositionOnGameBoard,
                                   HashMap<Integer, Integer> playersMoney,
                                   HashMap<Integer, String> squareOwners,
                                   HashMap<Integer, Integer> squaresPrice) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("\n" + playersNames.get(i) + ", it's your turn! Press \"enter\" to roll the dice. ");

            if(isPlayerPressEnter()){
                int resultAfterRollingTheDice = rollDice();
                System.out.println("You threw " + resultAfterRollingTheDice + ". You are now on \"" +
                        findCurrentPlayerPositionOnGameBoard(gameSquares, playersNames.get(i), i,
                                resultAfterRollingTheDice, playersCurrentPositionOnGameBoard, playersMoney) + "\".");

                System.out.println("You have $ " + playersMoney.get(i));

                playerOptions(playersCurrentPositionOnGameBoard, playersNames.get(i), i, squareOwners,
                        gameSquares, playersMoney, squaresPrice, numberOfPlayers, playersNames);


            }

            else {
                System.out.println("\nYou pressed wrong button/s! Let's try again...");
                i--;
                continue;
            }

            if(i == numberOfPlayers){
                i = 0;
            }
        }
    }

    public static boolean isPlayerPressEnter() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("")) {
            return true;
        }

        else
            return false;
    }

    public static HashMap<String, Integer> createHashMapForInitialPlayerPositionsOnGameBoard(HashMap<Integer, String> playersNames) {
        HashMap<String, Integer> playersPositionOnGameBoard = new HashMap<>();
        int startPositionOnGameBoard = 1;

        for(int i = 1; i <= playersNames.size(); i++) {
            String playerName = playersNames.get(i);
            playersPositionOnGameBoard.put(playerName, startPositionOnGameBoard);
        }

        return playersPositionOnGameBoard;
    }

    public static String findCurrentPlayerPositionOnGameBoard(HashMap<Integer, String> gameSquares,
                                                              String playerName, int playerIndex,
                                                              int resultAfterRollingTheDice,
                                                              HashMap<String, Integer> playersCurrentPositionOnGameBoard,
                                                              HashMap<Integer, Integer> playersMoney) {
        int newPosition = playersCurrentPositionOnGameBoard.get(playerName) + resultAfterRollingTheDice;

        if(newPosition > 40){
            newPosition = newPosition - 40;
            updatePlayerMoneyAfterPassGo(playersMoney, playerIndex);
        }

        playersCurrentPositionOnGameBoard.replace(playerName, newPosition);

        return gameSquares.get(newPosition);
    }

    public static HashMap<Integer, Integer> prepareInitialPlayersMoney(int numberOfPlayers) {
        HashMap<Integer, Integer> playersMoney = new HashMap<>();

        for(int i = 1; i <= numberOfPlayers; i++) {
            playersMoney.put(i, 1500);
        }

        return playersMoney;
    }

    public static int updatePlayerMoneyAfterPassGo(HashMap<Integer, Integer> playersMoney, int playerIndex) {
        int updatePlayerMoney = playersMoney.get(playerIndex) + 200;
        playersMoney.replace(playerIndex, updatePlayerMoney);

        return playersMoney.get(playerIndex);
    }

    public static HashMap<Integer, String> createHashMapForInitialSquareOwners(HashMap<Integer, String> gameSquares) {
        HashMap<Integer, String> squareOwners = new HashMap<>();

        for(int i = 1; i <= gameSquares.size(); i++) {
            squareOwners.put(i, null);
        }

        return squareOwners;
    }

    public static void playerOptions(HashMap<String, Integer> playerCurrentPositionOnGameBoard, String playerName,
                                     int playerIndex, HashMap<Integer, String> squareOwners, HashMap<Integer, String> gameSquares,
                                     HashMap<Integer, Integer> playersMoney, HashMap<Integer, Integer> squaresPrice,
                                     int numberOfPlayers, HashMap<Integer, String> playersNames) {
        System.out.println("Your options now are: ");

        //playerCurrentPositionOnGameBoard.get(playerName) returns values from 1 to 40

        int squareIndex = playerCurrentPositionOnGameBoard.get(playerName);
        String squareName = gameSquares.get(squareIndex);

        if(squareOwners.get(squareIndex) == null &&
                squaresPrice.get(squareIndex) != null &&
                (playersMoney.get(playerIndex) > squaresPrice.get(squareIndex))) {

            System.out.println("1. Buy \"" + squareName + "\". It costs $ " +
                    squaresPrice.get(squareIndex) + ".");

            System.out.println("2. Don't do anything. (If you select this option, \"" +
                    squareName + "\" will be put up for auction!");

            System.out.print("Now, choose option: ");

            Scanner sc = new Scanner(System.in);

            try{
                int playerChoice = sc.nextInt();

                if(playerChoice < 1 || playerChoice > 2) {
                    System.out.println("Wrong input! You must select one of the options listed! Try again!");
                    playerOptions( playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners,  gameSquares,
                            playersMoney, squaresPrice, numberOfPlayers, playersNames);
                }

                switch (playerChoice) {
                    case 1:
                        int updatedPlayerMoney = playersMoney.get(playerIndex) - squaresPrice.get(squareIndex);
                        playersMoney.replace(playerIndex, updatedPlayerMoney );

                        squareOwners.replace(squareIndex, playerName);

                        System.out.println("Congratulations! You have successfully bought \"" + squareName + "\".");
                        System.out.println("----------------------------------------------------------------");
                        break;

                    case 2:
                        auction(playerCurrentPositionOnGameBoard,  playerName, playerIndex,  squareOwners,  gameSquares,
                             playersMoney,  squaresPrice, numberOfPlayers,  playersNames);
                        break;
                }
            }

            catch (InputMismatchException e) {
                System.out.println("Wrong input! You must select one of the options listed! Try again!");
                playerOptions( playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners,  gameSquares,
                         playersMoney, squaresPrice, numberOfPlayers, playersNames);
            }
        }
    }

    public static void auction(HashMap<String, Integer> playerCurrentPositionOnGameBoard, String playerName,
                               int playerIndex, HashMap<Integer, String> squareOwners, HashMap<Integer, String> gameSquares,
                               HashMap<Integer, Integer> playersMoney, HashMap<Integer, Integer> squaresPrice,
                               int numberOfPlayers, HashMap<Integer, String> playersNames) {

        int squareIndex = playerCurrentPositionOnGameBoard.get(playerName);
        String squareName = gameSquares.get(squareIndex);

        System.out.println("\nAUCTION! All players will bid for \"" + squareName + "\". " +
                "Starting price is $ " + squaresPrice.get(squareIndex) + ". \n" );

        Scanner sc = new Scanner(System.in);

        int playerChoice;
        int amount;

        HashMap<Integer, Integer> playersAnswers = new HashMap<>();

        for(int i = 1; i <= numberOfPlayers; i++) {
            System.out.println(playersNames.get(i) + ", choose option:");
            System.out.println("1. Enter an amount in $.");
            System.out.println("2. Skip.");
            System.out.print("Choose option: ");

            playerChoice = sc.nextInt();

            switch (playerChoice) {
                case 1:
                    System.out.print("Enter an amount in $: ");
                    amount = sc.nextInt();
                    playersAnswers.put(i, amount);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Maybe you'll be sorry! \n");
                    playersAnswers.put(i, 0);
                    break;
            }

            if(i == numberOfPlayers) {
                int counter = 0;

                for(int j = 1; j <= numberOfPlayers; j++){
                    if(playersAnswers.get(j) != 0) {
                        counter++;
                    }
                }

                if(counter > 1){
                    i = 0;
                }

                else if(counter == 1) {
                    for(int k = 1; k <= playersAnswers.size(); k++) {
                        if(playersAnswers.get(k) != 0) {
                            String nameOfPlayer = playersNames.get(k);
                            squareOwners.replace(squareIndex, nameOfPlayer);

                            int updatePlayerMoney = playersMoney.get(k) - playersAnswers.get(k);
                            playersMoney.replace(k, updatePlayerMoney);
                            System.out.println(nameOfPlayer + " won the auction! He/She successfully bought \"" + squareName + "\".");
                            System.out.println("--------------------------------------------------------------------------");
                        }
                    }
                }

                else if (counter == 0) {
                    System.out.println("No one wanted to buy \"" + squareName + "\". For now it remains for bank.");
                }
            }
        }
    }

}
