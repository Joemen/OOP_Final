
import java.util.Random;

public class EnemyAI  {
	public static boolean AI_index = false; 
	private static Random options = new Random();
	public static int decision = -1;
	public static int selection = -1;

    public EnemyAI(){
    	
    	
    }
    public static void aiAction(){
    	if (AI_index){
    		MainFrame.actionbutton2.setEnabled(false);
        	MainFrame.btnFight.setEnabled(false);
        	MainFrame.shopbutton.setEnabled(false);
        	if (Game.player[1].getMoney() >= Constants.fee_three){
        		selection = 2;
        		int num = options.nextInt(10);
        		if (num == 0 || num == 1 ||num == 2 ||num == 3 ){
        			decision = 1;
        			ConstructionDep.RepairTower_UI(Game.player[1], Game.tower[1]);
        		}
        		else if (num == 4 || num == 5 ||num == 6 ||num == 7 ){
        			decision = 2;
        			MunitionsFactory.BuySoldier_UI(Game.player[1]);
        		}
        		else if (num == 8){
        			decision = 3;
        			int money = (int)Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate);
        			Game.player[1].setMoney((int)(Game.player[1].getMoney()+Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate)));
    				//new BankAnimation(money);
        		}
        		else if (num == 9){
        			decision = 4;
        			selection = 2;
        			Explore.spy_UI(Game.player[1]);
        		}
        			
        	}
        	else if (Game.player[1].getMoney() >= Constants.fee_two){
        		selection = 1;
        		int num = options.nextInt(10);
        		if ( num == 0 || num == 1 || num == 2 ){
        			decision = 1;
        			ConstructionDep.RepairTower_UI(Game.player[1], Game.tower[1]);
        		}
        		else if (num == 3 || num == 4 || num == 5 ){
        			decision = 2;
        			MunitionsFactory.BuySoldier_UI(Game.player[1]);
        		}
        		else if (num == 6 || num == 7){
        			decision = 3;
        			int money = (int)Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate);
        			Game.player[1].setMoney((int)(Game.player[1].getMoney()+Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate)));
    				//new BankAnimation(money);
        		}
        		else if (num == 8){
        			decision = 4;
        			selection = 0;
        			Explore.expeditionary_UI(Game.player[1]);
        		}
        		else if (num == 9){
        			decision = 4;
        			selection = 1;
        			Explore.steal_money_UI(Game.player[1]);
        		}
        	}
        	else if (Game.player[1].getMoney() >= Constants.fee_one){
        		selection = 0;
        		int num = options.nextInt(10);
        		if ( num == 0 || num == 1 ){
        			decision = 1;
        			ConstructionDep.RepairTower_UI(Game.player[1], Game.tower[1]);
        		}
        		else if (num == 2 || num == 3){
        			decision = 2;
        			MunitionsFactory.BuySoldier_UI(Game.player[1]);
        		}
        		else if (num == 4 || num == 5 || num == 6){
        			decision = 3;
        			int money = (int)Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate);
        			Game.player[1].setMoney((int)(Game.player[1].getMoney()+Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate)));
    				//new BankAnimation(money);
        		}
        		else if (num == 7){
        			decision = 4;
        			selection = 0;
        			Explore.expeditionary_UI(Game.player[1]);
        		}
        		else if (num == 8 ||num == 9){
        			decision = 4;
        			selection = 1;
        			Explore.steal_money_UI(Game.player[1]);
        		}
        	}
        	else {
        		int num = options.nextInt(10);
        		if (num == 0 || num == 1 || num == 2 || num == 3 || num == 4){
        			decision = 3; 
        			int money = (int)Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate);
        			Game.player[1].setMoney((int)(Game.player[1].getMoney()+Math.round(Bank.give_money*Game.player[1].getRole().getProperty().is_add_money_rate)));
    				//new BankAnimation(money);
        		}
        		else if (num == 5 || num == 6){
        			decision = 4;
        			selection = 0;
        			Explore.expeditionary_UI(Game.player[1]);
        		}
        		else if (num == 7 || num == 8 ||num == 9){
        			decision = 4;
        			selection = 1;
        			Explore.steal_money_UI(Game.player[1]);
        		}
        		
        	}
        	//Game.blockmain = false;
        	TotalPrint.printAction();
        	StateControl.control(StateControl.State.DEPLOY_2);
    	}
    	
    }
    
    public static void aiDeploy(){
    	if (AI_index){
    		MainFrame.actionbutton2.setEnabled(false);
    		MainFrame.btnFight2.setEnabled(false);
    		
    		Game.tower[1].setDefSoldier( Game.tower[1].getDefSoldier() + Game.player[1].getNumSoldier()/2);
    		Game.tower[1].setOffSoldier( Game.tower[1].getOffSoldier() + Game.player[1].getNumSoldier()/2);
    		Game.player[1].setNumDefSoldier( Game.player[1].getNumSoldier()/2 );
    		Game.player[1].setNumOffSoldier( Game.player[1].getNumSoldier()/2 );
    		//Game.blockmain = false;
    		TotalPrint.printPressReady();
    		selection = -1;
    		decision = -1;
    		StateControl.control(StateControl.State.WAR);
    	}
    }
    
}
