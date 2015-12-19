public class Property{
	// to be continued ... 
	public double is_add_money_rate;
	public double is_add_soldier_generate;
	public double is_tower_repair_rate;
	public double is_discount;
	

	public Property(int role_id){
		// according to role_id, we can give different property
		set_prop(role_id);
	}

	public void set_prop(int role_id){
		if(role_id == 0){
			this.is_add_money_rate = 1;
			this.is_add_soldier_generate = 1;
			this.is_tower_repair_rate = 1.1;
			this.is_discount = 1;
		}
		else if (role_id == 1){
			this.is_add_money_rate = 1.1;
			this.is_add_soldier_generate = 1;
			this.is_tower_repair_rate = 1;
			this.is_discount = 1;
		}
		else if (role_id == 2){
			this.is_add_money_rate = 1;
			this.is_add_soldier_generate = 1.1;
			this.is_tower_repair_rate = 1;
			this.is_discount = 1;
		}
		else if (role_id == 3){
			this.is_add_money_rate = 1;
			this.is_add_soldier_generate = 1.05;
			this.is_tower_repair_rate = 1.05;
			this.is_discount = 1;
		}
		else if (role_id == 4){
			this.is_add_money_rate = 1.05;
			this.is_add_soldier_generate = 1;
			this.is_tower_repair_rate = 1;
			this.is_discount = 0.95;
		}
		else if (role_id == 5){
			this.is_add_money_rate = 1.05;
			this.is_add_soldier_generate = 1.05;
			this.is_tower_repair_rate = 1;
			this.is_discount = 1;
		}
	}
}