
import java.io.*;


public class Commander extends Camp{
    
    public Commander(){
        
    }
    
    public Commander(int num){
        this.setCampNum(num);
    }
    

    public void dispatchArmy (Player player, Tower tower) throws IOException{
        System.out.println("---------------------------------------------");
        System.out.println("|       Time to arrange your army!          |");
        System.out.println("---------------------------------------------");
        System.out.println(player.getPlayerName()+" have $"+player.getNumSoldier()+" soldiers altogether!");
        
        System.out.println("Please deside how many soldiers defending the tower:");
        String buffer=" ";
        BufferedReader readStake = new BufferedReader(new InputStreamReader(System.in));
        buffer=readStake.readLine();
        int option1=Integer.parseInt(buffer);
        tower.setDefSoldier(option1);
        
        System.out.println("Please deside how many soldiers charging:");
        String buffer1=" ";
        BufferedReader readStake1 = new BufferedReader(new InputStreamReader(System.in));
        buffer1=readStake1.readLine();
        int option2=Integer.parseInt(buffer1);
        tower.setOffSoldier(option2);
        if(option2+option1>player.getNumSoldier()){
            System.out.println("Wrong Number of soldiers! Soldiers are not enough!");
            this.dispatchArmy(player,tower);
        }
    }
    
    

}