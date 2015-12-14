import java.io.*;

public class ActivityMenu {
    Functions[] menu = new Functions[10];
    ConstructionDep CSDep = new ConstructionDep();
    MunitionsFactory MFDep = new MunitionsFactory();
    Bank BKDep = new Bank();
    
    public void ActivityMenu(){
        menu[0] = CSDep;
        menu[1] = MFDep;
        menu[2] = BKDep;
    }
    
    public void Action(Player player, Tower tower) throws IOException{
        System.out.println("=======================================================");
        System.out.println("====================<Activity Menu>====================");
        System.out.println("=======================================================");
        System.out.println("===================YOU CAN GO TO ONE PLACE EACH TURN===");
        System.out.println("=======================================================");
        System.out.println(" <Player"+player.getCampNum()+">");
        System.out.println("  (1) Construction Department  ****REPAIR YOUR TOWER****");
        System.out.println("  (2) Munitions Factory        ****BUILD YOUR ARMY****");
        System.out.println("  (3) Bank                     ****GET EXTRA MONEY****");
        System.out.println("  (0) Abandon this round       ****GOODBYE MY FRIEND****");
        String buffer=" ";
        BufferedReader readStake = new BufferedReader(new InputStreamReader(System.in));
        buffer=readStake.readLine();
        int option = 0;
        if(buffer.equals("")||buffer.length()>1){ // avoid Invalid input
            System.out.println("Invalid input! Please choose again!");
            this.Action(player, tower);
        }
        else if ((int)buffer.charAt(0)==48)
            option = -1;
        else if ((int)buffer.charAt(0)==49)
            option = 0;
        else if ((int)buffer.charAt(0)==50)
            option = 1;
        else if ((int)buffer.charAt(0)==51)
            option = 2;
        else if ((int)buffer.charAt(0)==52)
            option = 3;
        else {
            System.out.println("Invalid input! Please choose again!");
            this.Action(player, tower);
        }
        if (option==-1){
            
        }
        else if (option==0){
            if(!CSDep.RepairTower(player, tower))
                this.Action(player, tower);
        }
        else if (option==1){
            if(!MFDep.BuySoldier(player))
                this.Action(player, tower);
        }
        else if (option==2){
            if(!BKDep.bankgivesmoney(player))
                this.Action(player, tower);
        }

        
    }




}