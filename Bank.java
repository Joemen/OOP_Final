public class Bank extends Functions{
	private int give_money;

	public Bank(){
		this.setgivemoney(20);
	}
	
	public void setgivemoney(int money){
		this.give_money = money;
	}
	
	public int getgivemoney(){
		return this.give_money;
	}
	public  boolean bankgivesmoney(Player player){
		System.out.println("-----------------------------------------------------------");
        System.out.println("|                  Welcome to the <Bank>                  |");
        System.out.println("-----------------------------------------------------------");
		System.out.println(player.getPlayerName()+" have $"+player.getMoney()+".");
		System.out.println("The bank gives $"+Math.round(this.give_money*player.getRole().getProperty().is_add_money_rate)+" to "+player.getPlayerName());
		player.setMoney((int)(player.getMoney()+Math.round(this.give_money*player.getRole().getProperty().is_add_money_rate)));
		System.out.println("Now, "+player.getPlayerName()+" have $"+player.getMoney()+".");
        return true;
	}
}