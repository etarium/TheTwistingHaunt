/**
 *
 * @author jason
 */
public class Client {
    
    Player player;
    
    
    public Client() {
    }
    
    public void newGame(Player player){
        // create new instance of the game for the player using the input from the creator
        //save player
        this.player = player;
        
        loadCell(0); //loads the first cell for play
        runGame();
    }
    
    public void loadGame(){
        //load game for play
        
        runGame();
    }
    
    public void runGame(){
        while(true){
            
        }
        
    }
    
    public void loadCell(int i){
        if(i == 0){ //load new game from first cell
            
            
        }
        else{
            //load cell of ID i
        }
        
    }
    
    public void saveGame(){
        //save game state for later loading
    }
}


