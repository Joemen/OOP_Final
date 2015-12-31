import java.io.*;

public class Player extends Camp{
	public Role role;
	private int player_id;
	private String player_name ;
	private int money;
	private int num_soldier;
	private int num_off_soldier;		// to count total offensive soldier
	private int num_def_soldier;		// to count total defensive soldier
    public Commander commander = new Commander();
    private int intelligence;
    public int[] pocket;

	public Player(int num, int player_id){
        // Camp
        this.setCampName(num);
        this.setCampNum(num);
        // Player information
		this.setMoney(100); 				// initial money
		this.setNumSoldier(100); 			// initial soldier
		this.setNumOffSoldier(0); 			// initial offensive soldier
		this.setNumDefSoldier(0); 			// initial defensive soldier
        this.setPlayerID( player_id );
		this.setIntelligence(0);
		this.setPocket();
        this.player_name = new String("player_no_name"+this.player_id) ;
		role = setRole(0);
		
        
	}

	////////// about set //////////
	public void setPlayerName(String name){
        this.player_name = name;
  	}
  	
	public void setPlayerID( int player_id ){
		this.player_id = player_id;
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

	public void setNumOffSoldier( int num_soldier){
		this.num_off_soldier = num_soldier;
	}

	public void setNumDefSoldier( int num_soldier){
		this.num_def_soldier = num_soldier;
	}
	public void setIntelligence(int num){
    	this.intelligence = num;
    }
	public void setPocket(){
		pocket = new int[Constants.total_shop_stuff];
		for(int i=0 ; i<Constants.total_shop_stuff;i++){
			pocket[i] = 0;
		}
	}

	////////// about get //////////
	public Role getRole(){
		return this.role;
	}
	
	public String getPlayerName(){
		return this.player_name;
	}

	public int getMoney(){
		return this.money;
	}

	public int getPlayerID(){
		return this.player_id;
	}

	public int getNumSoldier(){
		return this.num_soldier;
	}

	public int getNumOffSoldier(){
		return this.num_off_soldier;
	}

	public int getNumDefSoldier(){
		return this.num_def_soldier;
	}
    
    public void setArmy (Tower tower) throws IOException{
        commander.dispatchArmy(this, tower);
    }
    
    public int getIntelligence(){
		return this.intelligence;
	}
    public String getTreasure(){
    	String temp = "";
    	for(int i = 0; i<Constants.total_shop_stuff ; i++ ){
    		if (this.pocket[i]==1)
    			temp = temp +" "+Shop.stuff[i].getName();
    	}
    	return temp;
    }
    ///////////////////////////////
    public void buyTreasure(int num){
    	this.pocket[num] = 1;
    	
    }
}