import java.util.Scanner;
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
        	System.out.println("    (1) expeditionary --- to explore and may get something good ! ");
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
    	System.out.println("expeditionary");
    }

    public static void steal_money(Player player){
    	// steal money 
    	// rolling dice to determine the money steal from enemy after the round end
    	System.out.println("steal_money");
    }

    public static void spy(Player player){
    	System.out.println("spy");

    }

}