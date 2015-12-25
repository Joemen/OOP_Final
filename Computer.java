public class Computer{
	private static int a_off_death;
	private static int b_off_death;
	private static int a_def_death;
	private static int b_def_death;
	private static int a_loss_blood;
	private static int b_loss_blood;
	private static float weighted_rate;
	
	
	public static float getITeffect (Player player){
		if (player.getIntelligence()==0)
			weighted_rate = 1;
		else if (player.getIntelligence()==1)
			weighted_rate = 1.04f;
		else if (player.getIntelligence()==2)
			weighted_rate = 1.08f;
		return weighted_rate;
	}
	/*
	public Computer(){
		this.seta_off_death(0);
		this.setb_off_death(0);
		this.seta_def_death(0);
		this.setb_def_death(0);
		this.seta_loss_blood(0);
		this.setb_loss_blood(0);
	}

	public void seta_off_death(int off_death){
		this.a_off_death = off_death;
	}

	public void setb_off_death(int off_death){
		this.b_off_death = off_death;
	}

	public void seta_def_death(int def_death){
		this.a_def_death = def_death;
	}

	public void setb_def_death(int def_death){
		this.b_def_death = def_death;
	}
	
	public void seta_loss_blood(int loss_blood){
		this.a_loss_blood = loss_blood;
	}
	
	public void setb_loss_blood(int loss_blood){
		this.b_loss_blood = loss_blood;
	}

	public int geta_off_death(){
		return this.a_off_death;
	}

	public int getb_off_death(){
		return this.b_off_death;
	}

	public int geta_def_death(){
		return this.a_def_death;
	}

	public int getb_def_death(){
		return this.b_def_death;
	}
	
	public int geta_loss_blood(){
		return this.a_loss_blood;
	}
	
	public int getb_loss_blood(){
		return this.b_loss_blood;
	}
	*/
	public static void fight_UI (Tower tower_a, Tower tower_b, Player[] player){
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
				
				float win_rate_of_A_tower = countWinRate(tower_b.getOffSoldier(), tower_a.getDefSoldier(), property_ratio_b );
				
				// A offense, B defense towerB
				if(tower_b.getDefSoldier() == 0 && tower_a.getOffSoldier() == 0){
					war_flag[1] = false;
				}else{
					war_flag[1] = true;
				}
				
				float win_rate_of_B_tower = countWinRate(tower_a.getOffSoldier(), tower_b.getDefSoldier(), property_ratio_a );
				float a_defense_win_rate, b_offense_win_rate, a_offense_win_rate, b_defense_win_rate;
				if( war_flag[0] == true){
					a_defense_win_rate = (100 - win_rate_of_A_tower)/100;
					b_offense_win_rate = (win_rate_of_A_tower)/100;
				}
				else{ // no war happen
					a_defense_win_rate = 100;
					b_offense_win_rate = 100;
				}

				if( war_flag[1] == true){
					a_offense_win_rate = (win_rate_of_B_tower)/100;
					b_defense_win_rate = (100 - win_rate_of_B_tower)/100;
				}
				else{ // no war happen
					a_offense_win_rate = 100;
					b_defense_win_rate = 100;
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
					else {
						
					}
					if(war_flag[0] == false){
						Game.print_msg_to_textArea("under tower A, now war happen\n");
					}
					if(war_flag[1] == false){
						Game.print_msg_to_textArea("under tower B, now war happen\n");
					}
					
					
					Game.print_msg_to_textArea("*********** war result of player "+player[i].getPlayerID()
											+"    "+player[i].getPlayerName()+" *********" + "\n");
					Game.print_msg_to_textArea("original off : " + player[i].getNumOffSoldier() 
										+ " original def : " + player[i].getNumDefSoldier() + "\n");
					if(team == 1){
						Game.print_msg_to_textArea("wining rate : (offense) "+ a_offense_win_rate 
											+": (defense) " + a_defense_win_rate + "\n");
						Game.print_msg_to_textArea("tower remaining : " + tower_a.getBlood() + "\n");
					}
					else if(team == 2){
						Game.print_msg_to_textArea("wining rate : (offense) "+ b_offense_win_rate +": (defense) " + b_defense_win_rate + "\n");
						Game.print_msg_to_textArea("tower remaining : " + tower_b.getBlood() + "\n");
					}

					Game.print_msg_to_textArea("remaining army : " + player[i].getNumSoldier() + "\n");
					Game.print_msg_to_textArea("******************************************************\n\n");
				}
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
		if( war_flag[0] == true){
			a_defense_win_rate = (100 - win_rate_of_A_tower)/100;
			b_offense_win_rate = (win_rate_of_A_tower)/100;
		}
		else{ // no war happen
			a_defense_win_rate = 100;
			b_offense_win_rate = 100;
		}

		if( war_flag[1] == true){
			a_offense_win_rate = (win_rate_of_B_tower)/100;
			b_defense_win_rate = (100 - win_rate_of_B_tower)/100;
		}
		else{ // no war happen
			a_offense_win_rate = 100;
			b_defense_win_rate = 100;
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
			System.out.println("original off : " + player[i].getNumOffSoldier() + " original def : " + player[i].getNumDefSoldier());
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
		
		// debug print
		System.out.println("ratio = " + ratio);
		
		if( def_soldier == 0){ // to avoid divide by 0
			win_rate = 0;
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
		return win_rate; // win_rate for offensive troop
	}

	// function for counting and setting tower blood
	// rule (temporary): 
	//  if def win rate > 75 % ==> 0 loss
	//  if def win rate < 25 % ==> 20 blood loss
	//  else ( def win rate * (-40) ) + 30
	public static void setTowerBlood(float def_win_rate, Tower tower){
		

		if( def_win_rate > 0.75f){
			// nothing to do because no blood loss
		}
		else if( def_win_rate < 0.25f ){
			tower.setBlood( tower.getBlood() - 20 );
		}
		else{
			tower.setBlood( tower.getBlood() - ((int)Math.round(def_win_rate * (-40)) + 30) );
		}
	}

		/*
		//Tower_A
		if(tower_b.getOffSoldier()>=tower_a.getDefSoldier()){
			randdeath=tower_a.getDefSoldier()/2;
			seta_loss_blood((int)(Math.random()*((tower_b.getOffSoldier()-tower_a.getDefSoldier())/2)+10));
		}
		else{
			randdeath=tower_b.getOffSoldier()/2;
			seta_loss_blood((int)(Math.random()*15));
		}
		seta_def_death((int)(Math.random()*randdeath));
		setb_off_death((int)(Math.random()*randdeath));		
		//Tower_B
		if(tower_a.getOffSoldier()>=tower_b.getDefSoldier()){
			randdeath=tower_b.getDefSoldier()/2;
			setb_loss_blood((int)(Math.random()*((tower_a.getOffSoldier()-tower_b.getDefSoldier())/2)+10));
		}
		else{
			randdeath=tower_a.getOffSoldier()/2;
			setb_loss_blood((int)(Math.random()*15));
		}
		setb_def_death((int)(Math.random()*randdeath));
		seta_off_death((int)(Math.random()*randdeath));	
		//================
		tower_a.setBlood(tower_a.getBlood()-this.geta_loss_blood());
		tower_b.setBlood(tower_b.getBlood()-this.getb_loss_blood());
		tower_a.setOffSoldier(tower_a.getOffSoldier()-this.geta_off_death());
		tower_b.setOffSoldier(tower_b.getOffSoldier()-this.getb_off_death());
		tower_a.setDefSoldier(tower_a.getDefSoldier()-this.geta_def_death());
		tower_b.setDefSoldier(tower_b.getDefSoldier()-this.getb_def_death());
        player_a.setNumSoldier(tower_a.getOffSoldier()+tower_a.getDefSoldier());
        player_b.setNumSoldier(tower_b.getOffSoldier()+tower_b.getDefSoldier());
		System.out.println("Fight ends.");
		System.out.println("Tower_A blood: "+tower_a.getBlood()+"============Tower_A blood: "+tower_b.getBlood());
		System.out.println("Tower_A offense soldier: "+tower_a.getOffSoldier()+"  "+"Tower_B offense soldier:"+tower_b.getOffSoldier());
		System.out.println("Tower_A defense soldier: "+tower_a.getDefSoldier()+"  "+"Tower_B defense soldier:"+tower_b.getDefSoldier());
		*/ 

}