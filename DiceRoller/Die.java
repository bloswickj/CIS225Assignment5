/**
 * A class for storing an individual die's information and functions.
 * 
 * @author John Bloswick 
 * @version 1.0
 */

import java.util.Random;

public class Die
{
    int dieType;
    
    public Die(int dieType)
    {
        this.dieType = dieType;
    }
    
    public int rollDie()
    {
        Random rand = new Random();
        
        int result = rand.nextInt(dieType) + 1;
        return result;     
    }
    
    public void setDieType(int dieType)
    {
        this.dieType = dieType;
    }
    
    public int getDieType()
    {
        return dieType;
    }
}
