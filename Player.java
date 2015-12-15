import java.io.*;

public class Player extends Camp{
	public Role role;
	private String player_name ;
	private int money;
	private int num_soldier;
    public Commander commander = new Commander();

	public Player(int num){
        this.setCampNum(num);
		this.setMoney(100); 			// initial money
		this.setNumSoldier(100); 		// initial soldier
		this.player_name = new String("player_no_name"+num) ;
		role = setRole(0);
        
	}
	public void setPlayerName(String name){
		this.player_name = name;
		
	}
	public Role setRole(int role_id){
		role = new Role( role_id );
		this.role = role;
		return role;
	}

	public void setMoney( int money ){
		this.money = money;
	}

	public void setNumSoldier( int num_soldier){
		this.num_soldier = num_soldier;
	}

	public String getPlayerName(){
		return this.player_name;
	}

	public int getMoney(){
		return this.money;
	}

	public int getNumSoldier(){
		return this.num_soldier;
	}
    
    public void setArmy(Tower tower) throws IOException{
        commander.dispatchArmy(this, tower);
    }
}