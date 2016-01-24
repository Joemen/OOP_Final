

// for Counting War Result

public class Computer{
	
	// * when taking spy action
	public static float getITeffect (Player player){
		float weighted_rate = 0.0f;
		if (player.getIntelligence()==0)
			weighted_rate = 1;
		else if (player.getIntelligence()==1)
			weighted_rate = 1.05f;
		else if (player.getIntelligence()==2)
			weighted_rate = 1.1f;
		else{
			System.out.println("in getITeffect function, getIntelligence number error");
			System.exit(1);
		}
		return weighted_rate;
	}
	
	// * initializing the soldier number
	public static void resetWarData(){
		
		for(int i=0; i<Game.camp_num; i++){
			Game.tower[i].setDefSoldier(0); 
			Game.tower[i].setOffSoldier(0);
		}

		for(int i=0; i<Game.player.length; i++){
			Game.player[i].setNumDefSoldier(0);
			Game.player[i].setNumOffSoldier(0);
		}
	}
	
	public static void fight_UI (Tower tower_a, Tower tower_b, Player[] player){
		// property ratio between two team
		int property_ratio_a = 1;
		int property_ratio_b = 1;
		boolean[] war_flag = new boolean[2];

		// whether there's war to happen under tower_a
		if(tower_a.getDefSoldier() == 0 && tower_b.getOffSoldier() == 0){
			war_flag[0] = false;
		}else{
			war_flag[0] = true;
		}
		
		float win_rate_of_A_tower = countWinRate(tower_b.getOffSoldier(), tower_a.getDefSoldier(), property_ratio_b );
		
		// whether there's war to happen under tower_a
		if(tower_b.getDefSoldier() == 0 && tower_a.getOffSoldier() == 0){
			war_flag[1] = false;
		}else{
			war_flag[1] = true;
		}
		
		float win_rate_of_B_tower = countWinRate(tower_a.getOffSoldier(), tower_b.getDefSoldier(), property_ratio_a );
		
		float a_defense_win_rate, b_offense_win_rate, a_offense_win_rate, b_defense_win_rate;
		
		int k;
		for(k=0; k<player.length; k++){
			int cam = player[k].getCampNum();
			if(cam == 1){ // camp A
				if(win_rate_of_B_tower != 100)
					win_rate_of_B_tower = win_rate_of_B_tower*getITeffect(player[k]);
			}
			else if(cam == 2){//camp B
				if(win_rate_of_A_tower != 100)
					win_rate_of_A_tower = win_rate_of_A_tower*getITeffect(player[k]);
			}
			else {
				
			}
		}

		if( war_flag[0] == true){
			a_defense_win_rate = (100 - win_rate_of_A_tower)/100;
			b_offense_win_rate = (win_rate_of_A_tower)/100;
		}
		else{ // no war happen
			a_defense_win_rate = 1;
			b_offense_win_rate = 1;
		}

		if( war_flag[1] == true){
			a_offense_win_rate = (win_rate_of_B_tower)/100;
			b_defense_win_rate = (100 - win_rate_of_B_tower)/100;
		}
		else{ // no war happen
			a_offense_win_rate = 1;
			b_defense_win_rate = 1;
		}

		// count and set remaining blood of the tower
		setTowerBlood( a_defense_win_rate, tower_a);
		setTowerBlood( b_defense_win_rate, tower_b);

		
		int i;
		
		if(war_flag[0] == false){
			// Game.print_msg_to_textArea("under tower A, no war happen\n");
			TotalPrint.printNoWar("tower A");	
		}else{
			//TotalPrint.printWarStart();
		}
		if(war_flag[1] == false){
			// Game.print_msg_to_textArea("under tower B, no war happen\n");
			TotalPrint.printNoWar("tower B");
		}else{
			//TotalPrint.printWarStart();
		}
		
		// for each player, count their remaining soldier
		for(i=0; i<player.length; i++){
			int team = player[i].getCampNum();
			if(team == 1){ // camp A
				float a = player[i].getNumOffSoldier() * a_offense_win_rate;
				float b = player[i].getNumDefSoldier() * a_defense_win_rate;
				float c = player[i].getNumSoldier() - player[i].getNumOffSoldier() - player[i].getNumDefSoldier();
				// total remaining soldier = remaining defense + remaining offense + stayHome soldier
				player[i].setNumSoldier( (int)Math.round(a+b+c) );
			}
			else if(team == 2){
				float a = (player[i].getNumOffSoldier() * b_offense_win_rate);
				float b = (player[i].getNumDefSoldier() * b_defense_win_rate);
				float c = player[i].getNumSoldier() - player[i].getNumOffSoldier() - player[i].getNumDefSoldier();
				// total remaining soldier = remaining defense + remaining offense + stayHome soldier
				player[i].setNumSoldier( (int)Math.round(a+b+c) );
			}
			else {
				
			}
		}
			
			float[] win_rate = new float[4];
			win_rate[0] = a_offense_win_rate;
			win_rate[1] = a_defense_win_rate;
			win_rate[2] = b_offense_win_rate;
			win_rate[3] = b_defense_win_rate;
			TotalPrint.printWarResult(player, win_rate, tower_a, tower_b);		
	}
	
	
	public void fight (Tower tower_a, Tower tower_b, Player[] player){
		int randdeath;
        System.out.println("--------------------------------");
		System.out.println("| 2 troops are about to fight! |");
        System.out.println("--------------------------------");
		System.out.println("Tower_A blood: "+tower_a.getBlood()+"============Tower_B blood: "+tower_b.getBlood());
		System.out.println("Tower_A offense soldier: "+tower_a.getOffSoldier()+"  "+"Tower_B offense soldier:"+tower_b.getOffSoldier());
		System.out.println("Tower_A defense soldier: "+tower_a.getDefSoldier()+"  "+"Tower_B defense soldier:"+tower_b.getDefSoldier());
		System.out.println();
		//================
		
		// property ratio between two team
		int property_ratio_a = 1;
		int property_ratio_b = 1;
		boolean[] war_flag = new boolean[2];
		
		// count the offensive troop's win rate
		// B offense, A defense towerA
		if(tower_a.getDefSoldier() == 0 && tower_b.getOffSoldier() == 0){
			war_flag[0] = false;
		}else{
			war_flag[0] = true;
		}
		
		// A offense, B defense towerB
		if(tower_b.getDefSoldier() == 0 && tower_a.getOffSoldier() == 0){
			war_flag[1] = false;
		}else{
			war_flag[1] = true;
		}
		
		float win_rate_of_A_tower = countWinRate(tower_b.getOffSoldier(), tower_a.getDefSoldier(), property_ratio_b );
		float win_rate_of_B_tower = countWinRate(tower_a.getOffSoldier(), tower_b.getDefSoldier(), property_ratio_a );
		float a_defense_win_rate, b_offense_win_rate, a_offense_win_rate, b_defense_win_rate;

		int k;
		for(k=0; k<player.length; k++){
			int cam = player[k].getCampNum();
			if(cam == 1){ // camp A
				if(win_rate_of_A_tower != 100)
					win_rate_of_A_tower = win_rate_of_A_tower*getITeffect(player[k]);
			}
			else if(cam == 2){//camp B
				if(win_rate_of_B_tower != 100)
					win_rate_of_B_tower = win_rate_of_B_tower*getITeffect(player[k]);
			}
			else {
				
			}
		}

		if( war_flag[0] == true){
			a_defense_win_rate = (100 - win_rate_of_A_tower)/100;
			b_offense_win_rate = (win_rate_of_A_tower)/100;
		}
		else{ // no war happen
			a_defense_win_rate = 1;
			b_offense_win_rate = 1;
		}

		if( war_flag[1] == true){
			a_offense_win_rate = (win_rate_of_B_tower)/100;
			b_defense_win_rate = (100 - win_rate_of_B_tower)/100;
		}
		else{ // no war happen
			a_offense_win_rate = 1;
			b_defense_win_rate = 1;
		}

		// count and set remaining blood of the tower
		setTowerBlood( a_defense_win_rate, tower_a);
		setTowerBlood( b_defense_win_rate, tower_b);

		// for testing usage print
		// System.out.println("the win rate under A tower of B is  " + b_offense_win_rate);
		// System.out.println("the win rate under B tower of A is  " + a_offense_win_rate);

		// for each player, count their remaining soldier
		int i;
		for(i=0; i<player.length; i++){
			int team = player[i].getCampNum();
			if(team == 1){ // camp A
				float a = player[i].getNumOffSoldier() * a_offense_win_rate;
				float b = player[i].getNumDefSoldier() * a_defense_win_rate;
				float c = player[i].getNumSoldier() - player[i].getNumOffSoldier() - player[i].getNumDefSoldier();
				// total remaining soldier = remaining defense + remaining offense + stayHome soldier
				player[i].setNumSoldier( (int)Math.round(a+b+c) );
			}
			else if(team == 2){
				float a = (player[i].getNumOffSoldier() * b_offense_win_rate);
				float b = (player[i].getNumDefSoldier() * b_defense_win_rate);
				float c = player[i].getNumSoldier() - player[i].getNumOffSoldier() - player[i].getNumDefSoldier();
				// total remaining soldier = remaining defense + remaining offense + stayHome soldier
				player[i].setNumSoldier( (int)Math.round(a+b+c) );
			}
			else{
				System.out.println("team number error");
			}
			System.out.println("*********** war result of player "+player[i].getPlayerID()+" "+player[i].getPlayerName()+" *********");
			System.out.println("original army : player[i].getNumSoldier()");
			System.out.println("original offense unit : " + player[i].getNumOffSoldier() 
							+ " original defense unit  : " + player[i].getNumDefSoldier());
			if(team == 1){
				System.out.println("wining rate : (offense) "+ a_offense_win_rate +": (defense) " + a_defense_win_rate);
				System.out.println("tower remaining : " + tower_a.getBlood());
			}
			else if(team == 2){
				System.out.println("wining rate : (offense) "+ b_offense_win_rate +": (defense) " + b_defense_win_rate);
				System.out.println("tower remaining : " + tower_b.getBlood());
			}

			System.out.println("remaining army : " + player[i].getNumSoldier());
			System.out.println("******************************************************\n");
			
		}
		

	}
	// function for win rate :
	//  step 1 : count ration : off / (def * advantage_of_def) * property_ratio
	//  step 2 : if the ratio is too big or too small (4 or 1/4) the win rate will be 100% and 0%
	// 	step 3 : normalize with factor and add some random(-10%~10%)
	// 	
	// 	property ratio is : (offensive property / defensive property)
	// 	defense advantage ratio : defense have some advantage over offense
	public static float countWinRate(int off_soldier, int def_soldier, int property_ratio ){
		float advantage_of_def = Constants.advantage_of_def;
		float rand = (float) ((Math.random() * 20) - 10);
		float win_rate, ratio ;
		
		if( def_soldier == 0){ // to avoid divide by 0
			ratio = 0;
		}else{
			ratio = (float)off_soldier / (def_soldier*advantage_of_def) * property_ratio;
		}
		
		if( def_soldier == 0){ // to avoid divide by 0
			win_rate = 100;
		}else if(ratio > 4)
			win_rate = 100;
		else if( ratio < 0.25)
			win_rate = 0;
		else if( ratio >= 2 && ratio <=4){ // to be in 75% to 90%
			win_rate = (ratio - 2 )*7.5f + 75 + rand;
		}
		else if( ratio >= 1 && ratio < 2){ // to be in 50% to 75%
			win_rate = (ratio - 1 )*12.5f + 50 + rand;
		}
		else if( ratio < 1 && ratio >= 0.5 ){ // to be in 25% to 50%
			win_rate = (ratio - 0.5f )*50 + 25 + rand;
		}
		else if( ratio <= 0.5 && ratio >= 0.25){ // to be in 10% to 25%
			win_rate = (ratio - 0.25f )*60 + 10 + rand;
		}
		else{
			win_rate = 0;
			System.out.println("error win rate");
		}
		System.out.println(win_rate);
		return win_rate; // win_rate for offensive troop
	}

	// function for counting and setting tower blood
	// rule (temporary): 
	//  if def win rate > 75 % ==> 0 loss
	//  if def win rate < 25 % ==> 20 blood loss
	//  else ( def win rate * (-40) ) + 30
	public static void setTowerBlood(float def_win_rate, Tower tower){
		
		int damage_upper_bound = Constants.damage_upper_bound;
		int tower_damage;
		if( def_win_rate > 0.75f){
			// nothing to do because no blood loss
			tower_damage = 0;
		}
		else if( def_win_rate < 0.25f ){
			tower_damage = damage_upper_bound;
			tower.setBlood( tower.getBlood() - tower_damage );
			if(tower.getBlood()<0)
				tower.setBlood(0);
		}
		else{
			tower_damage = ((int)Math.round ( (def_win_rate-0.25) * (-2) * damage_upper_bound ) + damage_upper_bound) ;
			tower.setBlood( tower.getBlood() - tower_damage );
			
			if(tower.getBlood()<0)
				tower.setBlood(0);
		}
		tower.setBloodLose(tower_damage);
	}

}
