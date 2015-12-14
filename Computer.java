public class Computer{
	private int a_off_death;
	private int b_off_death;
	private int a_def_death;
	private int b_def_death;
	private int a_loss_blood;
	private int b_loss_blood;
	

	public Computer(){
		this.seta_off_death(0);
		this.setb_off_death(0);
		this.seta_def_death(0);
		this.setb_def_death(0);
		this.seta_loss_blood(0);
		this.setb_loss_blood(0);
	}

	public void seta_off_death(int off_death){
		this.a_off_death = off_death;
	}

	public void setb_off_death(int off_death){
		this.b_off_death = off_death;
	}

	public void seta_def_death(int def_death){
		this.a_def_death = def_death;
	}

	public void setb_def_death(int def_death){
		this.b_def_death = def_death;
	}
	
	public void seta_loss_blood(int loss_blood){
		this.a_loss_blood = loss_blood;
	}
	
	public void setb_loss_blood(int loss_blood){
		this.b_loss_blood = loss_blood;
	}

	public int geta_off_death(){
		return this.a_off_death;
	}

	public int getb_off_death(){
		return this.b_off_death;
	}

	public int geta_def_death(){
		return this.a_def_death;
	}

	public int getb_def_death(){
		return this.b_def_death;
	}
	
	public int geta_loss_blood(){
		return this.a_loss_blood;
	}
	
	public int getb_loss_blood(){
		return this.b_loss_blood;
	}
	
	public void fight (Tower tower_a, Tower tower_b, Player player_a, Player player_b){
		int randdeath;
        System.out.println("--------------------------------");
		System.out.println("| 2 troops are about to fight! |");
        System.out.println("--------------------------------");
		System.out.println("Tower_A blood: "+tower_a.getBlood()+"============Tower_A blood: "+tower_b.getBlood());
		System.out.println("Tower_A offense soldier: "+tower_a.getOffSoldier()+"  "+"Tower_B offense soldier:"+tower_b.getOffSoldier());
		System.out.println("Tower_A defense soldier: "+tower_a.getDefSoldier()+"  "+"Tower_B defense soldier:"+tower_b.getDefSoldier());
		//================
		//Tower_A
		if(tower_b.getOffSoldier()>=tower_a.getDefSoldier()){
			randdeath=tower_a.getDefSoldier()/2;
			seta_loss_blood((int)(Math.random()*((tower_b.getOffSoldier()-tower_a.getDefSoldier())/2)+10));
		}
		else{
			randdeath=tower_b.getOffSoldier()/2;
			seta_loss_blood((int)(Math.random()*15));
		}
		seta_def_death((int)(Math.random()*randdeath));
		setb_off_death((int)(Math.random()*randdeath));		
		//Tower_B
		if(tower_a.getOffSoldier()>=tower_b.getDefSoldier()){
			randdeath=tower_b.getDefSoldier()/2;
			setb_loss_blood((int)(Math.random()*((tower_a.getOffSoldier()-tower_b.getDefSoldier())/2)+10));
		}
		else{
			randdeath=tower_a.getOffSoldier()/2;
			setb_loss_blood((int)(Math.random()*15));
		}
		setb_def_death((int)(Math.random()*randdeath));
		seta_off_death((int)(Math.random()*randdeath));	
		//================
		tower_a.setBlood(tower_a.getBlood()-this.geta_loss_blood());
		tower_b.setBlood(tower_b.getBlood()-this.getb_loss_blood());
		tower_a.setOffSoldier(tower_a.getOffSoldier()-this.geta_off_death());
		tower_b.setOffSoldier(tower_b.getOffSoldier()-this.getb_off_death());
		tower_a.setDefSoldier(tower_a.getDefSoldier()-this.geta_def_death());
		tower_b.setDefSoldier(tower_b.getDefSoldier()-this.getb_def_death());
        player_a.setNumSoldier(tower_a.getOffSoldier()+tower_a.getDefSoldier());
        player_b.setNumSoldier(tower_b.getOffSoldier()+tower_b.getDefSoldier());
		System.out.println("Fight ends.");
		System.out.println("Tower_A blood: "+tower_a.getBlood()+"============Tower_A blood: "+tower_b.getBlood());
		System.out.println("Tower_A offense soldier: "+tower_a.getOffSoldier()+"  "+"Tower_B offense soldier:"+tower_b.getOffSoldier());
		System.out.println("Tower_A defense soldier: "+tower_a.getDefSoldier()+"  "+"Tower_B defense soldier:"+tower_b.getDefSoldier());
	}

}