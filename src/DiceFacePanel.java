import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * 2015-11-05
 * Class: DiceFacePanel
 * @author D.B. Dressler
 */

public class DiceFacePanel extends JPanel{
    
    final int resetDieFace = 6;
   //pass faceVal thru this class
    DiceFaceComponent die1 = new DiceFaceComponent(Color.BLACK);
    DiceFaceComponent die2 = new DiceFaceComponent(Color.RED);
    
    
    /**
     * Constructor for Dice Face Panel.
     * Sets preferred sizes and adds dice to Panel.
     */ 
    public DiceFacePanel(){
        
        die1.setPreferredSize(new Dimension(150, 150));
        add(die1);
        die2.setPreferredSize(new Dimension(150, 150));
        add(die2);
    }
    
    /**
     * Calls DiceFaceComponent's updateImage method.
     * @param faceVal1 face value of 1st die.
     * @param faceVal2 face value of 2nd die.
     */
    public void updateDiceFacePanel(int faceVal1, int faceVal2){
        
        die1.updateImage(faceVal1);
        die2.updateImage(faceVal2);
        
    }
    
    /**
     * Used to reset displayed dice to 6.
     * Calls DiceFaceComponent's updateImage method.
     */
    public void resetImage(){
        
        die1.updateImage(resetDieFace);
        die2.updateImage(resetDieFace);
    }
}
