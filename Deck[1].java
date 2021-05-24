package Lab10;
import java.util.Random;

public class Deck {
    
    private Card [] deck;
	private int deckSize = 52;
	private int topCard;
	
	// This constructor builds a deck of 52 cards.
	public Deck(){
        initialize();
        topCard = 0;
        shuffle();
    }
    
    public void initialize(){
        deck = new Card[52];
        int index = 0;
        
        for (int i = 0; i < 4; i++){
            for (int j = 1; j < 14; j++){
                deck[index++] = new Card(i, j);
            }
        }
    }

	// This method shuffles the deck (randomizes the array of cards).
	public void shuffle(){
        
		Random r = new Random();
		
		for (Card c : deck){
			int x = r.nextInt(52);
			Card temp = c;
			c = deck[x];
			deck[x] = temp;
		}
	}
	
	/*public static void printArray( Card [] deck){
		for (Card p : deck){
			System.out.println(p);
		}
	}*/
		
	// Ttakes the top card off the deck and returns it.
	public Card dealCard(){
		Card current = deck[topCard];
		topCard++;
		deckSize--;
		return current;
    }
    
    public String toString(){
        String s = "";
        for (Card p : deck){
            System.out.println(p);
            s += (p + "");
        }
        return s + "\n";
    }

	public int getSize(){
		return deckSize;
	}
}
