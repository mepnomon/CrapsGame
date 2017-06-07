
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 2015-11-05
 * Sem. 3, Lab: 4 - Assessment
 * Class: CrapsGameFrame
 * @author D.B. Dressler
 */
public class CrapsGameFrame extends JFrame {
   
    //Control variables
    boolean     gameOver = false;
    boolean     firstRoll = true;
    
    //Frame parameters
    final int   FRAME_WIDTH = 350;
    final int   FRAME_HEIGHT = 250;
    
    JPanel  gameButtonPanel;
    JPanel  gameStateDisplayPanel;
    JLabel  gameStateDisplayLabel;
    
    JButton rollButton;
    JButton resetButton;
    
    //Game objects
    DiceFacePanel   dieFacePanel;
    CrapsGame       game;
     
        
    /**
     * Constructor for Craps Game Frame.
     * Instantiates Craps Game.
     * Setup for Game Frame.
     * Adds components to frame
     */
    public CrapsGameFrame(){
        
        game = new CrapsGame();
        addComponents();
        setupGameFrame();
    }
    
    /**
     * Sets up game Frame.
     * Adds Parameters for width.
     * Sets title.
     */
    private void setupGameFrame(){
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Craps Game v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
    }
    
    /**
     * Add components method.
     * Used in the setup of the game frame.
     */
    private void addComponents(){
        
        //instantiates action listener      
        ActionListener listener = new DieGameActionListener();
        
        //instantiates panels
        dieFacePanel = new DiceFacePanel();                                     
        gameStateDisplayPanel = new JPanel();
        gameButtonPanel = new JPanel();
        
        //instantiates Labels 
        gameStateDisplayLabel = new JLabel("Click roll'em to play."); 
        gameStateDisplayPanel.add(gameStateDisplayLabel);
        
        //instantiates buttons and attaches action listener
        rollButton = new JButton("Roll 'em");
        rollButton.addActionListener(listener);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(listener);
        resetButton.setEnabled(false);
        
        //adds buttons to button panel
        gameButtonPanel.add(rollButton);
        gameButtonPanel.add(resetButton);
        
        //adds panels to frame
        add(gameStateDisplayPanel, BorderLayout.NORTH);
        add(dieFacePanel, BorderLayout.CENTER);
        add(gameButtonPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Inner class listens for an action
     * on buttons.
     */
    class DieGameActionListener implements ActionListener{
        
        /**
         * Chooses operations to execute.
         * @param ae action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            //rest game
            if(ae.getActionCommand().equals("Reset")){
                
                game = new  CrapsGame();
                firstRoll = true;
                gameStateDisplayLabel.setText("Sum: "+ 0 + " Point: " +0);
                game.resetGame();
                dieFacePanel.resetImage();
                gameOver = false;
                resetButton.setEnabled(false);
            }
            
            //play game
            if(ae.getActionCommand().equals("Roll 'em")){
               
                playCrapsGame();
            }
        }
    }
    
    /**
     * Connects game logic to graphics.
     * Determines whether game is won or lost.
     * Determines whether more rolls than first are needed.
     * 
     */
    private void playCrapsGame(){
        
        int die1Val;
        int die2Val;
        
        if(!gameOver){
        
            if(firstRoll == true){
                
                game.doFirstRoll();
                
                die1Val = game.getDie1FaceValue();
                die2Val = game.getDie2FaceValue();
                
                gameStateDisplayLabel.setText("Sum: "+ game.getSum() + " Point: " + game.getPoint());
                dieFacePanel.updateDiceFacePanel(die1Val, die2Val);
                firstRoll = false;
                    
                if(game.gameWon == false &&  game.isOver() == true){
                    
                    gameStateDisplayLabel.setText("Sum: "+ game.getSum() + " Point: " + game.getPoint());
                    
                    resetButton.setEnabled(true);
                    JOptionPane.showMessageDialog(null,"Loser...");
                    gameOver = true;
                    //System.exit(0);
                }
                if(game.gameWon == true){
                    
                    gameStateDisplayLabel.setText("Sum: "+ game.getSum() + " Point: " + game.getPoint());
                    resetButton.setEnabled(true);
                    gameOver = true;
                    JOptionPane.showMessageDialog(null,"You win, big man!");
                    //System.exit(0);
                }   

            }
            else{ //consecutive rolls
                
                game.rollAgain();
                die1Val = game.getDie1FaceValue();
                die2Val = game.getDie2FaceValue();
                
                gameStateDisplayLabel.setText("Sum: "+ game.getSum() + " Point: " + game.getPoint());
                dieFacePanel.updateDiceFacePanel(die1Val, die2Val);
                    
                if(game.gameWon == false &&  game.isOver() == true){
                
                    gameOver = true;
                    
                    //triggers a dialog box
                    resetButton.setEnabled(true);
                    JOptionPane.showMessageDialog(null,"Loser...");
                    //System.exit(0);
                            
                }
                if(game.gameWon == true){
                        
                    //System.out.println("YOU WIN");
                    resetButton.setEnabled(true);
                    gameOver = true;
                    JOptionPane.showMessageDialog(null,"You win, big man!");
                    //System.exit(0);
                }
            }   
        }
    }
}
