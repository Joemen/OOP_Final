public class Player{
	public Role role;
	private String player_name ;
	private int money;
	private int num_soldier;

	public Player(){
		this.setMoney(100); 			// initial money
		this.setNumSoldier(100); 		// initial soldier
		this.player_name = new String("player_no_name") ;
		role = setRole(0);
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
}