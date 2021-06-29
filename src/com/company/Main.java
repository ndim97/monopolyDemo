package com.company;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        game();
    }

    public static void game() {

        System.out.println("\nMONOPOLY \n");

        //Preparing for the game

        int numberOfPlayers = selectNumberOfPlayers();
        HashMap<Integer, String> playersNames = enterPlayersNames(numberOfPlayers);
        HashMap<String, Integer> playersCurrentPositionOnGameBoard = createHashMapForInitialPlayerPositionsOnGameBoard(playersNames);
        HashMap<Integer, Integer> playersMoney = prepareInitialPlayersMoney(numberOfPlayers);
        HashMap<Integer, String> gameSquares = prepareGameSquares();
        HashMap<Integer, Integer> squaresPrice = prepareSquaresPrice();
        HashMap<Integer, Integer> squaresRent  = prepareSquaresRent();
        Stack<String> chanceCards = prepareChanceCards();
        Stack<String> communityChestCards = prepareCommunityChestCards();
        HashMap<Integer, String> squaresOwners = createHashMapForInitialSquareOwners(gameSquares);
        ArrayList<Integer> lostPlayers = new ArrayList<>();

        //Start the game

        showMessageForStartTheGame(gameSquares);

        moveTracker(numberOfPlayers, playersNames, gameSquares, playersCurrentPositionOnGameBoard,
                playersMoney, squaresOwners, squaresPrice, squaresRent, chanceCards, communityChestCards, lostPlayers);
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

        chanceCards.push("Advance to Go. (Collect $200)");
        chanceCards.push("Pay the housing tax -$150");
        chanceCards.push("Bank pays you dividend of $50");
        chanceCards.push("Go to Jail! (Go directly to Jail, do not pass Go, do not collect $200)");
        chanceCards.push("Go Back 3 Spaces");
        chanceCards.push("Speeding fine $15");

        //Shuffle the cards
        Collections.shuffle(chanceCards);

        return chanceCards;
    }

    public static Stack<String> prepareCommunityChestCards() {

        Stack<String> communityChestCards = new Stack<>();

        communityChestCards.push("From sale of stock you get $50.");
        communityChestCards.push("Bank error in your favour. Collect $200.");
        communityChestCards.push("Pay school fees of $50.");
        communityChestCards.push("You inherit $100.");
        communityChestCards.push("Holiday fund matures. Receive $100");
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

    public static HashMap<Integer, Integer> prepareSquaresRent() {
        HashMap<Integer, Integer> squaresRent = new HashMap<>();

        squaresRent.put(1, null);
        squaresRent.put(2, 12);
        squaresRent.put(3, null);
        squaresRent.put(4, 14);
        squaresRent.put(5, null);
        squaresRent.put(6, 50);
        squaresRent.put(7, 16);
        squaresRent.put(8, null);
        squaresRent.put(9, 16);
        squaresRent.put(10, 18);
        squaresRent.put(11, null);
        squaresRent.put(12, 20);
        squaresRent.put(13, 10);
        squaresRent.put(14, 20);
        squaresRent.put(15, 22);
        squaresRent.put(16, 50);
        squaresRent.put(17, 24);
        squaresRent.put(18, null);
        squaresRent.put(19, 24);
        squaresRent.put(20, 26);
        squaresRent.put(21, null);
        squaresRent.put(22, 28);
        squaresRent.put(23, null);
        squaresRent.put(24, 28);
        squaresRent.put(25, 30);
        squaresRent.put(26, 50);
        squaresRent.put(27, 32);
        squaresRent.put(28, 32);
        squaresRent.put(29, 10);
        squaresRent.put(30, 32);
        squaresRent.put(31, null);
        squaresRent.put(32, 36);
        squaresRent.put(33, 36);
        squaresRent.put(34, null);
        squaresRent.put(35, 38);
        squaresRent.put(36, 50);
        squaresRent.put(37, null);
        squaresRent.put(38, 45);
        squaresRent.put(39, null);
        squaresRent.put(40, 100);

        return squaresRent;
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

        System.out.println("\nNow, enter your names...");

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Player " + i + ", enter your name: ");
            String playerName = sc.nextLine();

            if (playerName.length() < 2) {
                System.out.println("\nName is too short! Please, enter a valid name!\n");
                i--;
                continue;
            }

            else if (playersNames.containsValue(playerName)) {
                System.out.println("\nName is already exists! Please, enter a different name!\n");
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

    public static void moveTracker(int numberOfPlayers,
                                   HashMap<Integer, String> playersNames,
                                   HashMap<Integer, String> gameSquares,
                                   HashMap<String, Integer> playersCurrentPositionOnGameBoard,
                                   HashMap<Integer, Integer> playersMoney,
                                   HashMap<Integer, String> squareOwners,
                                   HashMap<Integer, Integer> squaresPrice,
                                   HashMap<Integer, Integer> squaresRent,
                                   Stack<String> chanceCards,
                                   Stack<String> communityChestCards,
                                   ArrayList<Integer> lostPlayers) {

        int counter = 0;
        boolean mistake = false;

        for (int i = 1; i <= numberOfPlayers; i++) {

            if(lostPlayers.contains(i)) {
                continue;
            }

            String playerName = playersNames.get(i);

            if(lostPlayers.size() == (numberOfPlayers - 1)) {
                System.out.println("***************************************************");
                System.out.println(playerName + " wins the game! Congratulations!");
                System.out.println("***************************************************");

                System.exit(0);
            }

            if(playersCurrentPositionOnGameBoard.get(playerName) == 31 && !mistake) {
                counter++;

                if(counter <= 3){
                    System.out.println("\n" + playerName + " is still in jail!");
                    System.out.println("----------------------------------------");

                    if(i == numberOfPlayers) {
                        i = 0;
                    }

                    continue;
                }

                else counter = 0;
            }

            mistake = false;

            System.out.print("\n" + playersNames.get(i) + ", it's your turn! Press \"enter\" to roll the dice. ");

            if (isPlayerPressEnter()) {
                int resultAfterRollingTheDice = rollDice();
                System.out.println("\nYou threw " + resultAfterRollingTheDice + ". You are now on \"" +
                        findCurrentPlayerPositionOnGameBoard(gameSquares, playersNames.get(i), i,
                                resultAfterRollingTheDice, playersCurrentPositionOnGameBoard, playersMoney) + "\".");

                System.out.println("You have $ " + playersMoney.get(i));

                playerOptions(playersCurrentPositionOnGameBoard, playersNames.get(i), i, squareOwners,
                        gameSquares, playersMoney, squaresPrice, numberOfPlayers, playersNames, squaresRent,
                        chanceCards, communityChestCards, lostPlayers);
            }

            else {
                System.out.println("\nYou pressed wrong button/s! Let's try again...");
                mistake = true;
                i--;
                continue;
            }

            if (i == numberOfPlayers) {
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

        for (int i = 1; i <= playersNames.size(); i++) {
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

        if (newPosition > 40) {
            newPosition = newPosition - 40;
            updatePlayerMoneyAfterPassGo(playersMoney, playerIndex);
        }

        playersCurrentPositionOnGameBoard.replace(playerName, newPosition);

        return gameSquares.get(newPosition);
    }

    public static HashMap<Integer, Integer> prepareInitialPlayersMoney(int numberOfPlayers) {
        HashMap<Integer, Integer> playersMoney = new HashMap<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
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

        for (int i = 1; i <= gameSquares.size(); i++) {
            squareOwners.put(i, null);
        }

        return squareOwners;
    }

    public static void playerOptions(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                     String playerName,
                                     int playerIndex,
                                     HashMap<Integer, String> squareOwners,
                                     HashMap<Integer, String> gameSquares,
                                     HashMap<Integer, Integer> playersMoney,
                                     HashMap<Integer, Integer> squaresPrice,
                                     int numberOfPlayers,
                                     HashMap<Integer, String> playersNames,
                                     HashMap<Integer, Integer> squaresRent,
                                     Stack<String> chanceCards,
                                     Stack<String> communityChestCards,
                                     ArrayList<Integer> lostPlayers) {

        //playerCurrentPositionOnGameBoard.get(playerName) returns values from 1 to 40

        int squareIndex = playerCurrentPositionOnGameBoard.get(playerName);
        String squareName = gameSquares.get(squareIndex);

        if (squareOwners.get(squareIndex) == null &&
                squaresPrice.get(squareIndex) != null &&
                (playersMoney.get(playerIndex) > squaresPrice.get(squareIndex))) {

            playerIsOnUnownedSquareWithEnoughMoney(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent);
        }

        else if(squareOwners.get(squareIndex) == null &&
                squaresPrice.get(squareIndex) != null &&
                (playersMoney.get(playerIndex) < squaresPrice.get(squareIndex))) {

            System.out.println("You don't have enough money to buy \"" +  squareName + "\". Maybe next time.");

            System.out.println("\nAUCTION! All players will bid for \"" + squareName + "\". " +
                    "Starting price is $ " + squaresPrice.get(squareIndex) + ". " + playerName + ", should skip! \n");

            auction(playerCurrentPositionOnGameBoard, playerName, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames);
        }

        else if (squareIndex != 13 && squareIndex != 29 &&
                squareOwners.get(squareIndex) != null &&
                !squareOwners.get(squareIndex).equals(playerName) &&
                squaresPrice.get(squareIndex) != null &&
                (playersMoney.get(playerIndex) > squaresRent.get(squareIndex))) {

            playerIsOnOwnedSquareWithEnoughMoney(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent);
        }

        else if (squareIndex != 13 && squareIndex != 29 &&
                squareOwners.get(squareIndex) != null &&
                !squareOwners.get(squareIndex).equals(playerName) &&
                squaresPrice.get(squareIndex) != null &&
                (playersMoney.get(playerIndex) < squaresRent.get(squareIndex))) {

            String squareOwnerName = squareOwners.get(squareIndex);

            System.out.println("You don't have enough money to pay rent to  \"" +  squareOwnerName + "\".");

            removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);

        }

        else if (squareOwners.get(squareIndex) != null &&
                squareOwners.get(squareIndex).equals(playerName) &&
                squaresPrice.get(squareIndex) != null) {

            playerIsOnHisOwnSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent);
        }

        else if(squareIndex == 8 || squareIndex == 23 || squareIndex == 37) {

            playerIsOnChanceSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent,
                    chanceCards, lostPlayers);
        }

        else if(squareIndex == 3 || squareIndex == 18 || squareIndex == 34) {

            playerIsOnCommunityChestSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent,
                    communityChestCards, lostPlayers);
        }

        else if(squareIndex == 5) {

            playerIsOnIncomeTaxSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, lostPlayers);
        }

        else if(squareIndex == 11) {

            playerIsOnJustVisitingSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName);
        }

        else if(squareIndex == 21) {

            playerIsOnFreeParkingSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName);
        }

        else if(squareIndex == 31) {

            goToJail(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent);
        }

        else if(squareIndex == 39) {

            playerIsOnSuperTaxSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, lostPlayers);
        }

        else if((squareIndex == 13 || squareIndex == 29) &&
                squareOwners.get(squareIndex) != null &&
                !squareOwners.get(squareIndex).equals(playerName)) {

            playerIsOnUtilitySquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent, lostPlayers);
        }

    }

    public static void playerIsOnUnownedSquareWithEnoughMoney(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                              String playerName, int playerIndex,
                                                              HashMap<Integer, String> squareOwners,
                                                              HashMap<Integer, String> gameSquares,
                                                              HashMap<Integer, Integer> playersMoney,
                                                              HashMap<Integer, Integer> squaresPrice,
                                                              int numberOfPlayers,
                                                              HashMap<Integer, String> playersNames,
                                                              int squareIndex, String squareName,
                                                              HashMap<Integer, Integer> squaresRent) {
        System.out.println("\nYour options now are: ");

        System.out.println("1. Buy \"" + squareName + "\". It costs $ " +
                squaresPrice.get(squareIndex) + ".");

        System.out.println("2. Don't do anything. (If you select this option, \"" +
                squareName + "\" will be put up for auction!");

        System.out.print("Now, choose option: ");

        Scanner sc = new Scanner(System.in);

        try {
            int playerChoice = sc.nextInt();

            if (playerChoice < 1 || playerChoice > 2) {
                System.out.println("\nWrong input! You must select one of the options listed! Try again!");

                playerIsOnUnownedSquareWithEnoughMoney( playerCurrentPositionOnGameBoard, playerName, playerIndex,
                        squareOwners, gameSquares, playersMoney,  squaresPrice, numberOfPlayers,  playersNames,
                        squareIndex, squareName, squaresRent);
            }

            switch (playerChoice) {
                case 1:
                    int updatedPlayerMoney = playersMoney.get(playerIndex) - squaresPrice.get(squareIndex);
                    playersMoney.replace(playerIndex, updatedPlayerMoney);

                    squareOwners.replace(squareIndex, playerName);

                    System.out.println("\nCongratulations! You have successfully bought \"" + squareName + "\".");
                    System.out.println("----------------------------------------------------------------");
                    break;

                case 2:
                    System.out.println("\nAUCTION! All players will bid for \"" + squareName + "\". " +
                            "Starting price is $ " + squaresPrice.get(squareIndex) + ". \n");

                    auction(playerCurrentPositionOnGameBoard, playerName, squareOwners, gameSquares,
                            playersMoney, squaresPrice, numberOfPlayers, playersNames);
                    break;
            }
        }

        catch (InputMismatchException e) {
            System.out.println("\nWrong input! You must select one of the options listed! Try again!");

            playerIsOnUnownedSquareWithEnoughMoney( playerCurrentPositionOnGameBoard, playerName, playerIndex,
                     squareOwners, gameSquares, playersMoney,  squaresPrice, numberOfPlayers,  playersNames,
                     squareIndex, squareName, squaresRent);
        }
    }

    public static void auction(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                               String playerName,
                               HashMap<Integer, String> squareOwners,
                               HashMap<Integer, String> gameSquares,
                               HashMap<Integer, Integer> playersMoney,
                               HashMap<Integer, Integer> squaresPrice,
                               int numberOfPlayers,
                               HashMap<Integer, String> playersNames) throws InputMismatchException {

        int squareIndex = playerCurrentPositionOnGameBoard.get(playerName);
        String squareName = gameSquares.get(squareIndex);

        Scanner sc = new Scanner(System.in);

        int playerChoice;
        int amount;
        int currentBiggestOffer = squaresPrice.get(squareIndex);

        HashMap<Integer, Integer> playersAnswers = new HashMap<>();

        try {
            for (int i = 1; i <= numberOfPlayers; i++) {
                System.out.println(playersNames.get(i) + ", choose option:");
                System.out.println("1. Enter an amount in $.");
                System.out.println("2. Skip.");
                System.out.print("Choose option: ");

                playerChoice = sc.nextInt();


                if (playerChoice < 1 || playerChoice > 2) {
                    System.out.println("\nWrong input! You must select one of the options listed! Try again!\n");
                    i--;
                    continue;
                }

                switch (playerChoice) {
                    case 1:
                        System.out.print("Enter an amount in $: ");
                        amount = sc.nextInt();

                        if (amount < currentBiggestOffer) {
                            System.out.println("\nYou must offer a larger amount! \n");
                            playersAnswers.put(i, 0);
                        } else {
                            currentBiggestOffer = amount;
                            playersAnswers.put(i, amount);
                            System.out.println();
                        }
                        break;

                    case 2:
                        System.out.println("\nMaybe you'll be sorry! \n");
                        playersAnswers.put(i, 0);
                        break;
                }

                if (i == numberOfPlayers) {
                    int counter = 0;

                    for (int j = 1; j <= numberOfPlayers; j++) {
                        if (playersAnswers.get(j) != 0) {
                            counter++;
                        }
                    }

                    if (counter > 1) {
                        i = 0;
                    } else if (counter == 1) {
                        for (int k = 1; k <= playersAnswers.size(); k++) {
                            if (playersAnswers.get(k) != 0) {
                                String nameOfPlayer = playersNames.get(k);
                                squareOwners.replace(squareIndex, nameOfPlayer);

                                int updatePlayerMoney = playersMoney.get(k) - playersAnswers.get(k);
                                playersMoney.replace(k, updatePlayerMoney);
                                System.out.println(nameOfPlayer + " won the auction! He/She successfully bought \"" + squareName + "\".");
                                System.out.println("--------------------------------------------------------------------------");
                            }
                        }
                    } else if (counter == 0) {
                        System.out.println("No one wanted to buy \"" + squareName + "\". For now it remains for bank.");
                        System.out.println("---------------------------------------------------------------------------");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\nFatal wrong input! Bidding starts again!\n");

            auction(playerCurrentPositionOnGameBoard, playerName, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames);
        }
    }

    public static void playerIsOnOwnedSquareWithEnoughMoney(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                            String playerName, int playerIndex,
                                                            HashMap<Integer, String> squareOwners,
                                                            HashMap<Integer, String> gameSquares,
                                                            HashMap<Integer, Integer> playersMoney,
                                                            HashMap<Integer, Integer> squaresPrice,
                                                            int numberOfPlayers,
                                                            HashMap<Integer, String> playersNames,
                                                            int squareIndex, String squareName,
                                                            HashMap<Integer, Integer> squaresRent) {

        System.out.println("\nYour options now are: ");

        System.out.println("\n1. Pay the rent to " + squareOwners.get(squareIndex) + ". The rent is $ " +
                squaresRent.get(squareIndex) + ".");

        System.out.print("Now, choose option: ");

        Scanner sc = new Scanner(System.in);

        try {
            int playerChoice = sc.nextInt();

            if (playerChoice != 1) {
                System.out.println("\nWrong input! You must select one of the options listed! Try again!");

                playerIsOnOwnedSquareWithEnoughMoney( playerCurrentPositionOnGameBoard, playerName, playerIndex,
                        squareOwners, gameSquares, playersMoney,  squaresPrice, numberOfPlayers,  playersNames,
                        squareIndex, squareName, squaresRent);
            }

            switch (playerChoice) {
                case 1:
                    int updatedPlayerMoney = playersMoney.get(playerIndex) - squaresRent.get(squareIndex);

                    playersMoney.replace(playerIndex, updatedPlayerMoney);

                    String squareOwnerName = squareOwners.get(squareIndex);
                    int squareOwnerIndex = getPlayerIndexFromName(playersNames, squareOwnerName);
                    int updatedSquareOwnerMoney = playersMoney.get(squareOwnerIndex) + squaresRent.get(squareIndex);

                    playersMoney.replace(squareOwnerIndex, updatedSquareOwnerMoney);

                    System.out.println("\nYou have successfully paid the rent to " + squareOwners.get(squareIndex) + ".");
                    System.out.println("----------------------------------------------------------------");
                    break;
            }
        }

        catch (InputMismatchException e) {
            System.out.println("\nWrong input! You must select one of the options listed! Try again!");

            playerIsOnOwnedSquareWithEnoughMoney( playerCurrentPositionOnGameBoard, playerName, playerIndex,
                    squareOwners, gameSquares, playersMoney,  squaresPrice, numberOfPlayers,  playersNames,
                    squareIndex, squareName, squaresRent);
        }
    }

    public static int getPlayerIndexFromName(HashMap<Integer, String> playersNames, String playerName) {

        int playerIndex = 0;

        for(int i = 1; i <= playersNames.size(); i++) {
            if(playersNames.get(i).equals(playerName)){
                playerIndex = i;
            }
        }

        return playerIndex;
    }

    public static void playerIsOnHisOwnSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                              String playerName, int playerIndex,
                                              HashMap<Integer, String> squareOwners,
                                              HashMap<Integer, String> gameSquares,
                                              HashMap<Integer, Integer> playersMoney,
                                              HashMap<Integer, Integer> squaresPrice,
                                              int numberOfPlayers,
                                              HashMap<Integer, String> playersNames,
                                              int squareIndex, String squareName,
                                              HashMap<Integer, Integer> squaresRent) {

        System.out.println("\nYour options now are: ");

        System.out.println("\n1. Don't do anything. (\"" + gameSquares.get(squareIndex) + "\" is your property.)");

        System.out.print("Now, choose option: ");

        Scanner sc = new Scanner(System.in);

        try {
            int playerChoice = sc.nextInt();

            if (playerChoice != 1) {
                System.out.println("\nWrong input! You must select one of the options listed! Try again!");

                playerIsOnHisOwnSquare( playerCurrentPositionOnGameBoard, playerName, playerIndex,
                        squareOwners, gameSquares, playersMoney,  squaresPrice, numberOfPlayers,  playersNames,
                        squareIndex, squareName, squaresRent);
            }

            switch (playerChoice) {
                case 1:
                    System.out.println("----------------------------------------------------------------");
                    break;
            }
        }

        catch (InputMismatchException e) {
            System.out.println("\nWrong input! You must select one of the options listed! Try again!");

            playerIsOnHisOwnSquare( playerCurrentPositionOnGameBoard, playerName, playerIndex,
                    squareOwners, gameSquares, playersMoney,  squaresPrice, numberOfPlayers,  playersNames,
                    squareIndex, squareName, squaresRent);
        }
    }

    public static void playerIsOnChanceSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                              String playerName, int playerIndex,
                                              HashMap<Integer, String> squareOwners,
                                              HashMap<Integer, String> gameSquares,
                                              HashMap<Integer, Integer> playersMoney,
                                              HashMap<Integer, Integer> squaresPrice,
                                              int numberOfPlayers,
                                              HashMap<Integer, String> playersNames,
                                              int squareIndex, String squareName,
                                              HashMap<Integer, Integer> squaresRent,
                                              Stack<String> chanceCards,
                                              ArrayList<Integer> lostPlayers) {

        System.out.println("\nThe following is written on the card:");
        System.out.println("\"" + chanceCards.peek() + "\"");

        String cardText = chanceCards.pop();
        chanceCards.add(0, cardText);

        int updatePlayerMoney;

        if(cardText.equals("Advance to Go. (Collect $200)")) {
            playerCurrentPositionOnGameBoard.replace(playerName, 1);

            updatePlayerMoney = playersMoney.get(playerIndex) + 200;
            playersMoney.replace(playerIndex, updatePlayerMoney);
        }

        else if(cardText.equals("Pay the housing tax -$150")) {
            if(checkWhetherPlayerHaveEnoughMoneyToPay(150, playerIndex, playersMoney)) {
                updatePlayerMoney = playersMoney.get(playerIndex) - 150;
                playersMoney.replace(playerIndex, updatePlayerMoney);
            }

            else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
        }

        else if(cardText.equals("Bank pays you dividend of $50")) {
            updatePlayerMoney = playersMoney.get(playerIndex) + 50;
            playersMoney.replace(playerIndex, updatePlayerMoney);
        }

        else if(cardText.equals("Go to Jail! (Go directly to Jail, do not pass Go, do not collect $200)")) {
            goToJail(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                    playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, squaresRent);
        }

        else if(cardText.equals("Go Back 3 Spaces")) {
            int newPosition = squareIndex - 3;
            playerCurrentPositionOnGameBoard.replace(playerName, newPosition);

            if(newPosition == 5) {
                playerIsOnIncomeTaxSquare(playerCurrentPositionOnGameBoard, playerName, playerIndex, squareOwners, gameSquares,
                        playersMoney, squaresPrice, numberOfPlayers, playersNames, squareIndex, squareName, lostPlayers);
            }
        }

        else if(cardText.equals("Speeding fine $15")) {

            if(checkWhetherPlayerHaveEnoughMoneyToPay(15, playerIndex, playersMoney)) {
                updatePlayerMoney = playersMoney.get(playerIndex) - 15;
                playersMoney.replace(playerIndex, updatePlayerMoney);
            }

            else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
        }

        System.out.println("--------------------------------------------------------------");
    }

    public static boolean checkWhetherPlayerHaveEnoughMoneyToPay(int owedMoney, int playerIndex, HashMap<Integer, Integer> playersMoney) {
        int playerCurrentMoney = playersMoney.get(playerIndex);

        if(playerCurrentMoney - owedMoney >= 0) {
            return true;
        }

        else return false;
    }

    public static void playerIsOnCommunityChestSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                      String playerName, int playerIndex,
                                                      HashMap<Integer, String> squareOwners,
                                                      HashMap<Integer, String> gameSquares,
                                                      HashMap<Integer, Integer> playersMoney,
                                                      HashMap<Integer, Integer> squaresPrice,
                                                      int numberOfPlayers,
                                                      HashMap<Integer, String> playersNames,
                                                      int squareIndex, String squareName,
                                                      HashMap<Integer, Integer> squaresRent,
                                                      Stack<String> communityChestCards,
                                                      ArrayList<Integer> lostPlayers) {

        System.out.println("\nThe following is written on the card:");
        System.out.println("\"" + communityChestCards.peek() + "\"");

        String cardText = communityChestCards.pop();
        communityChestCards.add(0, cardText);

        int updatePlayerMoney;

        if(cardText.equals("From sale of stock you get $50.")) {
            updatePlayerMoney = playersMoney.get(playerIndex) + 50;
            playersMoney.replace(playerIndex, updatePlayerMoney);
        }

        else if(cardText.equals("Bank error in your favour. Collect $200.")) {
            updatePlayerMoney = playersMoney.get(playerIndex) + 200;
            playersMoney.replace(playerIndex, updatePlayerMoney);
        }

        else if(cardText.equals("Pay school fees of $50.")) {
            if(checkWhetherPlayerHaveEnoughMoneyToPay(50, playerIndex, playersMoney)) {
                updatePlayerMoney = playersMoney.get(playerIndex) - 50;
                playersMoney.replace(playerIndex, updatePlayerMoney);
            }

            else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
        }

        else if(cardText.equals("You inherit $100.")) {
            updatePlayerMoney = playersMoney.get(playerIndex) + 100;
            playersMoney.replace(playerIndex, updatePlayerMoney);
        }

        else if(cardText.equals("Holiday fund matures. Receive $100")) {
            updatePlayerMoney = playersMoney.get(playerIndex) + 100;
            playersMoney.replace(playerIndex, updatePlayerMoney);
        }

        else if(cardText.equals("Drunkenness fine $15")) {
            if(checkWhetherPlayerHaveEnoughMoneyToPay(15, playerIndex, playersMoney)) {
                updatePlayerMoney = playersMoney.get(playerIndex) - 15;
                playersMoney.replace(playerIndex, updatePlayerMoney);
            }

            else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
        }

        System.out.println("--------------------------------------------------------------");
    }

    public static void playerIsOnIncomeTaxSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                 String playerName, int playerIndex,
                                                 HashMap<Integer, String> squareOwners,
                                                 HashMap<Integer, String> gameSquares,
                                                 HashMap<Integer, Integer> playersMoney,
                                                 HashMap<Integer, Integer> squaresPrice,
                                                 int numberOfPlayers,
                                                 HashMap<Integer, String> playersNames,
                                                 int squareIndex, String squareName,
                                                 ArrayList<Integer> lostPlayers) {

        System.out.println("\nYou have to pay the bank $ 200!");

        if(checkWhetherPlayerHaveEnoughMoneyToPay(200, playerIndex, playersMoney)) {
            int updatePlayerMoney = playersMoney.get(playerIndex) - 200;
            playersMoney.replace(playerIndex, updatePlayerMoney);
            System.out.println("--------------------------------------------------------------");
        }

        else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
    }

    public static void playerIsOnJustVisitingSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                    String playerName, int playerIndex,
                                                    HashMap<Integer, String> squareOwners,
                                                    HashMap<Integer, String> gameSquares,
                                                    HashMap<Integer, Integer> playersMoney,
                                                    HashMap<Integer, Integer> squaresPrice,
                                                    int numberOfPlayers,
                                                    HashMap<Integer, String> playersNames,
                                                    int squareIndex, String squareName) {

        System.out.println("\nYou are just visiting the prison! (You don't have to do anything.)");

        System.out.println("--------------------------------------------------------------");
    }

    public static void playerIsOnFreeParkingSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                   String playerName, int playerIndex,
                                                   HashMap<Integer, String> squareOwners,
                                                   HashMap<Integer, String> gameSquares,
                                                   HashMap<Integer, Integer> playersMoney,
                                                   HashMap<Integer, Integer> squaresPrice,
                                                   int numberOfPlayers,
                                                   HashMap<Integer, String> playersNames,
                                                   int squareIndex, String squareName) {

        System.out.println("\nYou are in the free car park! (You don't have to do anything.)");

        System.out.println("--------------------------------------------------------------");
    }

    public static void playerIsOnSuperTaxSquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                                String playerName, int playerIndex,
                                                HashMap<Integer, String> squareOwners,
                                                HashMap<Integer, String> gameSquares,
                                                HashMap<Integer, Integer> playersMoney,
                                                HashMap<Integer, Integer> squaresPrice,
                                                int numberOfPlayers,
                                                HashMap<Integer, String> playersNames,
                                                int squareIndex, String squareName,
                                                ArrayList<Integer> lostPlayers) {

        System.out.println("\nYou have to pay the bank $ 100!");

        if(checkWhetherPlayerHaveEnoughMoneyToPay(100, playerIndex, playersMoney)) {
            int updatePlayerMoney = playersMoney.get(playerIndex) - 100;
            playersMoney.replace(playerIndex, updatePlayerMoney);
            System.out.println("--------------------------------------------------------------");
        }

        else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
    }

    public static void playerIsOnUtilitySquare(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                               String playerName, int playerIndex,
                                               HashMap<Integer, String> squareOwners,
                                               HashMap<Integer, String> gameSquares,
                                               HashMap<Integer, Integer> playersMoney,
                                               HashMap<Integer, Integer> squaresPrice,
                                               int numberOfPlayers,
                                               HashMap<Integer, String> playersNames,
                                               int squareIndex, String squareName,
                                               HashMap<Integer, Integer> squaresRent,
                                               ArrayList<Integer> lostPlayers) {

        String squareOwnerName = squareOwners.get(squareIndex);

        System.out.println("\nYou have to roll the dice again and pay " + squareOwnerName +  " the result of the dice * 5.");

        int resultFromDice = rollDice();

        System.out.println("\nYou threw " + resultFromDice + ". So, you have to pay " + squareOwnerName + " $ " +
                squaresRent.get(squareIndex) * resultFromDice + ".");

        int owedMoney = squaresRent.get(squareIndex) * resultFromDice;

        if(checkWhetherPlayerHaveEnoughMoneyToPay(owedMoney, playerIndex, playersMoney)) {
            int updatedPlayerMoney = playersMoney.get(playerIndex) - owedMoney;

            playersMoney.replace(playerIndex, updatedPlayerMoney);

            int squareOwnerIndex = getPlayerIndexFromName(playersNames, squareOwnerName);
            int updatedSquareOwnerMoney = playersMoney.get(squareOwnerIndex) + owedMoney;

            playersMoney.replace(squareOwnerIndex, updatedSquareOwnerMoney);

            System.out.println("--------------------------------------------------------------");
        }

        else removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);

    }

    public static void goToJail(HashMap<String, Integer> playerCurrentPositionOnGameBoard,
                                String playerName, int playerIndex,
                                HashMap<Integer, String> squareOwners,
                                HashMap<Integer, String> gameSquares,
                                HashMap<Integer, Integer> playersMoney,
                                HashMap<Integer, Integer> squaresPrice,
                                int numberOfPlayers,
                                HashMap<Integer, String> playersNames,
                                int squareIndex, String squareName,
                                HashMap<Integer, Integer> squaresRent) {

        System.out.println("\nYou go to jail and will miss three moves!");
        playerCurrentPositionOnGameBoard.replace(playerName, 31);
        System.out.println("--------------------------------------------------------------");
    }

    public static void removePlayerFromGame(int playerIndex, String playerName, int numberOfPlayers,
                                            HashMap<Integer, String> squareOwners, ArrayList<Integer> lostPlayers,
                                            HashMap<Integer, String> playersNames) {

        System.out.println("\nYou must leave the game!");
        System.out.print("Press \"enter\" to leave:");

        if(isPlayerPressEnter()) {
            System.out.println("\n" + playerName + " lost the game!");
            System.out.println("---------------------------------------------------");

            updateSquareOwnersAfterPlayerLost(playerName, squareOwners);

            lostPlayers.add(playerIndex);
        }

        else {
            System.out.println("\nYou pressed wrong button/s! Let's try again...");
            removePlayerFromGame(playerIndex, playerName, numberOfPlayers, squareOwners, lostPlayers, playersNames);
        }
    }

    public static void updateSquareOwnersAfterPlayerLost(String playerName, HashMap<Integer, String> squareOwners) {
       for(int i = 1; i <= squareOwners.size(); i++) {

           if(squareOwners.get(i) != null && squareOwners.get(i).equals(playerName)) {
               squareOwners.replace(i, null);
           }
       }
    }

}