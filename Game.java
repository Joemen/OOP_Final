public class Game{
	public static void main(String[] args){
		Tower tower = new Tower();
		tower.setDefSoldier(5);
		tower.setOffSoldier(6);
		tower.setPoint(7);
		
		System.out.println( "point = " + tower.getPoint() );
		System.out.println( "defense soilder = " + tower.getDefSoldier() ); 
		System.out.println( "offense soldier = " + tower.getOffSoldier() );

		Player player = new Player();
		System.out.println( "player name : " + player.getPlayerName() );
		System.out.println( "money = " + player.getMoney() );
		System.out.println( "num of soldier = " + player.getNumSoldier() ); 
		System.out.println( "Role Name = " + player.role.getRoleName() );
	}
}