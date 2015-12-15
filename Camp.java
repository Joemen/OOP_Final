
public class Camp {
    private int camp_num;
    private String camp_name;

    public void setCampNum(int num){
        this.camp_num = num;
    }

    public void setCampName(int num){
    	// given camp number, we give a camp name according to it
    	if(num == 1)
    		this.camp_name = new String("A Camp");
    	else if( num == 2)
    		this.camp_name = new String("B Camp");
    	else
    		this.camp_name = new String("No Camp");
    }
    
    public int getCampNum(){
        return this.camp_num;
    }

    public String getCampName(){
        return this.camp_name;
    }

}