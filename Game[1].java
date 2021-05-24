package Lab10;
import java.util.Scanner;

public class Game {
    public static Deck gameDeck;
    public static int playerCards;
    public static int dealerCards;
    public static Card [] playerHand = new Card [11];
    public static Card [] dealerHand = new Card [11];
    
    public Game(){
        gameDeck = new Deck ();
        playerCards = 0;
        dealerCards = 0;
        Card [] playerHand = {};
        Card [] dealerHand = {};
    }
    
    public static void printHand(char type){
        if(type == 'p'){
            for (Card p : playerHand){
                if (p != null){
                System.out.println(p);
                }
            }
        }
        else if(type == 'd'){
            for (Card p : dealerHand){
                if (p != null){
                System.out.println(p);
                }
            }
        }
    }
    
    public static void giveCard(char type){
        Card c = gameDeck.dealCard();
        if(type == 'p'){
            playerHand [playerCards++] = c;
        }
        else if(type == 'd'){
            dealerHand [dealerCards++] = c;
        }
    }
    
    public static int calculate(Card [] hand){
        int p = 0;
        for(Card c : hand){
            if(c != null){
                if(c.getValue() == 11 || c.getValue() == 12 || c.getValue() == 13){
                    p += 10;
                }
                else if (c.getValue() == 1 ){
                    p += 1;
                } 
                else{
                    p += c.getValue();
                }
            }
        }
        return p;
    }
           
    public static void determineResult(){
        Scanner input = new Scanner (System.in);
        boolean win = true;
        
        while(win && (calculate(dealerHand) <= 21) && (calculate(playerHand)<= 21)){
            win = true;
            System.out.print("(1)Hit or (2)Stay: ");
            int choice = input.nextInt();
            if(choice == 2){
                if(calculate(dealerHand) >= calculate(playerHand)){
                    System.out.println("Dealers Hand: ");
                    printHand('d');
                    System.out.println("Player:"+ calculate(playerHand) +" "+ "Dealer: " + calculate(dealerHand));
                    System.out.println("Sorry - you lose");
                    win = false;
                }
                else{
                    System.out.println("Dealers Hand: ");
                    printHand('d');
                    System.out.println("Player:"+ calculate(playerHand) +" "+ "Dealer: " + calculate(dealerHand));
                    System.out.println("Congrats - You win!");
                    win = false;
                }
            }
            else if (choice == 1){
                giveCard('p');
                while(calculate(dealerHand)<17){
                    giveCard('d');
                }
                System.out.println("Your Hand: ");
                printHand('p');
                if(calculate(dealerHand) >= calculate(playerHand)){
                    System.out.println("Dealers Hand: ");
                    printHand('d');
                    System.out.println("Player:"+ calculate(playerHand) +" "+ "Dealer: " + calculate(dealerHand));
                    System.out.println("Sorry - you lose");
                    win = false;
                }
                else if(calculate(dealerHand) < calculate(playerHand)) {
                    System.out.println("Dealers Hand: ");
                    printHand('d');
                    System.out.println("Player:"+ calculate(playerHand) +" "+ "Dealer: " + calculate(dealerHand));
                    System.out.println("Congrats - You win!");
                    win = false;
                }
            }
        }
        input.close();
    }
        
    public static void play(){
        giveCard('p');
        giveCard('d');
        giveCard('p');
        giveCard('d');
        System.out.println("Your Hand: ");
        printHand('p');
        determineResult();
        }
    }
