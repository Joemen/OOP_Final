import javax.swing.JTextArea;

public class TotalPrint{
	
	/************************** StateControl.java ******************************/
	public static void printPressStart(){
		print_msg_to_textArea("Press [ Start ] and start the game .... \n");
	}
	
	/************************** Game.java **************************************/
	public static void printTurn(int player_id){
		print_msg_to_textArea("******************************\n");
		print_msg_to_textArea("*** Now is player" + player_id + "'s turn ***\n");
		print_msg_to_textArea("******************************\n");
	}
	
	public static void printPressWar(){
		print_msg_to_textArea("Please press [ War!! ] to see the result ...... ");
	}
	
	/************************** Computer.java **********************************/
	public static void printWarStart(){
		// to be done later
	}
	
	public static void printWarResult(Player[] player, float[] win_rate, Tower tower_a, Tower tower_b){
		int team, i;
		float a_offense_win_rate = win_rate[0];
		float a_defense_win_rate = win_rate[1];
		float b_offense_win_rate = win_rate[2];
		float b_defense_win_rate = win_rate[3];
		print_msg_to_textArea("*************** war result ***************\n");
		
		for(i=0; i<player.length; i++){
			team = player[i].getCampNum();
			print_msg_to_textArea("player"+player[i].getPlayerID() +" [ "+player[i].getPlayerName()+" ]" + "\n");
			print_msg_to_textArea("original offense unit : " + player[i].getNumOffSoldier() 
							+ " original defense unit : " + player[i].getNumDefSoldier() + "\n");
			if(team == 1){
				print_msg_to_textArea("wining rate : (offense) "+ a_offense_win_rate 
									+": (defense) " + a_defense_win_rate + "\n");
				print_msg_to_textArea("tower remaining : " + tower_a.getBlood() + "\n");
			}
			else if(team == 2){
				print_msg_to_textArea("wining rate : (offense) "+ b_offense_win_rate +": (defense) " + b_defense_win_rate + "\n");
				print_msg_to_textArea("tower remaining : " + tower_b.getBlood() + "\n");
			}
			Game.print_msg_to_textArea("remaining army : " + player[i].getNumSoldier() + "\n");
			Game.print_msg_to_textArea("****************************************\n\n");
		}
	}

	// print there's no tower under the [ tower_name ]
	public static void printNoWar(String tower_name){
		print_msg_to_textArea("under "+ tower_name +", no war happen\n");
	}
	
	
	
	/************************** this class use **********************************/
	// for print use function
	public static void print_msg_to_UI(String msg, JTextArea textarea){
		textarea.append(msg);
		int len = textarea.getDocument().getLength();
		textarea.setCaretPosition(len);
	}

	public static void print_msg_to_textArea(String msg){
		print_msg_to_UI(msg, MainFrame.textArea);
	}

	public static void clearTextArea(){
		MainFrame.textArea.setText("");
	}
}