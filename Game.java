public class Game{
	public static void main(String[] args){
		Tower tower = new Tower();
		tower.setDefSoldier(5);
		tower.setOffSoldier(6);
		tower.setPoint(7);
		
		System.out.println(tower.getPoint() + tower.getDefSoldier() + tower.getOffSoldier() );
	}
}