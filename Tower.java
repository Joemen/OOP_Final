public class Tower{
	private int defense_soldier;
	private int point;
	private int offense_soldier;

	public Tower(){
		this.defense_soldier = 0;
		this.offense_soldier = 0;
		this.point = 0;
	}

	public void setDefSoldier(int def_soldier){
		this.defense_soldier = def_soldier;
	}

	public void setOffSoldier(int off_soldier){
		this.offense_soldier = off_soldier;
	}

	public void setPoint(int point){
		this.point = point;
	}

	public int getPoint(){
		return this.point;
	}

	public int getDefSoldier(){
		return this.defense_soldier;
	}

	public int getOffSoldier(){
		return this.offense_soldier;
	}

}