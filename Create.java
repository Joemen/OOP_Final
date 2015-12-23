import java.io.*;
public class Create extends Functions{
	
	private String setname;
	private String setrole;
	private int setrole_num;
	
	public void set_name_role(Player player) throws IOException{
		System.out.println("Please decide the name of player"+player.getPlayerID());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.setname =br.readLine();
		player.setPlayerName(setname);
		
		System.out.println("Please decide the role of player"+player.getPlayerID());
		System.out.println("Enter with '0' to choose Liu, who is good at tower repair");
		System.out.println("           '1' to choose Sun, who is Good at gaining money");
		System.out.println("           '2' to choose Cao, who is good at building army");
		System.out.println("           '3' to choose Zhao, who is good at tower repair and building army");
		System.out.println("           '4' to choose Chou, who is good at gaining money and save money");
		System.out.println("           '5' to choose Chang, who is good at building army and gaining money");
		this.setrole=br.readLine();
		while(!(setrole.equals("0")||setrole.equals("1")||setrole.equals("2")||setrole.equals("3")||setrole.equals("4")||setrole.equals("5"))){
			System.out.println("Invalid input! Please choose again!");	
			this.setrole=br.readLine();
		}
		setrole_num =Integer.parseInt(setrole);
		player.setRole(setrole_num);		
	}
	
}