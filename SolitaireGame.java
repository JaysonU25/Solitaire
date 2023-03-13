package Solitaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SolitaireGame {
    public static void main(String[] args){

        //************************Card Piles********************
        Stack<Card> firstPile = new Stack<>();
        firstPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> secondPile = new Stack<>();
        secondPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> thirdPile = new Stack<>();
        thirdPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> fourthPile = new Stack<>();
        fourthPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> fifthPile = new Stack<>();
        fifthPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> sixthPile = new Stack<>();
        sixthPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> seventhPile = new Stack<>();
        seventhPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> playPile = new Stack<>();
        playPile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> wastePile = new Stack<>();
        wastePile.push(new Card(Kind.EMPTY, Suit.EMPTY));

        //************************Foundation Piles********************
        Stack<Card> spadeFoundation = new Stack<>();
        spadeFoundation.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> clubFoundation = new Stack<>();
        clubFoundation.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> heartFoundation = new Stack<>();
        heartFoundation.push(new Card(Kind.EMPTY, Suit.EMPTY));

        Stack<Card> diamondFoundation = new Stack<>();
        diamondFoundation.push(new Card(Kind.EMPTY, Suit.EMPTY));

        //************************Creating Deck********************
        Stack<Card> deck = new Stack<>();
        Stack<Card> faceUpCards = new Stack<>();
        Deck testDeck = new Deck();
        testDeck.shuffle();
        for(int i = 0; i < 52; i++) {
            deck.push((Card)testDeck.getCards().get(i));
        }

//        for(int i = 0; i < 52; i++){
//            System.out.println(deck.pop().toString());
//        }

        //************************Starting stacks*****************
        int deal = 0;
        while(deal < 7){
            if(deal < 1){
                firstPile.push(deck.pop());
                secondPile.push(deck.pop());
                thirdPile.push(deck.pop());
                fourthPile.push(deck.pop());
                fifthPile.push(deck.pop());
                sixthPile.push(deck.pop());
                seventhPile.push(deck.pop());
                deal++;
            } else if(deal < 2){
                secondPile.push(deck.pop());
                thirdPile.push(deck.pop());
                fourthPile.push(deck.pop());
                fifthPile.push(deck.pop());
                sixthPile.push(deck.pop());
                seventhPile.push(deck.pop());
                deal++;
            } else if(deal < 3){
                thirdPile.push(deck.pop());
                fourthPile.push(deck.pop());
                fifthPile.push(deck.pop());
                sixthPile.push(deck.pop());
                seventhPile.push(deck.pop());
                deal++;
            } else if(deal < 4){
                fourthPile.push(deck.pop());
                fifthPile.push(deck.pop());
                sixthPile.push(deck.pop());
                seventhPile.push(deck.pop());
                deal++;
            } else if(deal < 5){
                fifthPile.push(deck.pop());
                sixthPile.push(deck.pop());
                seventhPile.push(deck.pop());
                deal++;
            } else if(deal < 6){
                sixthPile.push(deck.pop());
                seventhPile.push(deck.pop());
                deal++;
            } else if(deal < 7){
                seventhPile.push(deck.pop());
                deal++;
            }
        } // 7 Piles
        firstPile.peek().setFaceUp(true);
        secondPile.peek().setFaceUp(true);
        thirdPile.peek().setFaceUp(true);
        fourthPile.peek().setFaceUp(true);
        fifthPile.peek().setFaceUp(true);
        sixthPile.peek().setFaceUp(true);
        seventhPile.peek().setFaceUp(true);
        while (!deck.isEmpty()){
            playPile.push(deck.pop());
        } // playPile






        //*************************Playing************************
        /********************
         * Rules
         * foundations can only be started with an Ace
         * piles can be started with a king
         * piles stack from biggest to smallest
         * foundations stack from smallest to biggest
         * Can move multiple cards
         * colors alternate in piles
         *
         ******************/
        boolean winConMet = false;
        Scanner input = new Scanner(System.in);
        String userCommand = "";
        int stackChoice = 0;
        int numCards = 0;

        while (!winConMet){

            //***************************************************Shows Cards****************************************
            try {

                printFoundations(spadeFoundation.peek().getPic(), clubFoundation.peek().getPic(), heartFoundation.peek().getPic(), diamondFoundation.peek().getPic());
                printStacks(firstPile.peek().getPic(), secondPile.peek().getPic(), thirdPile.peek().getPic(), fourthPile.peek().getPic(), fifthPile.peek().getPic(), sixthPile.peek().getPic(), seventhPile.peek().getPic());
                printPlayWaste(playPile.peek().getPic(), wastePile.peek().getPic());

            } catch (FileNotFoundException ex) { // Visuals
                System.out.println("***NO PIC FOUND***");
            }

            //*****************************************************Asking for input***************************
            try {
                System.out.println("Enter 1 for the deck, 2 for the pile, or 3 for the waste pile.");
                userCommand = input.next();
                if (userCommand.equals("1")) { // Take from deck
                    System.out.println("Which pile would you like to move to?\n");

                    System.out.println("Enter 1 for the piles, 2 for the foundations, or 3 for the waste pile.");
                    stackChoice = input.nextInt();

                    if (stackChoice == 1) { // Deck to Pile
                        System.out.println("\nWhich pile?");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            moveCardToPile(playPile, 1, firstPile);
                            playPile.peek().setFaceUp(true);
                        } else if (stackChoice == 2) {
                            moveCardToPile(playPile, 1, secondPile);
                            playPile.peek().setFaceUp(true);
                        } else if (stackChoice == 3) {
                            moveCardToPile(playPile, 1, thirdPile);
                            playPile.peek().setFaceUp(true);
                        } else if (stackChoice == 4) {
                            moveCardToPile(playPile, 1, fourthPile);
                            playPile.peek().setFaceUp(true);
                        } else if (stackChoice == 5) {
                            moveCardToPile(playPile, 1, fifthPile);
                            playPile.peek().setFaceUp(true);
                        } else if (stackChoice == 6) {
                            moveCardToPile(playPile, 1, sixthPile);
                            playPile.peek().setFaceUp(true);
                        } else if (stackChoice == 7) {
                            moveCardToPile(playPile, 1, seventhPile);
                            playPile.peek().setFaceUp(true);
                        } else {
                            System.out.println("\nInvalid choice");
                        }

                    } else if (stackChoice == 2) { //Deck to Foundation
                        System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            moveCardToFoundation(playPile, 1, spadeFoundation);
                        } else if (stackChoice == 2) {
                            moveCardToFoundation(playPile, 2, clubFoundation);
                        } else if (stackChoice == 3) {
                            moveCardToFoundation(playPile, 3, heartFoundation);
                        } else if (stackChoice == 4) {
                            moveCardToFoundation(playPile, 4, diamondFoundation);
                        } else {
                            System.out.println("\nInvalid choice");
                        }

                    } else if (stackChoice == 3) {
                        wastePile.push(playPile.pop());
                        playPile.peek().setFaceUp(true);
                    }

                } //Deck
                else if (userCommand.equals("2")) { // Rearrange piles
                    System.out.println("Which Pile would you like to take from");
                    stackChoice = input.nextInt();

                    if (stackChoice == 1) {
                        Stack<Card> faceUps = getFaceUp(firstPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();

                            if (stackChoice == 1) {
                                System.out.println("\nInvalid choice");
                            }
                            else if (stackChoice == 2) {
                                moveCardToPile(firstPile, numCards, secondPile);
                            }
                            else if (stackChoice == 3) {
                                moveCardToPile(firstPile, numCards, thirdPile);
                            }
                            else if (stackChoice == 4) {
                                moveCardToPile(firstPile, numCards, fourthPile);
                            }
                            else if (stackChoice == 5) {
                                moveCardToPile(firstPile, numCards, fifthPile);
                            }
                            else if (stackChoice == 6) {
                                moveCardToPile(firstPile, numCards, sixthPile);
                            }
                            else if (stackChoice == 7) {
                                moveCardToPile(firstPile, numCards, seventhPile);
                            }
                            else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                        else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(firstPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(firstPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(firstPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(firstPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // First Pile
                    else if (stackChoice == 2) {
                        Stack<Card> faceUps = getFaceUp(secondPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToPile(secondPile, numCards, firstPile);
                            } else if (stackChoice == 2) {
                                System.out.println("\nInvalid choice");
                            } else if (stackChoice == 3) {
                                moveCardToPile(secondPile, numCards, thirdPile);
                            } else if (stackChoice == 4) {
                                moveCardToPile(secondPile, numCards, fourthPile);
                            } else if (stackChoice == 5) {
                                moveCardToPile(secondPile, numCards, fifthPile);
                            } else if (stackChoice == 6) {
                                moveCardToPile(secondPile, numCards, sixthPile);
                            } else if (stackChoice == 7) {
                                moveCardToPile(secondPile, numCards, seventhPile);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        } else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(secondPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(secondPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(secondPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(secondPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // Second Pile
                    else if (stackChoice == 3) {
                        Stack<Card> faceUps = getFaceUp(thirdPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToPile(thirdPile, numCards, firstPile);
                            } else if (stackChoice == 2) {
                                moveCardToPile(thirdPile, numCards, secondPile);
                            } else if (stackChoice == 3) {
                                System.out.println("\nInvalid choice");
                            } else if (stackChoice == 4) {
                                moveCardToPile(thirdPile, numCards, fourthPile);
                            } else if (stackChoice == 5) {
                                moveCardToPile(thirdPile, numCards, fifthPile);
                            } else if (stackChoice == 6) {
                                moveCardToPile(thirdPile, numCards, sixthPile);
                            } else if (stackChoice == 7) {
                                moveCardToPile(thirdPile, numCards, seventhPile);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        } else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(thirdPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(thirdPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(thirdPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(thirdPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // Third Pile
                    else if (stackChoice == 4) {
                        Stack<Card> faceUps = getFaceUp(fourthPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToPile(fourthPile, numCards, firstPile);
                            } else if (stackChoice == 2) {
                                moveCardToPile(fourthPile, numCards, secondPile);
                            } else if (stackChoice == 3) {
                                moveCardToPile(fourthPile, numCards, thirdPile);
                            } else if (stackChoice == 4) {
                                System.out.println("\nInvalid choice");
                            } else if (stackChoice == 5) {
                                moveCardToPile(fourthPile, numCards, fifthPile);
                            } else if (stackChoice == 6) {
                                moveCardToPile(fourthPile, numCards, sixthPile);
                            } else if (stackChoice == 7) {
                                moveCardToPile(fourthPile, numCards, seventhPile);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        } else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(fourthPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(fourthPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(fourthPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(fourthPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // Fourth Pile
                    else if (stackChoice == 5) {
                        Stack<Card> faceUps = getFaceUp(fifthPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToPile(fifthPile, numCards, firstPile);
                            } else if (stackChoice == 2) {
                                moveCardToPile(fifthPile, numCards, secondPile);
                            } else if (stackChoice == 3) {
                                moveCardToPile(fifthPile, numCards, thirdPile);
                            } else if (stackChoice == 4) {
                                moveCardToPile(fifthPile, numCards, fourthPile);
                            } else if (stackChoice == 5) {
                                System.out.println("\nInvalid choice");
                            } else if (stackChoice == 6) {
                                moveCardToPile(fifthPile, numCards, sixthPile);
                            } else if (stackChoice == 7) {
                                moveCardToPile(fifthPile, numCards, seventhPile);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        } else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(fifthPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(fifthPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(fifthPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(fifthPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // Fifth Pile
                    else if (stackChoice == 6) {
                        Stack<Card> faceUps = getFaceUp(sixthPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToPile(sixthPile, numCards, firstPile);
                            } else if (stackChoice == 2) {
                                moveCardToPile(sixthPile, numCards, secondPile);
                            } else if (stackChoice == 3) {
                                moveCardToPile(sixthPile, numCards, thirdPile);
                            } else if (stackChoice == 4) {
                                moveCardToPile(sixthPile, numCards, fourthPile);
                            } else if (stackChoice == 5) {
                                moveCardToPile(sixthPile, numCards, fifthPile);
                            } else if (stackChoice == 6) {
                                System.out.println("\nInvalid choice");
                            } else if (stackChoice == 7) {
                                moveCardToPile(sixthPile, numCards, seventhPile);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        } else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(sixthPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(sixthPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(sixthPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(sixthPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // Sixth Pile
                    else if (stackChoice == 7) {
                        Stack<Card> faceUps = getFaceUp(seventhPile);
                        System.out.println("These are the cards that can be moved.");

                        for (int i = 0; i < faceUps.size(); i++) {
                            System.out.println(faceUps.pop().toString());
                        }

                        System.out.println("\nHow many would you like to move?");
                        numCards = input.nextInt();

                        System.out.println("\nEnter 1 for a pile or 2 for a foundation.");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            System.out.println("\nWhich pile?");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToPile(seventhPile, numCards, firstPile);
                            } else if (stackChoice == 2) {
                                moveCardToPile(seventhPile, numCards, secondPile);
                            } else if (stackChoice == 3) {
                                moveCardToPile(seventhPile, numCards, thirdPile);
                            } else if (stackChoice == 4) {
                                moveCardToPile(seventhPile, numCards, fourthPile);
                            } else if (stackChoice == 5) {
                                moveCardToPile(seventhPile, numCards, fifthPile);
                            } else if (stackChoice == 6) {
                                moveCardToPile(seventhPile, numCards, sixthPile);
                            } else if (stackChoice == 7) {
                                System.out.println("\nInvalid choice");
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        } else if (stackChoice == 2) {
                            System.out.println("\nWhich foundation?(1-S 2-C 3-H 4-D)");
                            stackChoice = input.nextInt();
                            if (stackChoice == 1) {
                                moveCardToFoundation(seventhPile, 1, spadeFoundation);
                            } else if (stackChoice == 2) {
                                moveCardToFoundation(seventhPile, 2, clubFoundation);
                            } else if (stackChoice == 3) {
                                moveCardToFoundation(seventhPile, 3, heartFoundation);
                            } else if (stackChoice == 4) {
                                moveCardToFoundation(seventhPile, 4, diamondFoundation);
                            } else {
                                System.out.println("\nInvalid choice");
                            }
                        }
                    } // Seventh Pile
                } // Piles
                else if (userCommand.equals("3")) {
                    if (!wastePile.peek().getSuit().equals(Suit.EMPTY)) {
                        System.out.println("\nWhich pile?");
                        stackChoice = input.nextInt();

                        if (stackChoice == 1) {
                            moveCardToPile(wastePile, 1, firstPile);
                        } else if (stackChoice == 2) {
                            moveCardToPile(wastePile, 1, secondPile);
                        } else if (stackChoice == 3) {
                            moveCardToPile(wastePile, 1, thirdPile);
                        } else if (stackChoice == 4) {
                            moveCardToPile(wastePile, 1, fourthPile);
                        } else if (stackChoice == 5) {
                            moveCardToPile(wastePile, 1, fifthPile);
                        } else if (stackChoice == 6) {
                            moveCardToPile(wastePile, 1, sixthPile);
                        } else if (stackChoice == 7) {
                            moveCardToPile(wastePile, 1, seventhPile);
                        } else {
                            System.out.println("\nInvalid choice");
                        }
                    }
                } // Waste

                winConMet = winCheck(spadeFoundation, clubFoundation, heartFoundation, diamondFoundation);

            } catch (InputMismatchException ex){
                System.out.println("\nInvalid selection");
            }
        }
        System.out.println("You've Won!");






    }

    //***********************Win condition checker******************
    public static boolean winCheck(Stack<Card> foundation1,Stack<Card> foundation2, Stack<Card> foundation3, Stack<Card> foundation4){
        if(foundation1.peek().getKind().compareTo(Kind.KING) == 0 && foundation2.peek().getKind().compareTo(Kind.KING) == 0 && foundation3.peek().getKind().compareTo(Kind.KING) == 0 && foundation4.peek().getKind().compareTo(Kind.KING) == 0){
            return true;
        }
        return false;
    }

    //************************FaceUP recorder***********************
    public static Stack<Card> getFaceUp(Stack<Card> formerStack) {
        Stack<Card> wholeStack = new Stack<>();
        wholeStack = (Stack<Card>) formerStack.clone();
        Stack<Card> faceUpCards = new Stack<>();
        if(!formerStack.peek().getSuit().equals(Suit.EMPTY)) {
            while (wholeStack.peek().isFaceUp()) {
                faceUpCards.push(wholeStack.pop());
            }
            return faceUpCards;
        }
        return faceUpCards;
    }


    //************************Card Mover****************************
    public static void moveCardToPile(Stack<Card> formerStack, int numCards, Stack<Card> nextStack) {
        Stack<Card> faceUpCards = getFaceUp(formerStack);

        //*****************************No Cards in stack****************************
        if(formerStack.peek().getSuit().equals(Suit.EMPTY)){

            System.out.println("No card to move");

        } else {

            //*****************************numCards cannot be greater than faceUp cards**************************
            if (faceUpCards.size() >= numCards) {

                //*****************************Fixes num differences****************************
                while (faceUpCards.size() != numCards) {
                    faceUpCards.pop();
                }

                if ((faceUpCards.peek().getSuit().equals(Suit.SPADE) || faceUpCards.peek().getSuit().equals(Suit.CLUB)) && kindCheckerPile(formerStack, nextStack)) {

                    if (nextStack.peek().getSuit().equals(Suit.DIAMOND) || nextStack.peek().getSuit().equals(Suit.HEART) || nextStack.peek().getSuit().equals(Suit.EMPTY)) {

                        for (int i = 0; i < numCards; i++) { // Moves cards
                            nextStack.push(faceUpCards.pop());
                            nextStack.peek().setFaceUp(true);
                            formerStack.pop();
                            formerStack.peek().setFaceUp(true);

                        }

                    } else {
                        System.out.println("Invalid Move"); // Suit Didn't Match
                    }

                } else if ((faceUpCards.peek().getSuit().equals(Suit.HEART) || faceUpCards.peek().getSuit().equals(Suit.DIAMOND)) && kindCheckerPile(formerStack, nextStack)) {

                    if (nextStack.peek().getSuit().equals(Suit.SPADE) || nextStack.peek().getSuit().equals(Suit.CLUB) || nextStack.peek().getSuit().equals(Suit.EMPTY)) {

                        for (int i = 0; i < numCards; i++) { // Moves cards
                            nextStack.push(faceUpCards.pop());
                            nextStack.peek().setFaceUp(true);
                            formerStack.pop();
                            formerStack.peek().setFaceUp(true);
                        }

                    } else {
                        System.out.println("A " + formerStack.peek().getSuit() + " cannot go on top of a " + nextStack.peek().getSuit());  // Suit Didn't Match
                    }
                } else {
                    System.out.println("A " + formerStack.peek().getKind() + " cannot go on top of a " + nextStack.peek().getKind()); // Kind didn't match
                }
            } else {
                System.out.println("You cannot move that many cards"); // Num cards didn't make sense
            }
        }
    }

    public static void moveCardToFoundation(Stack<Card> formerStack, int foundNum, Stack<Card> nextFoundation){
        if(formerStack.peek().getSuit().equals(Suit.EMPTY)){
            System.out.println("No card to move");
        } else {
            if(foundNum == 1){
                if(formerStack.peek().getSuit().equals(Suit.SPADE) && kindCheckerFoundation(formerStack, nextFoundation)){
                    nextFoundation.push(formerStack.pop());
                    formerStack.peek().setFaceUp(true);
                } else {
                    System.out.println("Invalid Move");
                }
            } else if(foundNum == 2){
                if(formerStack.peek().getSuit().equals(Suit.CLUB) && kindCheckerFoundation(formerStack, nextFoundation)){
                    nextFoundation.push(formerStack.pop());
                    formerStack.peek().setFaceUp(true);
                } else {
                    System.out.println("Invalid Move");
                }
            } else if(foundNum == 3){
                if(formerStack.peek().getSuit().equals(Suit.HEART) && kindCheckerFoundation(formerStack, nextFoundation)){
                    nextFoundation.push(formerStack.pop());
                    formerStack.peek().setFaceUp(true);
                } else {
                    System.out.println("Invalid Move");
                }
            } else if(foundNum == 4) {
                if (formerStack.peek().getSuit().equals(Suit.DIAMOND) && kindCheckerFoundation(formerStack, nextFoundation)) {
                    nextFoundation.push(formerStack.pop());
                    formerStack.peek().setFaceUp(true);
                } else {
                    System.out.println("Invalid Move");
                }
            }
        }
    }


    //******************************Kind checks******************************
    public static boolean kindCheckerFoundation(Stack<Card> former, Stack<Card> nextStack){
        if(nextStack.peek().getKind().equals(Kind.EMPTY)){
            if(former.peek().getKind().equals(Kind.ACE))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.ACE)) {
            if (former.peek().getKind().equals(Kind.TWO))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.TWO)) {
            if (former.peek().getKind().equals(Kind.THREE))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.THREE)) {
            if (former.peek().getKind().equals(Kind.FOUR))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.FOUR)) {
            if (former.peek().getKind().equals(Kind.FIVE))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.FIVE)) {
            if (former.peek().getKind().equals(Kind.SIX))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.SIX)) {
            if (former.peek().getKind().equals(Kind.SEVEN))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.SEVEN)) {
            if (former.peek().getKind().equals(Kind.EIGHT))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.EIGHT)) {
            if (former.peek().getKind().equals(Kind.NINE))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.NINE)) {
            if (former.peek().getKind().equals(Kind.TEN))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.TEN)) {
            if (former.peek().getKind().equals(Kind.JACK))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.JACK)) {
            if (former.peek().getKind().equals(Kind.QUEEN))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.QUEEN)) {
            if (former.peek().getKind().equals(Kind.KING))
                return true;
            else
                return false;
        } else
            return false;
    }

    public static boolean kindCheckerPile(Stack<Card> former, Stack<Card> nextStack){
        if(nextStack.peek().getKind().equals(Kind.EMPTY)){
            if(former.peek().getKind().equals(Kind.KING))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.KING)) {
            if (former.peek().getKind().equals(Kind.QUEEN))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.QUEEN)) {
            if (former.peek().getKind().equals(Kind.JACK))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.JACK)) {
            if (former.peek().getKind().equals(Kind.TEN))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.TEN)) {
            if (former.peek().getKind().equals(Kind.NINE))
                return true;
            else
                return false;
        }  else if(nextStack.peek().getKind().equals(Kind.NINE)) {
            if (former.peek().getKind().equals(Kind.EIGHT))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.EIGHT)) {
            if (former.peek().getKind().equals(Kind.SEVEN))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.SEVEN)) {
            if (former.peek().getKind().equals(Kind.SIX))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.SIX)) {
            if (former.peek().getKind().equals(Kind.FIVE))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.FIVE)) {
            if (former.peek().getKind().equals(Kind.FOUR))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.FOUR)) {
            if (former.peek().getKind().equals(Kind.THREE))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.THREE)) {
            if (former.peek().getKind().equals(Kind.TWO))
                return true;
            else
                return false;
        } else if(nextStack.peek().getKind().equals(Kind.TWO)) {
            if (former.peek().getKind().equals(Kind.ACE))
                return true;
            else
                return false;
        } else
            return false;
    }

    //**********************Visuals*****************************
    public static void printFoundations(File picFile1, File picFile2, File picFile3, File picFile4) throws FileNotFoundException {
        Scanner in1 = new Scanner(picFile1);
        Scanner in2 = new Scanner(picFile2);
        Scanner in3 = new Scanner(picFile3);
        Scanner in4 = new Scanner(picFile4);

        while(in1.hasNextLine()){
            System.out.print("\t\t\t\t\t");
            System.out.print(in1.nextLine());
            System.out.print(in2.nextLine());
            System.out.print(in3.nextLine());
            System.out.print(in4.nextLine());
            System.out.println();
        }
    }

    public static void printStacks(File picFile1, File picFile2, File picFile3, File picFile4, File picFile5, File picFile6, File picFile7) throws FileNotFoundException {
        Scanner in1 = new Scanner(picFile1);
        Scanner in2 = new Scanner(picFile2);
        Scanner in3 = new Scanner(picFile3);
        Scanner in4 = new Scanner(picFile4);
        Scanner in5 = new Scanner(picFile5);
        Scanner in6 = new Scanner(picFile6);
        Scanner in7 = new Scanner(picFile7);

        while(in1.hasNextLine()){
            System.out.print("\t\t");
            System.out.print(in1.nextLine());
            System.out.print(in2.nextLine());
            System.out.print(in3.nextLine());
            System.out.print(in4.nextLine());
            System.out.print(in5.nextLine());
            System.out.print(in6.nextLine());
            System.out.print(in7.nextLine());
            System.out.println();
        }
    }

    public static void printPlayWaste(File picFile1, File picFile2) throws FileNotFoundException {
        Scanner in1 = new Scanner(picFile1);
        Scanner in2 = new Scanner(picFile2);
        while(in1.hasNextLine()){
            System.out.print("\t\t\t\t\t\t");
            System.out.print(in1.nextLine());
            System.out.print("\t\t\t");
            System.out.print(in2.nextLine());
            System.out.println();
        }
    }
}
