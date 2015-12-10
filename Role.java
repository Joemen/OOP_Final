public class Role{
	private int role_id;
	private Property prop;
	private String role_name;

	public Role(int role_id){
		this.role_id = role_id;
		this.role_name = judgeRole(role_id);
		prop = new Property(role_id);
	}

	public String judgeRole (int role_id){
		String name = new String();
		if(role_id == 0)
			name = "no_role_name";

		return name;
	}

	public String getRoleName(){
		return role_name;
	}

}