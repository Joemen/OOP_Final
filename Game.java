
import java.awt.Color;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Game{
	static final int camp_num = 2;
	static final int total_player_num = Constants.player_num * camp_num;
	public static Player[] player = new Player[ total_player_num ];
	public static Tower[] tower = new Tower[ camp_num ];
    public static Shop shop = new Shop();
    public static TotalPrint totalprint = new TotalPrint();
	public static int round;
	public static int turn ;
	public static boolean blockmain;
	
	public static void main(String[] args) throws IOException{
		// initialization
		int i,j;
		int one_side_player_num = Constants.player_num;

		Computer computer = new Computer();
		ActivityMenu AM = new ActivityMenu();
		Create create = new Create();
		round = 1;
		turn = 1;

		for(i=0; i<camp_num; i++){
			tower [ i ] = new Tower( i+1 );
		}

		for(i=0; i<camp_num; i++){
			for(j=0; j<one_side_player_num; j++){
				int player_id = i*one_side_player_num + j + 1;    // unique player id
				player[ player_id - 1 ] = new Player( i+1, player_id);
			}
		}
		// for UI use
		// public static Player player1 = new Player(1, 1);
		// player1 = player[0];

		int term_or_UI = Integer.parseInt(args[0]);

		if( term_or_UI == 0){ // for terminal usage
			
			
			for(i=0; i<camp_num; i++){
				for(j=0; j<one_side_player_num; j++){
					int player_id = i*one_side_player_num + j + 1;    // unique player id
					create.set_name_role(player[ player_id - 1]);
				}
			}

			System.out.println( "################## Two Camp Game Start!! ##################");
			print_status( player );

			while(round<3){
				System.out.println( "###################### Round <"+round+"> ######################");

				// initialize the soldier number
				for(i=0; i<camp_num; i++){
					tower[i].setDefSoldier(0); 
					tower[i].setOffSoldier(0);
				}

				for(i=0; i<player.length; i++){
					player[i].setNumDefSoldier(0);
					player[i].setNumOffSoldier(0);
				}

				take_action(AM, player, tower); 

				computer.fight(tower[0], tower[1], player);  // assume 2 camp

				System.out.println( "#########################################################");
				print_status( player );

				round++;
			}

			
		}else if(term_or_UI == 1){ // for GUI usage
			MainFrame window = new MainFrame();
			//	new a Frame
			window.frame.setVisible(true);
			blockmain = true;
			while( blockmain ){
				// do nothing
				try {
				    Thread.sleep(200);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}

				 //System.out.println("waiting game start");
			}
			

			// true game loop 
			while(round <= Constants.total_round){
				
				// initialize the soldier number
				for(i=0; i<camp_num; i++){
					tower[i].setDefSoldier(0); 
					tower[i].setOffSoldier(0);
				}

				for(i=0; i<player.length; i++){
					player[i].setNumDefSoldier(0);
					player[i].setNumOffSoldier(0);
				}
				
				// set player1 action
				blockmain = true;
				///// player 1
				// action
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				// fight
				blockmain = true;
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				
				///// player 2
				// action
				blockmain = true;
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				// fight
				blockmain = true;
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				turn++;
				
				// war
				blockmain = true; 
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				
				// store round information back to history.txt
				blockmain = true; 
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				
				
				
				
			}
		}
	}

	
	
	
	
	
	
	
	
	//////////////////////////////// for terminal usage ///////////////////////////////////////

	// ask player to set offensive and defensive soldier and then count the result of the war. 
	public static void take_action ( ActivityMenu AM, Player[] player, Tower[] tower ) throws IOException  {
		int i;
		for(i=0; i<player.length; i++){
			AM.Action(player[ i ], tower[player[i].getCampNum() - 1] );
			System.out.println( "                                              ");
			player[ i ].setArmy(tower[player[i].getCampNum() - 1]);
		}    
	}

	// in every round, print the status of every player. 
	public static void print_status( Player[] player ){
		// initialization
		int i;

		// print player status
		System.out.println( "______________________<Game status>______________________");
		for(i=0; i<player.length;i++){
			System.out.println( "<player name>     " + player[i].getPlayerName() );
			System.out.println( "<camp name>       " + player[i].getCampName() );
			System.out.println( "<money>           " + player[i].getMoney() );
			System.out.println( "<num of soldier>  " + player[i].getNumSoldier() );
			System.out.println();
		}
	}

}
/*
	//////////////////////////////// for UI usage ///////////////////////////////////////

	public static void print_status_to_UI( Player[] player, JTextArea textarea){
		// initialization
		int i, len;

		// print player status
		textarea.append(     "________________<Game status>________________\n");
		for(i=0; i<player.length;i++){
			textarea.append( "                <player name>     " + player[i].getPlayerName() + "\n");
			textarea.append( "                <camp name>       " + player[i].getCampName() + "\n");
			textarea.append( "                <money>           " + player[i].getMoney() + "\n");
			textarea.append( "                <num of soldier>  " + player[i].getNumSoldier() + "\n");
			if( i != player.length - 1)
				textarea.append("\n");
		}
		textarea.append(     "_____________________________________________\n");

		len = textarea.getDocument().getLength();
		textarea.setCaretPosition(len);
	}

	public static void print_msg_to_UI(String msg, JTextArea textarea){
		textarea.append(msg);
		int len = textarea.getDocument().getLength();
		textarea.setCaretPosition(len);
	}

	public static void print_msg_to_textArea(String msg){
		print_msg_to_UI(msg, MainFrame.textArea);
	}

}*/