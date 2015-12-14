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
		System.out.println("The bank gives $20 to "+player.getPlayerName());
		player.setMoney(player.getMoney()+getgivemoney());
		System.out.println("Now, "+player.getPlayerName()+" have $"+player.getMoney()+".");
        return true;
	}
}