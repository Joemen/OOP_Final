public class Tower extends Camp{
	private int defense_soldier;
	private int point;
	private int offense_soldier;
	private int blood;

	public Tower(int num){
        this.setCampNum(num);
		this.setDefSoldier(0);
		this.setOffSoldier(0);
		this.setPoint(0);
		this.setBlood(100);
	}

	/////////////// about set /////////////

	public void setDefSoldier(int def_soldier){
		this.defense_soldier = def_soldier;
	}

	public void setOffSoldier(int off_soldier){
		this.offense_soldier = off_soldier;
	}

	public void setPoint(int point){
		this.point = point;
	}

	public void setBlood(int blood){
		this.blood = blood;
	}
	
	/////////////// about get /////////////

	public int getPoint(){
		return this.point;
	}

	public int getDefSoldier(){
		return this.defense_soldier;
	}

	public int getOffSoldier(){
		return this.offense_soldier;
	}

	public int getBlood(){
		return this.blood;
	}

	/////////////// about other /////////////

	public void printBlood(){
		System.out.println("the remaneing blood : " + this.blood);
	}

}