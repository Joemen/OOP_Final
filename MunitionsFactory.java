import java.io.*;
public class MunitionsFactory extends Functions{
    private int[] price = new int [3];
    private int[] add_soldier = new int [3];
    
    
    public MunitionsFactory(){
        this.setPrice(10, 20, 30);
        this.setAddSoldier(10, 20, 30);
    }
    
    public void setPrice(int price_one, int price_two, int price_three){
        this.price[0] = price_one;
        this.price[1] = price_two;
        this.price[2] = price_three;
    }
    
    public void setAddSoldier(int add_one, int add_two, int add_three){
        this.add_soldier[0] = add_one;
        this.add_soldier[1] = add_two;
        this.add_soldier[2] = add_three;
    }
    public boolean BuySoldier(Player player) throws IOException{
    	String option ="-1";
        System.out.println("-----------------------------------------------------------");
    	System.out.println("|          Welcome to the <MunitionsFactory>              |");
        System.out.println("-----------------------------------------------------------");
		System.out.println(player.getPlayerName()+" have $"+player.getMoney()+" and "+player.getNumSoldier()+" soldiers.");
    	while(!(option.equals("0")||option.equals("1")||option.equals("2")||option.equals("3"))){
    		System.out.println("Please enter your option: ");
        	System.out.println("    (1) spend $10 for 10 soldiers. ");
        	System.out.println("    (2) spend $20 for 20 soldiers. ");
        	System.out.println("    (3) spend $30 for 30 soldiers. ");
        	System.out.println("    (0) go back to the menu. ");
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	option =br.readLine();
        	if(option.equals("0")){
        	System.out.println("Goodbye!");
                return false;
        	}
        	if(option.equals("1")||option.equals("2")||option.equals("3")){
        		 int desicion;
        		 desicion =Integer.parseInt(option);
        		 if(player.getMoney()>=this.price[desicion-1]){
        			 player.setMoney(player.getMoney()-this.price[desicion-1]);
        			 player.setNumSoldier(player.getNumSoldier()+this.add_soldier[desicion-1]);
        			 System.out.println(player.getPlayerName()+" have spent "+this.price[desicion-1]+" to buy "+this.add_soldier[desicion-1]);
        			 System.out.println("Now "+player.getPlayerName()+" have $"+player.getMoney()+" and "+player.getNumSoldier()+" soldiers.");
                     return true;
        		 }
        		 else{
        			 option ="-1";
        			 System.out.println("You don't have enough money. ");
        		 }
        	}        	
		}
        return false; //cant fix
    }    
}