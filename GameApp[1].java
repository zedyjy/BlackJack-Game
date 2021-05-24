package Lab10;
import java.util.Scanner;

public class GameApp {
    public static void main (String [] args){
        Scanner input = new Scanner (System.in);
        Game p = new Game();
        boolean s = true;
        String choice;
        while(s){
            System.out.print("Play again? (y/n): ");
            choice = input.nextLine();
            if(choice.equals("y")){
                p.play();
                s = true;
            }
            else if(choice.equals("n")){
                System.out.print("Thanks for playing - Goodbye!");
                s = false;
            }
        }
        input.close();
    } 
}
