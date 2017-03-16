/**
 * A class that handles the flow of the game.
 * 
 * @author John Bloswick 
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager
{   
    public void gameLoop()
    {
        boolean gameOver = false;
           
        while(!gameOver)
        {
            ArrayList<Integer> rolls = new ArrayList<Integer>();
            DiceController diceController = new DiceController();
            
            diceController.addDice();
            diceController.setTargetNumber();
            rolls = diceController.rollDice();
            diceController.printRolls(rolls);
            if(diceController.checkRollsForBust(rolls))
            {
                System.out.println("It's a bust!");
            }
            else
            {
                if(diceController.checkRollsForTargetNumber(rolls))
                {
                    System.out.println("\nTarget number was hit!");
                }
                else
                {
                    System.out.println("\nTarget number was NOT hit!");
                }
                if(!checkPlayAgain())
                {
                   gameOver = true; 
                }
            }      
        }
        printGoodbye();               
    }
    
    private boolean checkPlayAgain()
    {
        boolean validResponse = false;
        String userInput = "";
        Scanner scan = new Scanner(System.in);
        
        while(!validResponse)
        {
            System.out.println("\nWould you like to play again? (yes or no): ");
            userInput = scan.next().toUpperCase();
            if(userInput.equals("YES") || userInput.equals("NO"))
            {
                validResponse = true;
            }
        }
        if(userInput.equals("YES"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void printGoodbye()
    {
        System.out.println("\n\tThanks for playing! Goodbye.");
    }
}
