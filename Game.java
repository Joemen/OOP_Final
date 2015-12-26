
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
			TotalPrint.clearTextArea();
			MainFrame.textArea.append("############ Two Camp Game Start!! ############\n\n");
			
			

			// true game loop 
			while(round <= Constants.total_round){
				print_status_to_UI( player, MainFrame.textArea);
				
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
				print_msg_to_textArea("\n############ round " + round + " ############\n\n");
				MainFrame.actionbutton.setEnabled(true);
				MainFrame.shopbutton.setEnabled(true);
				MainFrame.btnClear.setEnabled(false);
				TotalPrint.printTurn(1);
				print_msg_to_textArea("\nPlease set [ Action ], player1\n");
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				MainFrame.actionbutton.setEnabled(false);
				// fight
				blockmain = true;
				MainFrame.btnFight.setEnabled(true);
				print_msg_to_textArea("\nNow please set [ Fight ], player1\n\n");
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				MainFrame.btnFight.setEnabled(false);
				///// player 2
				// action
				turn ++;
				blockmain = true;
				MainFrame.actionbutton2.setEnabled(true);
				TotalPrint.printTurn(2);
				print_msg_to_textArea("\nPlease set [ Action ], player2\n");
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				MainFrame.actionbutton2.setEnabled(false);
				// fight
				blockmain = true;
				MainFrame.btnFight2.setEnabled(true);
				print_msg_to_textArea("\nNow please set [ Fight ], player2\n");
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				MainFrame.btnFight2.setEnabled(false);
				turn++;
				
				// war
				TotalPrint.printPressWar();
				blockmain = true; 
				MainFrame.btnWar.setEnabled(true);
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				MainFrame.btnWar.setEnabled(false);
				MainFrame.shopbutton.setEnabled(false);
				
				// store round information back to history.txt
				MainFrame.btnClear.setEnabled(true);
				print_msg_to_textArea("\n\nPlease Check the result. Press [ clear ] to go to the next round... \n");
				blockmain = true; 
				while( blockmain ){
					// do nothing
					try {
					    Thread.sleep(200);                 //1000 milliseconds is one second.
					} catch(InterruptedException ex) {
					    Thread.currentThread().interrupt();
					}
				}
				
				try {
					FileWriter fileWritter = new FileWriter("history.txt",true);
				    String myString1 = MainFrame.textArea.getText();
				    if(round == 1){
				    	PrintWriter writer = new PrintWriter("history.txt");
				    	writer.print("");
				    	writer.close();
				    	fileWritter.append(myString1 + "\n");
				    }else{
				    	fileWritter.append(myString1 + "\n");
				    }    
				    fileWritter.close();
				} catch (IOException ioe) {
				    ioe.printStackTrace();
				}
				TotalPrint.clearTextArea();
				
				round++;
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

}