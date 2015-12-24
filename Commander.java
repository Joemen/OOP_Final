
import java.io.*;


public class Commander extends Camp{
    
    public Commander(){
        
    }
    
    public Commander(int num){
        this.setCampNum(num);
    }
    
    public static void dispatchArmy_UI (Player player, Tower tower) {
    	tower.setDefSoldier( tower.getDefSoldier() + Integer.valueOf(FightFrame.amount_Def.getText()));
        tower.setOffSoldier( tower.getOffSoldier() + Integer.valueOf(FightFrame.amount_Off.getText()));
        player.setNumDefSoldier( Integer.valueOf(FightFrame.amount_Def.getText()) );
        player.setNumOffSoldier( Integer.valueOf(FightFrame.amount_Off.getText()) );
    	
    }

    public void dispatchArmy (Player player, Tower tower) throws IOException{
        System.out.println("---------------------------------------------");
        System.out.println("|       Time to arrange your army!          |");
        System.out.println("---------------------------------------------");
        System.out.println(player.getPlayerName()+" have "+player.getNumSoldier()+" soldiers altogether!");
        
        try{
            System.out.println("Please decide how many soldiers defending the tower:");
            String buffer=" ";
            BufferedReader readStake = new BufferedReader(new InputStreamReader(System.in));
            buffer=readStake.readLine();
            int option1=Integer.parseInt(buffer);
            
            System.out.println("Please decide how many soldiers charging:");
            String buffer1=" ";
            BufferedReader readStake1 = new BufferedReader(new InputStreamReader(System.in));
            buffer1=readStake1.readLine();
            int option2=Integer.parseInt(buffer1);

            if(option2+option1>player.getNumSoldier()){
                System.out.println("Wrong Number of soldiers! Soldiers are not enough!");
                this.dispatchArmy(player,tower);
            }
            else{
            // adjust the soldier number
                tower.setDefSoldier( tower.getDefSoldier() + option1);
                tower.setOffSoldier( tower.getOffSoldier() + option2);
                player.setNumDefSoldier( option1 );
                player.setNumOffSoldier( option2 );
            }
        }
        catch(NumberFormatException e) { 
            System.out.println("Invalid input! Please choose again!");
            this.dispatchArmy(player,tower); 
        }    
    }
}