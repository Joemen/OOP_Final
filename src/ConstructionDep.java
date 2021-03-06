import java.io.*;

public class ConstructionDep extends Functions{
    public static int[] fee = new int [3];
    public static int[] ser_func = new int [3];
    public static int selection;
    
    public ConstructionDep(){
        setFee(Constants.fee_one, Constants.fee_two, Constants.fee_three);
        setService(Constants.repair_one, Constants.repair_two, Constants.repair_three);
    }
    
    public static void setFee(int fee_one, int fee_two, int fee_three){
        fee[0] = fee_one;
        fee[1] = fee_two;
        fee[2] = fee_three;
    }
    
    public static void setService(int mten_one, int mten_two, int mten_three){
        ser_func[0] = mten_one;
        ser_func[1] = mten_two;
        ser_func[2] = mten_three;
    }
    public static void RepairTower_UI( Player player , Tower tower){
    	
    	selection = ActionFrame.ConstructionCombo.getSelectedIndex();
    	AIinvolve();
		player.setMoney((int)(player.getMoney()-Math.round(fee[selection]*player.getRole().getProperty().is_discount)));
        tower.setBlood((int)(tower.getBlood()+Math.round(ser_func[selection]*player.getRole().getProperty().is_tower_repair_rate)));	
    }
    
    public static void AIinvolve(){
    	if (EnemyAI.AI_index && (Game.turn+1)%2 == 1){
    		selection = EnemyAI.selection;
    	}
    }
    
    public boolean RepairTower(Player player, Tower tower) throws IOException{
        System.out.println("-----------------------------------------------------------");
        System.out.println("|       Welcome to the <Construction Department>          |");
        System.out.println("-----------------------------------------------------------");
        System.out.println(player.getPlayerName()+" have $"+player.getMoney()+" and your tower status is "+tower.getBlood());
        System.out.println("Please choose your service: ");
        System.out.println("    (1) $"+Math.round(fee[0]*player.getRole().getProperty().is_discount)+" for blood+"+Math.round(ser_func[0]*player.getRole().getProperty().is_tower_repair_rate));
        System.out.println("    (2) $"+Math.round(fee[1]*player.getRole().getProperty().is_discount)+" for blood+"+Math.round(ser_func[1]*player.getRole().getProperty().is_tower_repair_rate));
        System.out.println("    (3) $"+Math.round(fee[2]*player.getRole().getProperty().is_discount)+" for blood+"+Math.round(ser_func[2]*player.getRole().getProperty().is_tower_repair_rate));
        System.out.println("    (0) go back to the menu. ");
        String buffer=" ";
        BufferedReader readStake = new BufferedReader(new InputStreamReader(System.in));
        buffer=readStake.readLine();
        int option = 0;
        if(buffer.equals("")||buffer.length()>1){ // avoid Invalid input
            System.out.println("Invalid input! Please choose again!");
            return this.RepairTower(player, tower);
        }
        else if ((int)buffer.charAt(0)==48)
            option = -1;
        else if ((int)buffer.charAt(0)==49)
            option = 0;
        else if ((int)buffer.charAt(0)==50)
            option = 1;
        else if ((int)buffer.charAt(0)==51)
            option = 2;
        else {
            System.out.println("Invalid input! Please choose again!");
            return this.RepairTower(player, tower);
        }
        if (option ==-1){
            System.out.println("Goodbye!");
            return false;
        }
        else if(player.getMoney()-Math.round(fee[option]*player.getRole().getProperty().is_discount)<0){
            System.out.println("Your money is not enough!");
            return this.RepairTower(player, tower);
        }
        else {
            player.setMoney((int)(player.getMoney()-Math.round(fee[option]*player.getRole().getProperty().is_discount)));
            tower.setBlood((int)(tower.getBlood()+Math.round(ser_func[option]*player.getRole().getProperty().is_tower_repair_rate)));
            System.out.println(player.getPlayerName()+" have spent $"+Math.round(fee[option]*player.getRole().getProperty().is_discount)+" to repair their tower <"+tower.getBlood()+"(+"+Math.round(ser_func[option]*player.getRole().getProperty().is_tower_repair_rate)+")>");
            return true;
        }
        
    }
    
}