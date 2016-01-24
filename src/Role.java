public class Role{
	private int role_id;
	private Property prop;
	private String role_name;
	private String feature;

	public Role(int role_id){
		this.role_id = role_id;
		this.role_name = judgeRole(role_id);
		prop = new Property(role_id);
		this.feature = setFeature(role_id);
	}

	public String judgeRole (int role_id){
		String name = new String();
		if(role_id == 0)
			name = "Liu";
		else if (role_id == 1)
			name = "Sun";
		else if (role_id == 2)
			name = "Cao";
		else if (role_id == 3)
			name = "Zhao";
		else if (role_id == 4)
			name = "Chou";
		else if (role_id == 5)
			name = "Chang";
			

		return name;
	}
	public String setFeature (int role_id){
		String feature = new String();
		if(role_id == 0)
			feature = "Good at tower repair";
		else if (role_id == 1)
			feature = "Good at gaining money";
		else if (role_id == 2)
			feature = "Good at building army";
		else if (role_id == 3)
			feature = "Good at tower repair and building army";
		else if (role_id == 4)
			feature = "Good at gaining money and save money";
		else if (role_id == 5)
			feature = "Good at building army and gaining money";
		
		return feature;
	}
	
	public Property getProperty(){
		return prop;
	}

	public String getRoleName(){
		return role_name;
	}

}