
import java.awt.*;
import java.awt.geom.*;

/**
 * 2015-11-05
 * 
 * Class: DieFace
 * @author EEU436
 */

//shape class
public class DieFace{
    
    final double xLeft, yTop, dieWidth, dieHeight;
    double pipWidth, pipHeight;
    final double pipRatio = 0.45;
    double distanceXLeft;
    double distanceYTop;
    double distanceXRight;
    double dieCenterX;
    int faceVal;
    int parityFlag;
    Color dieColor;
    
    /**
     * Constructor:
     * Contains modulus operation to determine face value's parity.
     * @param xLeft Left x coordinate.
     * @param yTop Top y coordinate.
     * @param dieWidth Die's width.
     * @param dieHeight Die's height.
     * @param faceVal Face value.
     * @param dieColor Die's color.
     */
    public DieFace(double xLeft, double yTop, double dieWidth, double dieHeight, int faceVal, Color dieColor){
        
        this.xLeft = xLeft;
        this.yTop  = yTop;
        this.dieWidth = dieWidth;
        this.dieHeight = dieHeight;
        this.faceVal = faceVal;
        this.dieColor = dieColor;
        //System.out.println(faceVal);
        
        //sets flag to 2 if even
        if(this.faceVal%2 == 0){
            
            parityFlag = 2;
        } else {
            
            parityFlag = 1;
        }
    }
    
    /**
     * Method does base calculations for pip ratios and positioning
     * Contains a parity-based switch for drawing
     * @param g2 
     */
    public void draw(Graphics2D g2){
        
        //
        Rectangle2D.Double die = new Rectangle2D.Double(xLeft, yTop, dieHeight, dieWidth);
        distanceXLeft = die.getMinX()*0.10 + xLeft;
        distanceYTop = die.getMinY()*0.1 + yTop;
        pipWidth = die.getMinX()*pipRatio;
        pipHeight = die.getMinY()*pipRatio;
        dieCenterX = die.getCenterX();
        
        //Ellipse2D.Double northWestPip = new Ellipse2D.Double(distanceYTop, distanceXLeft, pipWidth, pipHeight);
        
        
        //drawing
        g2.setColor(dieColor);
        g2.fill(die);
        
        g2.setColor(Color.WHITE);
        
        //drawing pips
        switch(parityFlag){
            //uneven
            case 1: drawCenterPip(g2);
                    
                    if(faceVal == 1){
                        break;
                    }
                    drawSouthWestPip(g2);
                    drawNorthEastPip(g2);
                    if(faceVal == 3){
                        break;
                    }
                    drawNorthWestPip(g2);
                    drawSouthEastPip(g2);
                    if(faceVal == 5){
                        break;
                    }
            //even
            case 2:
                    drawSouthWestPip(g2);
                    drawNorthEastPip(g2);
                    if(faceVal == 2){
                        break;
                    }
                    drawNorthWestPip(g2);
                    drawSouthEastPip(g2);
                    if(faceVal == 4){
                        break;
                    }
                    drawWestPip(g2);
                    drawEastPip(g2);
                    if(faceVal == 6){
                        break;
                    }
            default: System.out.println("no face value"); break;
                
        }
    }
        
    /**
     * Draws the north west pip
     * @param g2 
     */
    private void drawNorthWestPip(Graphics2D g2){
        
        Ellipse2D.Double northWestPip = 
                new Ellipse2D.Double(distanceXLeft, distanceYTop, 
                        pipWidth, pipHeight);
        g2.fill(northWestPip);
    }
    
    /**
     * draws the west pip
     * @param g2 
     */
    private void drawWestPip(Graphics2D g2){
        
        Ellipse2D.Double westPip = 
                new Ellipse2D.Double(distanceXLeft, distanceYTop*1.6, 
                        pipWidth, pipHeight);
        g2.fill(westPip);
    }
    
    /**
     * draws the south west pip
     * @param g2 
     */
    private void drawSouthWestPip(Graphics2D g2){
        
        Ellipse2D.Double westPip = 
                new Ellipse2D.Double(distanceXLeft, distanceYTop*2.19, 
                        pipWidth, pipHeight);
        g2.fill(westPip);
    }
    
    /**
     * Draws the north east pip.
     * @param g2 
     */
    private void drawNorthEastPip(Graphics2D g2){
        
        Ellipse2D.Double northEastPip = 
                new Ellipse2D.Double(distanceXLeft*2.2, distanceYTop,
                        pipWidth, pipHeight);
        g2.fill(northEastPip);
    }
    
    /**
     * Draws the east pip.
     * @param g2 
     */
    private void drawEastPip(Graphics2D g2){
        
        Ellipse2D.Double eastPip = 
                new Ellipse2D.Double(distanceXLeft*2.2, distanceYTop*1.6, 
                        pipWidth, pipHeight);
        g2.fill(eastPip);
    }
    
    /**
     * Draws the south east pip.
     * @param g2 
     */
    private void drawSouthEastPip(Graphics2D g2){
        
        Ellipse2D.Double southEastPip = 
                new Ellipse2D.Double(distanceXLeft*2.2, distanceYTop*2.19, 
                        pipWidth, pipHeight);
        g2.fill(southEastPip);
    }
    
    /**
     * Draws the center pip.
     * @param g2 
     */
    private void drawCenterPip(Graphics2D g2){
        
       Ellipse2D.Double centerPip = 
                new Ellipse2D.Double(distanceXLeft*1.6, distanceYTop*1.6, 
                        pipWidth, pipHeight);
        g2.fill(centerPip);
    }
}