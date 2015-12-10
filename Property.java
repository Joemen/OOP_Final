public class Property{
	// to be continued ... 
	int is_add_money_rate;
	int is_add_soldier_generate;

	public Property(int role_id){
		// according to role_id, we can give different property
		set_prop(role_id);
	}

	public void set_prop(int role_id){
		if(role_id == 0){
			this.is_add_money_rate = 0;
			this.is_add_soldier_generate = 0;
		}
	}
}