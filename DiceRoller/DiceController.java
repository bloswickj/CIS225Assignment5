/**
 * A class for storing and manipulating the dice of the game.
 * 
 * @author John Bloswick 
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DiceController
{
    private ArrayList<Die> dice;
    private int targetNumber, dieType, dieCount;    
    
    public DiceController()
    {
        dice = new ArrayList<Die>();
    }
    
    public void addDice()
    {
        boolean validResponse = false;
        Scanner scan = new Scanner(System.in);
        
        while(!validResponse)
        {
            System.out.println("\nPlease enter a die type for your game. (4, 6, 8, 10, 12, 20, or 100): ");
            dieType = scan.nextInt();
            if(dieType == 4 || dieType == 6 || dieType == 8 || dieType == 10 || dieType == 12 || dieType == 20 || dieType == 100)
            {
                validResponse = true;
            }
        }
        while(dieCount < 1 || dieCount > 10)
        {
            System.out.println("\nPlease enter the number of dice for the game. (max 10): ");
            dieCount = scan.nextInt();
        }
        for(int i = 0; i < dieCount; i++)
        {
            if(dice.size() <= 10)
            {
                addDie(dieType);
            }
        }
    }
    
    public ArrayList<Integer> rollDice()
    {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        
        for(Die die : dice)
        {
            int roll = die.rollDie();
            if(roll == die.getDieType())
            {
                int totalRoll = roll;
                while(roll == die.getDieType())
                {
                    roll = die.rollDie();  
                    totalRoll += roll;
                }
                rolls.add(totalRoll);
            }
            else
            {
                rolls.add(roll);
            }
        }
        return rolls;
    }
    
    public boolean checkRollsForBust(ArrayList<Integer> rolls)
    {
        int onesCounter = 0;
        
        for(Integer roll : rolls)
        {
            if(roll == 1)
            {
             onesCounter++;  
            }
        }
        if(onesCounter > rolls.size() / 2)
        {
            return true;
        }
        return false;
    }
    
    public boolean checkRollsForTargetNumber(ArrayList<Integer> rolls)
    {
        int rollTotal = 0;
        
        for(Integer roll : rolls)
        {
            rollTotal += roll;
        }
        if (rollTotal >= targetNumber)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void printRolls(ArrayList<Integer> rolls)
    {
        int totalRoll = 0;
        
        System.out.println("\nYour rolls are: ");
        for(int i = 0; i < rolls.size(); i++)
        {
            System.out.println(rolls.get(i));
            totalRoll += rolls.get(i);
        }
        System.out.print("Your total roll is: " + totalRoll);
    }
    
    public void setTargetNumber()
    {
        int targetMin = dieType, targetMax = dieType * dieCount;
        Scanner scan = new Scanner(System.in);
        
        while(targetNumber < targetMin || targetNumber > targetMax)
        {
            System.out.println("\nPlease enter a target number. (min " + targetMin + " & max " + targetMax + "): ");
            targetNumber = scan.nextInt();
        }
    }
    
    private void addDie(int dieType)
    {
        dice.add(new Die(dieType));
    }
    
}
