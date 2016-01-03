
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
		
		/////// initialization
		int i,j;
		int one_side_player_num = Constants.player_num;
		Computer computer = new Computer();
		ActivityMenu AM = new ActivityMenu();
		Create create = new Create();
		round = 1;
		turn = 1;
		for(i=0; i<camp_num; i++)
			tower [ i ] = new Tower( i+1 );
		for(i=0; i<camp_num; i++){
			for(j=0; j<one_side_player_num; j++){
				int player_id = i*one_side_player_num + j + 1;    // unique player id
				player[ player_id - 1 ] = new Player( i+1, player_id);
			}
		}
		int term_or_UI = Integer.parseInt(args[0]);
		/////// initialization done

		
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
		}
		
		else if(term_or_UI == 1){ // for GUI usage
			MainFrame window = new MainFrame();
			// newly add welcome frame
			if(Constants.have_origin_frame_or_not){
				new OriginalFrame();
				pause();
			}
			
			
			//	new a Frame
			window.frame.setVisible(true);
			
			//  waiting user to set up
			pause();
			
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
				
				//  player 1's turn
				// action
				pause();	
				
				// Deployment
				pause();
				
				///// player 2's turn
				// action
				pause();
				
				// Deployment
				pause();
				
				
				
				// war
				pause();
				EndFrame.gameJudge();
				
				// clear
				pause();	
				
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


    ////////////////////////////////for UI usage ///////////////////////////////////////
	public static void pause(){
		blockmain = true; 
		while( blockmain ){
			try {
			    Thread.sleep(200);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}	
	}
}
