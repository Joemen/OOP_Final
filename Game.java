import java.io.*;

public class Game{
	public static void main(String[] args) throws IOException{
		Tower tower1 = new Tower(1);
        Tower tower2 = new Tower(2);
        Computer computer = new Computer();
		/*tower1.setDefSoldier(5);
		tower1.setOffSoldier(6);
		tower1.setPoint(7);
		
		System.out.println( "point = " + tower.getPoint() );
		System.out.println( "defense soilder = " + tower.getDefSoldier() ); 
		System.out.println( "offense soldier = " + tower.getOffSoldier() );
        System.out.println( "tower blood = " + tower.getBlood() );*/

		Player player1 = new Player(1);
        Player player2 = new Player(2);
        System.out.println( "##################Two Camp Game Start!!##################");
        System.out.println( "______________________<Game status>______________________");
        
        System.out.println( "<player name>     " + player1.getPlayerName() +"      "+player2.getPlayerName());
		System.out.println( "<money>           " + player1.getMoney() +"                    "+player2.getMoney());
		System.out.println( "<num of soldier>  " + player1.getNumSoldier() +"                    "+player2.getNumSoldier());
        System.out.println();
        
		//System.out.println( "Role Name = " + player1.role.getRoleName() );
        int i=1;
        ActivityMenu AM = new ActivityMenu();

        while(i<3){
            System.out.println( "###################### Round <"+i+"> ######################");
            AM.Action(player1, tower1);
            System.out.println( "                                              ");
            player1.setArmy(tower1);
            AM.Action(player2, tower2);
            System.out.println( "                                              ");
            player2.setArmy(tower2);
            computer.fight(tower1,tower2,player1,player2);
            System.out.println( "#########################################################");
            System.out.println( "______________________<Game status>______________________");
            System.out.println( "<player name>     " + player1.getPlayerName() +"      "+player2.getPlayerName());
            System.out.println( "<money>           " + player1.getMoney() +"                    "+player2.getMoney());
            System.out.println( "<num of soldier>  " + player1.getNumSoldier() +"                    "+player2.getNumSoldier());
            System.out.println();
            i++;
        }
	}
}