/**
 * 2015-11-05
 * Sem. 3, Lab: 4 - Assessment
 * Class: CrapsGame
 * @author D.B. Dressler
 */
public class CrapsGame {
    
        //instance variables
        private Die die1 = new Die();
        private Die die2 = new Die();
        private static int sum;
        private int point;
        boolean gameOver;
        boolean gameWon;
   
        /**
         * Constructor for Craps Game
         * sets point, sum to 0
         * sets gameOver and gameWon to false
         */
        public CrapsGame(){
            
            point = 0;
            sum = 0;
            gameOver = false;
            gameWon = false;
        }
        
        /**
         * Rolls the Dice for the first time.
         * Gets sum of both dice values.
         * If sum is 7, 11 (Player wins).
         * If sum is 2, 3, 12 (Computer wins).
         * Otherwise it sets sum as the points
         * to match in next rolls.
         * @return a String containing Values of the dice face values.
         */
        public String doFirstRoll(){
            
            
            die1.throwDie();
            die2.throwDie();
            
            sum = die1.getFaceValue() + die2.getFaceValue();
            
            switch(sum){
                
                case 2:     
                case 3:     gameOver = true; break;
                case 4:     
                case 5:     
                case 6:     point = sum; break;
                case 7:     gameWon = true; gameOver = true; break;
                case 8:     
                case 9:     
                case 10:    point =  sum; break;
                case 11:    gameWon = true; gameOver = true; break;
                case 12:    gameOver = true; break;
            }
            
            String message = String.format("d1 = %-3d d2 = %-3d",die1.getFaceValue(), die2.getFaceValue());
            
            return message;
        }
        
        /**
         * Rolls the dice again.
         * If their sum is equal to the points (Player wins!).
         * If the sum is 7 (Player loses :( ).
         * @return a String containing the dice's face values, 
         * their sum and the points.
         */
        public String rollAgain(){
            
            die1.throwDie();
            die2.throwDie();
            
            sum = die1.getFaceValue() + die2.getFaceValue();
            
            if(point == sum){
                
                gameWon = true;
                gameOver = true;
            }
            if(sum == 7){
                
                gameWon = false;
                gameOver = true;
            }
            
            String message = String.format("d1 = %-3d d2 = %-3d sum =%-3d "
                    + "point = %-3d", die1.getFaceValue(), die2.getFaceValue(), 
                    sum, point);
            
            return message;
        }
        
        /**
         * A method that checks if the player won.
         * @return a boolean (true if won).
         */
        public boolean isWon(){
            
            return gameWon;
        }
        
        /**
         * A method that checks if the game is over.
         * @return a boolean
         */
        public boolean isOver(){
            
            return gameOver;
        }
        
       /**
        * 
        * @return integer face  value of the 1st die
        */
        public int getDie1FaceValue(){
            
            return die1.getFaceValue();
        }
        
        /**
         * 
         * @return integer face value of the 2nd die.
         */
        public int getDie2FaceValue(){
            
            return die2.getFaceValue();
        }
        
        /**
         * 
         * @return the sum of both die.
         */
        public int getSum(){
            
            return sum;
        }
        
        /**
         * 
         * @return the point.
         */
        public int getPoint(){
            
            return point;
        }
        
        //testing for rest
        public void resetGame(){
            
            sum = 0;
            point = 0;
            
        }
}
