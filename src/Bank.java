public class Bank extends Functions{
	public static int give_money;

	public Bank(){
		setgivemoney(Constants.bank_money);
	}
	
	public static void setgivemoney(int money){
		give_money = money;
	}
	
	public static int getgivemoney(){
		return give_money;
	}
	
	public static void sendMoney_UI (Player player){
		int money = (int)Math.round(Bank.give_money*player.getRole().getProperty().is_add_money_rate);
		player.setMoney((int)(player.getMoney()+Math.round(Bank.give_money*player.getRole().getProperty().is_add_money_rate)));
		new BankAnimation(money);
	}
	
	public  boolean bankgivesmoney(Player player){
		System.out.println("-----------------------------------------------------------");
        System.out.println("|                  Welcome to the <Bank>                  |");
        System.out.println("-----------------------------------------------------------");
		System.out.println(player.getPlayerName()+" have $"+player.getMoney()+".");
		System.out.println("The bank gives $"+Math.round(give_money*player.getRole().getProperty().is_add_money_rate)+" to "+player.getPlayerName());
		player.setMoney((int)(player.getMoney()+Math.round(give_money*player.getRole().getProperty().is_add_money_rate)));
		System.out.println("Now, "+player.getPlayerName()+" have $"+player.getMoney()+".");
        return true;
	}
}