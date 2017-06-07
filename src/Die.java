import java.util.Random;

/**
 * 2015-11-05
 * Class: Die
 * @author D.B. Dressler
 */
public class Die {
    
    private int faceValue;
    private int sides;
    private Random generator;
    
    
    /**
    * Constructs a die with six sides if no parameter is supplied.
    */
    public Die(){
        
        this.sides = 6;
    }
    
    /**
    * Constructs a die with sides specified by supplied parameter.
    */
    
    public Die(int s){
        
        this.sides = s;
    }
    
    /**
    * Simulates the throwing of the die.
    * Generates Random number within limit specified by chosen sides.
    */
    public void throwDie(){
        
        generator = new Random();
        this.faceValue = generator.nextInt(sides) + 1;
    }
    
    /**
    * Accesses face value.
    * @return face value of die
    */
    public int getFaceValue(){
	
        return this.faceValue;
    }
    
    /**
    * Creates a formatted String of die faceValue and sides.
    * @return formatted String
    */
    @Override
    public String toString(){
        
        return getClass().getName() + "[faceValue=" + faceValue + ", sides=" + sides + "]";
    }   
}