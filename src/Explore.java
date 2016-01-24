import java.util.Scanner;
import java.util.Random;

public class Explore extends Functions {
	public static int cases;
	public static int amount;
	public Explore(){

	}
	//for UI
	public static void explore_UI (Player player) {
		int num =-1;
		num = ActionFrame.ExploreCombo.getSelectedIndex();
		if( num == 0 )
			expeditionary_UI( player );
		else if( num == 1)
			steal_money_UI( player );
		else if( num == 2)
			spy_UI( player );
	}
	
	public static void expeditionary_UI (Player player) {
		Random rand = new Random();
    	int element = 10;
    	cases = -1;
    	int res = rand.nextInt( element ) ;
    	
    	if( res == 0 || res == 1 || res == 2 ){
    		amount = rand.nextInt( 35 ) + 1;
    		player.setNumSoldier( player.getNumSoldier() + amount );
    		cases = 0;
    	}
    	else if( res == 3 || res == 4)
    		cases = 1;
    	else if( res == 5 || res == 6 || res == 7 || res == 8 ){
    		amount = rand.nextInt( 35 ) + 1;
    		player.setNumSoldier( player.getNumSoldier() - amount );
    		if( player.getNumSoldier() < 0 ){
    			player.setNumSoldier( 0 );
    		}
    		cases = 2;
    	}
    	else if( res == 9){
    		amount = rand.nextInt( 35 ) + 20;
    		player.setNumSoldier( player.getNumSoldier() + amount );
    		cases = 3;
    	}
	}
	
	public static void steal_money_UI (Player player) {
		Random rand = new Random();
    	int element = 10;
    	int res = rand.nextInt( element ) ;
    	if( res == 0 || res == 1 || res == 2 ){
    		amount = rand.nextInt( 30 ) + 20 ;
    		player.setMoney( player.getMoney() + amount );
    		cases = 0;
    	}
    	else if( res == 3 || res == 4)
    		cases = 1;
    	else if( res == 5 || res == 6 || res == 7 || res == 8 ){
    		amount = rand.nextInt( 35 ) + 1;
    		player.setMoney( player.getMoney() - amount );
    		if( player.getMoney() < 0 ){
    			player.setMoney( 0 );
    		}
    		cases = 2;
    	}
    	else if( res == 9){
    		amount = rand.nextInt( 50 ) + 50;
    		player.setMoney( player.getMoney() + amount );
    		cases = 3;
    	}
	}
	
	public static void spy_UI (Player player) {
		Random rand = new Random();
    	int element = 10;
    	int res = rand.nextInt( element ) ;
    	if( res == 0 || res == 1 || res == 2 ){
    		player.setIntelligence( 1 );
    		cases = 0;
    	}
    	else if( res == 3 || res == 4)
    		cases = 1;
    	else if( res == 5 || res == 6 || res == 7 || res == 8 ){
    		amount = rand.nextInt( 10 ) + 1;
    		player.setNumSoldier( player.getNumSoldier() - amount );
    		if( player.getNumSoldier() < 0 ){
    			player.setNumSoldier( 0 );
    		}
    		cases = 2;
    	}
    	else if( res == 9){
    		player.setIntelligence( 2 );
    		cases = 3; 
    	}
	}

	//for terminal
	public boolean explore (Player player) {
		System.out.println("-----------------------------------------------------------");
    	System.out.println("|                Welcome to the < Explore >               |");
        System.out.println("-----------------------------------------------------------");
		System.out.println(player.getPlayerName()+" have $"+player.getMoney()+" and "+player.getNumSoldier()+" soldiers.");
    	
    	while( true ){
    		System.out.println("Please enter your option: ");
        	System.out.println("    (1) expeditionary --- to explore and may get or lose some of your soldiers ! ");
        	System.out.println("    (2) steal money ---  to give your enemy surprise ! ");
        	System.out.println("    (3) spy --- to have more win rate against enemy ! ");
        	System.out.println("    (0) go back to the menu. --- bye");
	        Scanner scanner = new Scanner(System.in);
	        while ( true ) {
			   	if(!scanner.hasNextInt()){
			   		System.out.println("Invalid input, please try again");
			   		scanner.nextLine(); // omit the input
			   		continue;
			   	}
			   	else{
	        		int num = scanner.nextInt();
	        		if( num < 0 || num > 3){
	        			System.out.println("Invalid input, please try again");
	        			continue;
	        		}
	        		if( num == 0){
	        			System.out.println("Goodbye!");
                		return false;
	        		}
	        		else if( num == 1 ){
	        			expeditionary( player );
	        		}
	        		else if( num == 2){
	        			steal_money( player );
	        		}
	        		else if( num == 3){
	        			spy( player );
	        		}
	        		break;
	        	}
			}
	        return true;
    	}
    }
    public static void expeditionary( Player player){
    	// 1 : 
    	Random rand = new Random();
    	int element = 10;
    	int res = rand.nextInt( element ) ;
    	
    	System.out.println("*************** expeditionary result ***************");
    	
    	if( res == 0 || res == 1 || res == 2 ){
    		int temp = rand.nextInt( 35 ) + 1;
    		System.out.println("You defeat the foreign enemy and get " + temp + " soldiers.");
    		player.setNumSoldier( player.getNumSoldier() + temp );
    		System.out.println("You now have " + player.getNumSoldier() + " soldiers.");
    	}
    	else if( res == 3 || res == 4){
    		System.out.println("Nothing acquire ... ");
    	}
    	else if( res == 5 || res == 6 || res == 7 || res == 8 ){
    		int temp = rand.nextInt( 35 ) + 1;
    		System.out.println("You are beaten by the foreign enemy and lose " + temp + " soldiers.");
    		player.setNumSoldier( player.getNumSoldier() - temp );
    		if( player.getNumSoldier() < 0 ){
    			player.setNumSoldier( 0 );
    		}
    		System.out.println("You now have " + player.getNumSoldier() + " soldiers.");
    	}
    	else if( res == 9){
    		int temp = rand.nextInt( 35 ) + 20;
    		System.out.println("You conquer the foreign enemy and get " + temp + " soldiers.");
    		player.setNumSoldier( player.getNumSoldier() + temp );
    		System.out.println("You now have " + player.getNumSoldier() + " soldiers.");
    	}

    }

    public static void steal_money(Player player){
    	// steal money 
    	// rolling dice to determine the money steal from enemy after the round end
    	Random rand = new Random();
    	int element = 10;
    	int res = rand.nextInt( element ) ;
    	System.out.println("*************** steal money result ***************");

    	if( res == 0 || res == 1 || res == 2 ){
    		int temp = rand.nextInt( 30 ) + 20 ;
    		System.out.println("You found and pick up " + temp + " dollars.");
    		player.setMoney( player.getMoney() + temp );
    		System.out.println("You now have " + player.getMoney() + " dollars.");
    	}
    	else if( res == 3 || res == 4){
    		System.out.println("Nothing acquire ... ");
    	}
    	else if( res == 5 || res == 6 || res == 7 || res == 8 ){
    		int temp = rand.nextInt( 35 ) + 1;
    		System.out.println("You're money are stolen and lose " + temp + " dollars.");
    		player.setMoney( player.getMoney() - temp );
    		if( player.getMoney() < 0 ){
    			player.setMoney( 0 );
    		}
    		System.out.println("You now have " + player.getMoney() + " dollars.");
    	}
    	else if( res == 9){
    		int temp = rand.nextInt( 50 ) + 50;
    		System.out.println("You steal lots money from enemy and get " + temp + " dollars.");
    		player.setMoney( player.getMoney() + temp );
    		System.out.println("You now have " + player.getMoney() + " dollars.");
    	}

    }

    public static void spy(Player player){
    	Random rand = new Random();
    	int element = 10;
    	int res = rand.nextInt( element ) ;
    	System.out.println("******************* spy result *******************");
    	if( res == 0 || res == 1 || res == 2 ){
    		System.out.println("Your spy is getting his way! Your win rate is raised !");
    		player.setIntelligence( 1 );
    	}
    	else if( res == 3 || res == 4){
    		System.out.println("Mission failed. Your spy came back with nothing helpful !");
    	}
    	else if( res == 5 || res == 6 || res == 7 || res == 8 ){
    		int temp = rand.nextInt( 10 ) + 1;
    		System.out.println("Your spy failed and got caught! ");
    		player.setNumSoldier( player.getNumSoldier() - temp );
    		if( player.getNumSoldier() < 0 ){
    			player.setNumSoldier( 0 );
    		}
    		System.out.println("You lose your spy! You now have " + player.getNumSoldier() + " soldiers.");
    	}
    	else if( res == 9){
    		System.out.println("Big success!! Your got enemy's strategy! Win rate boosts!");
    		player.setIntelligence( 2 );
    	}

    }

}