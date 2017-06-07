/**
 * 2015-11-05
 * Class: CrapsGameTester
 * @author D.B. Dressler
 */
public class CrapsGameTester {
    
    public static void main(String[] args){
       
        CrapsGame game = new CrapsGame();
        
        String message = game.doFirstRoll();
        
        System.out.println(message);
        
   
        while(!game.gameOver){
       
            message = game.rollAgain();
            System.out.println(message);
        }   
         if(game.isWon())       
                System.out.println("You win, big man!"); 
        else
                System.out.println("Loser...");
    }   
}
