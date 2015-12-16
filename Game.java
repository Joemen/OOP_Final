import java.io.*;
import javax.swing.JFrame;

public class Game{
	static final int camp_num = 2;
	static final int total_player_num = Constants.player_num * camp_num;
	public static Player[] player = new Player[ total_player_num ];

	public static void main(String[] args) throws IOException{
		// initializstion
		int i,j;
		int round=1;
		int one_side_player_num = Constants.player_num;

		Tower[] tower = new Tower[ camp_num ];
		Computer computer = new Computer();
		ActivityMenu AM = new ActivityMenu();
		//	new a Frame
		MainFrame window = new MainFrame();
		window.frame.setVisible(true);




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