import javax.swing.JTextArea;

public class TotalPrint{
	
	/************************** ActionFrame.java *******************************/
	public static void printAction(){
		if(ActionFrame.action_flag == 5)
		print_msg_to_textArea("[ Action ] Abandoned.\n", (Game.turn+1)%2);
		else if (ActionFrame.action_flag == 1){
			print_msg_to_textArea("[ Action ] completed.\n", (Game.turn+1)%2);
			print_msg_to_textArea("The player [ " + Game.player[(Game.turn+1)%2].getPlayerName() + " ] choose [ Construction Department ]\n", (Game.turn+1)%2);
			print_msg_to_textArea("Now their tower have [ " + Game.tower[Game.player[(Game.turn+1)%2].getCampNum()-1].getBlood() + " ]  (+ "+Math.round(ConstructionDep.ser_func[ActionFrame.ConstructionCombo.getSelectedIndex()]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate)+") blood now !\n", (Game.turn+1)%2);
		}
		else if (ActionFrame.action_flag == 2){
			print_msg_to_textArea("[ Action ] completed.\n", (Game.turn+1)%2);
			print_msg_to_textArea("The player [ " + Game.player[(Game.turn+1)%2].getPlayerName() + " ] choose [ Go To MunitionFactory ]\n", (Game.turn+1)%2);
			print_msg_to_textArea("and have [ " + Game.player[(Game.turn+1)%2].getNumSoldier() + " ] (+ "+Math.round(MunitionsFactory.add_soldier[ActionFrame.MuntionCombo.getSelectedIndex()]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate)+") soldier(s) now !\n", (Game.turn+1)%2);
		}
		else if (ActionFrame.action_flag == 3){
			print_msg_to_textArea("[ Action ] completed.\n", (Game.turn+1)%2);
			print_msg_to_textArea("The player [ " + Game.player[(Game.turn+1)%2].getPlayerName() + " ] choose [ Go To Bank ]\n", (Game.turn+1)%2);
			print_msg_to_textArea("and have [ " + Game.player[(Game.turn+1)%2].getMoney() + " ] (+ "+Math.round(Bank.give_money*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_money_rate)+") dollar(s) now !\n", (Game.turn+1)%2);
		}
		else if (ActionFrame.action_flag == 4){
			print_msg_to_textArea("[ Action ] completed.\n", (Game.turn+1)%2);
			print_msg_to_textArea("The player [ " + Game.player[(Game.turn+1)%2].getPlayerName() + " ] choose [ Go To Explore ]\n", (Game.turn+1)%2);
			if (ActionFrame.ExploreCombo.getSelectedIndex() == 0 ) {
				print_msg_to_textArea("and go expeditionary!\n", (Game.turn+1)%2);
				if (Explore.cases == 0) 
					print_msg_to_textArea("You defeat the foreign enemy and get " + Explore.amount + " soldiers.\n", (Game.turn+1)%2);
				else if (Explore.cases == 1) 
					print_msg_to_textArea("Nothing acquire ... \n", (Game.turn+1)%2);
				else if (Explore.cases == 2) 
					print_msg_to_textArea("You are beaten by the foreign enemy and lose " + Explore.amount + " soldiers.\n", (Game.turn+1)%2);
				else if (Explore.cases == 3) 
					print_msg_to_textArea("You conquer the foreign enemy and get " + Explore.amount + " soldiers.\n", (Game.turn+1)%2);
				else {
					
				}
				print_msg_to_textArea("You now have " + Game.player[(Game.turn+1)%2].getNumSoldier() + " soldiers.\n", (Game.turn+1)%2);
			}
			else if (ActionFrame.ExploreCombo.getSelectedIndex() == 1 ) {
				print_msg_to_textArea("and commit a burglary !\n", (Game.turn+1)%2);
				if (Explore.cases == 0)
					print_msg_to_textArea("You found and pick up " + Explore.amount + " dollars.\n", (Game.turn+1)%2);
				else if (Explore.cases == 1)
					print_msg_to_textArea("Nothing acquire ... \n", (Game.turn+1)%2);
				else if (Explore.cases == 2) 
					print_msg_to_textArea("You're money are stolen and lose " + Explore.amount + " dollars.\n", (Game.turn+1)%2);
				else if (Explore.cases == 3) 
					print_msg_to_textArea("You steal lots money from enemy and get " + Explore.amount + " dollars.\n", (Game.turn+1)%2);
				else {
					
				}
				print_msg_to_textArea("You now have " + Game.player[(Game.turn+1)%2].getMoney() + " dollars.\n", (Game.turn+1)%2);
			}
			else if (ActionFrame.ExploreCombo.getSelectedIndex() == 2 ) {
				print_msg_to_textArea("and a spy sneaked in !\n", (Game.turn+1)%2);
				if (Explore.cases == 0)
					print_msg_to_textArea("Your spy is getting his way! Your win rate is raised !\n", (Game.turn+1)%2);
				else if (Explore.cases == 1)
					print_msg_to_textArea("Mission failed. Your spy came back with nothing helpful !\n", (Game.turn+1)%2);
				else if (Explore.cases == 2) {
					print_msg_to_textArea("Your spy failed and got caught! \n", (Game.turn+1)%2);
					print_msg_to_textArea("You lose your spy! You now have " + Game.player[(Game.turn+1)%2].getNumSoldier() + " soldiers.\n", (Game.turn+1)%2);
				}
				else if (Explore.cases == 3)
					print_msg_to_textArea("Big success!! Your got enemy's strategy! Win rate boosts!\n", (Game.turn+1)%2);
				else {
					
				}
			}
				
		}
		
	}
	
	/************************** FightFrame.java ********************************/
	public static void printPressReady(){
		print_msg_to_textArea("Deployment completed!\n", (Game.turn+1)%2);
	}
	
	/************************** StateControl.java ******************************/
	public static void printPressStart(){
		print_msg_to_textArea("Press [ Start ] and start the game .... \n\n", (Game.turn+1)%2);
	}
	
	public static void printPressAction(){
		print_msg_to_textArea("Press [ Action ] to take action .... \n", (Game.turn+1)%2);
		print_msg_to_textArea("or press [ Shop ] to buy some treasures .... \n", (Game.turn+1)%2);
	}
	
	public static void printPressDeploy(){
		print_msg_to_textArea("Press [ Deploy ] to dispatch .... \n", (Game.turn+1)%2);
	}
	
	/************************** Game.java **************************************/
	public static void printTurn(int player_id){
		print_msg_to_textArea("******************************\n", (Game.turn+1)%2);
		print_msg_to_textArea("*** Now is player" + player_id + "'s turn ***\n", (Game.turn+1)%2);
		print_msg_to_textArea("******************************\n", (Game.turn+1)%2);
	}
	
	public static void printPressWar(){
		print_msg_to_textArea("Please press [ War!! ] to see the result ...... ", 3);
	}
	
	public static void printStatus(){
		// initialization
				int i;
				int num = 3; 
		// print player status
				print_msg_to_textArea(     "________________<Game status>________________\n", num);
				for(i=0; i<Game.player.length;i++){
					print_msg_to_textArea( "                <player name>     " + Game.player[i].getPlayerName() + "\n", num);
					print_msg_to_textArea( "                <camp name>       " + Game.player[i].getCampName() + "\n", num);
					print_msg_to_textArea( "                <money>           " + Game.player[i].getMoney() + "\n", num);
					print_msg_to_textArea( "                <num of soldier>  " + Game.player[i].getNumSoldier() + "\n", num);
					if( i != Game.player.length - 1)
						print_msg_to_textArea("\n", num);
				}
				print_msg_to_textArea(     "_____________________________________________\n", num);
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
		print_msg_to_textArea("*************** war result ***************\n", (Game.turn+1)%2);
		
		for(i=0; i<player.length; i++){
			team = player[i].getCampNum();
			print_msg_to_textArea("player"+player[i].getPlayerID() +" [ "+player[i].getPlayerName()+" ]" + "\n", 3);
			print_msg_to_textArea("original offense unit : " + player[i].getNumOffSoldier() 
							+ " original defense unit : " + player[i].getNumDefSoldier() + "\n", 3);
			if(team == 1){
				print_msg_to_textArea("wining rate : (offense) "+ a_offense_win_rate 
									+": (defense) " + a_defense_win_rate + "\n", 3);
				print_msg_to_textArea("tower remaining : " + tower_a.getBlood() + "\n", 3);
			}
			else if(team == 2){
				print_msg_to_textArea("wining rate : (offense) "+ b_offense_win_rate +": (defense) " + b_defense_win_rate + "\n", 3);
				print_msg_to_textArea("tower remaining : " + tower_b.getBlood() + "\n", 3);
			}
			print_msg_to_textArea("remaining army : " + player[i].getNumSoldier() + "\n", 3);
			print_msg_to_textArea("****************************************\n\n", 3);
		}
	}

	// print there's no tower under the [ tower_name ]
	public static void printNoWar(String tower_name){
		print_msg_to_textArea("under "+ tower_name +", no war happen\n", (Game.turn+1)%2);
	}
	
	
	
	/************************** this class use **********************************/
	// for print use function
	public static void print_msg_to_UI(String msg, JTextArea textarea){
		textarea.append(msg);
		int len = textarea.getDocument().getLength();
		textarea.setCaretPosition(len);
	}

	public static void print_msg_to_textArea(String msg, int num){
		if (num == 0)
			print_msg_to_UI(msg, MainFrame.textArea_1);
		else if (num == 1)
			print_msg_to_UI(msg, MainFrame.textArea_2);
		else if (num == 3) {
			print_msg_to_UI(msg, MainFrame.textArea_1);
			MainFrame.textArea_2.append(msg);
		}
		else {
			
		}
	}

	public static void clearTextArea(){
		MainFrame.textArea_1.setText("");
		MainFrame.textArea_2.setText("");
	}
	
	
}