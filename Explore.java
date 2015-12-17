import java.util.Scanner;
import java.util.Random;

public class Explore extends Functions {
	public Explore(){

	}

	public boolean explore (Player player) {
		System.out.println("-----------------------------------------------------------");
    	System.out.println("|                Welcome to the < Explore >               |");
        System.out.println("-----------------------------------------------------------");
		System.out.println(player.getPlayerName()+" have $"+player.getMoney()+" and "+player.getNumSoldier()+" soldiers.");
    	
    	while( true ){
    		System.out.println("Please enter your option: ");
        	System.out.println("    (1) expeditionary --- to explore and may get soldier ! ");
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
    		System.out.println("You now have " + player.getMoney() + " soldiers.");
    	}

    }

    public static void spy(Player player){
    	System.out.println("******************* spy result *******************");

    }

}