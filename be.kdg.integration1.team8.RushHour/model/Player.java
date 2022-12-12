package model;

public class Player {
    String playerName; 
    int playerID; 



    public Player(String name, int id){
        this.playerName = name; 
        this.playerID = id; 
    }

    public Player(){
        this.playerName = "NONAME";
        this.playerID = 0; 
    }

    public void setName(String name){
        this.playerName = name; 
    }

    public void setID(int id){
        this.playerID = id; 
    }

    public String getName(){
        return this.playerName;
    }

    public int getID(){
        return playerID; 
    }
}
