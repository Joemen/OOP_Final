import java.io.*;
public class MunitionsFactory extends Functions{
    public static int[] price = new int [3];
    public static int[] add_soldier = new int [3];
    private static int selection;
    
    
    public MunitionsFactory(){
        setPrice(10, 20, 30);
        setAddSoldier(10, 20, 30);
    }
    
    public static void setPrice(int price_one, int price_two, int price_three){
    	price[0] = price_one;
        price[1] = price_two;
        price[2] = price_three;
    }
    
    public static void setAddSoldier(int add_one, int add_two, int add_three){
        add_soldier[0] = add_one;
        add_soldier[1] = add_two;
        add_soldier[2] = add_three;
    }
    public static void BuySoldier_UI( Player player){
    	selection = ActionFrame.MuntionCombo.getSelectedIndex();
		player.setMoney((int)(player.getMoney()-Math.round(price[selection]*player.getRole().getProperty().is_discount)));
		player.setNumSoldier((int)(player.getNumSoldier()+Math.round(add_soldier[selection]*player.getRole().getProperty().is_add_soldier_generate)));   
    }
    
    public boolean BuySoldier(Player player) throws IOException{
    	String option ="-1";
        System.out.println("-----------------------------------------------------------");
    	System.out.println("|          Welcome to the <MunitionsFactory>              |");
        System.out.println("-----------------------------------------------------------");
		System.out.println(player.getPlayerName()+" have $"+player.getMoney()+" and "+player.getNumSoldier()+" soldiers.");
    	while(!(option.equals("0")||option.equals("1")||option.equals("2")||option.equals("3"))){
    		System.out.println("Please enter your option: ");
        	System.out.println("    (1) spend $"+Math.round(price[0]*player.getRole().getProperty().is_discount)+" for "+Math.round(add_soldier[0]*player.getRole().getProperty().is_add_soldier_generate)+" soldiers. ");
        	System.out.println("    (2) spend $"+Math.round(price[1]*player.getRole().getProperty().is_discount)+" for "+Math.round(add_soldier[1]*player.getRole().getProperty().is_add_soldier_generate)+" soldiers. ");
        	System.out.println("    (3) spend $"+Math.round(price[2]*player.getRole().getProperty().is_discount)+" for "+Math.round(add_soldier[2]*player.getRole().getProperty().is_add_soldier_generate)+" soldiers. ");
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
        		 if(player.getMoney()>=Math.round(price[desicion-1]*player.getRole().getProperty().is_discount)){
        			 player.setMoney((int)(player.getMoney()-Math.round(price[desicion-1]*player.getRole().getProperty().is_discount)));
        			 player.setNumSoldier((int)(player.getNumSoldier()+Math.round(add_soldier[desicion-1]*player.getRole().getProperty().is_add_soldier_generate)));
        			 System.out.println(player.getPlayerName()+" have spent "+Math.round(price[desicion-1]*player.getRole().getProperty().is_discount)+" to buy "+Math.round(add_soldier[desicion-1]*player.getRole().getProperty().is_add_soldier_generate));
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