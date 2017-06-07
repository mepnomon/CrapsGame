import javax.swing.*;
import java.awt.*;

/**
 * 2015-11-05
 * Class: DiceFaceComponent
 * @author D.B. Dressler
 */
public class DiceFaceComponent extends JComponent {
    
    int dieFaceVal;
    Color dieColor;
    
    public DiceFaceComponent(Color dieColor){
        
        this.dieColor = dieColor;
        this.dieFaceVal = 0;
    }
    
    /**
     * Paint Component.
     * Handles anti-aliasing.
     * Calculates shape width.
     * Instantiates DieFace class.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        

        //typecasting
        Graphics2D g2 = (Graphics2D) g;
        //anti aliasing
        g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        double shapeWidth = (getWidth()*.5);   //50% of pane width
        double shapeHeight = (getHeight() *.5);
        double yTop;
        double xLeft;
        
        if(shapeWidth < shapeHeight){
           
            shapeHeight = shapeWidth; 
            xLeft = (getWidth()/2 - shapeHeight/2);
            yTop = (getWidth()/2 - shapeWidth/2);
            
        }else{ 
            
            shapeWidth = shapeHeight;
            xLeft = (getHeight()/2 - shapeHeight/2);
            yTop = (getHeight()/2 - shapeHeight/2);
        }
        
        
     
        DieFace dieFace = new DieFace(xLeft, yTop, shapeWidth, shapeHeight, dieFaceVal, dieColor);
        dieFace.draw(g2);
    }
    
    /**
     * Calls draw method via repaint.
     * @param dieFaceVal the face value of the die.
     */
    public void updateImage(int dieFaceVal){
        
        this.dieFaceVal = dieFaceVal;
        repaint();
    }
}
