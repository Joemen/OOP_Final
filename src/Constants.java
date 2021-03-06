public class Constants{
	private Constants(){

	} // to make no instance
	
	public static final int player_num = 1;
	// # player for one side
	
	// public static final int camp_num = 2;
	// # camp for a game
	
	public static final float advantage_of_def = 1.05f;
	// # advantage ratio of defense

	public static final int total_round = 10;
	// # total round in a game

	public static final int total_shop_stuff = 4;
	// # total stuff will be in the shop 
	
	public static final float money_weighted = 1.0f;
	// # final Game Statistics <Money>
	
	public static final float soldier_weighted = 0.5f;
	// # final Game Statistics <Soldier>
	
	public static final float tower_hp_weighted = 1.2f;
	// # final Game Statistics <TowerHP>
	
	public static final boolean have_origin_frame_or_not = true;
	// have origin frame display or not
	
	public static final int damage_upper_bound = 20;
	// maximum damage to tower in each round
	
	/******************************************************/
	/************** argument in the game ******************/
	/****** please don't change the argument below ********/
	/******************************************************/
	
	public static final int initial_money = 100;
	public static final int initial_soldier = 50;
	
	public static final int fee_one = 15;
	public static final int fee_two = 30;
	public static final int fee_three = 45;
	
	public static final int repair_one = 10;
	public static final int repair_two = 20;
	public static final int repair_three = 30;
	
	public static final int munition_amount_one = 20;
	public static final int munition_amount_two = 30;
	public static final int munition_amount_three = 40;
	
	public static final int bank_money = 60;
	
}