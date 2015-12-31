public class Shop{
	public static Stuff stuff[] = new Stuff[ Constants.total_shop_stuff ];
	public static int stuff_acc;
	public static boolean[] stuff_sold_out = new boolean[4];
	
	public Shop(){
		// first stuff
		stuff[0] = new Stuff( 10, "Thresure", 15);
		stuff[1] = new Stuff( 4, "Shan-Kuo-Ting", 30);
		stuff[2] = new Stuff( 8, "Spring-Fall", 6);
		stuff[3] = new Stuff( 2, "Bow", 10);
		stuff_acc = 4 ;
		
		int i;
		for(i=0; i<stuff_acc; i++){
			stuff_sold_out[i] = false; 
		}
	}

	public Stuff getStuff(int number){
		if(number >= stuff_acc){
			System.out.println("In shop class, number out of bound error");
			return null;
		}else{
			return stuff[number];
		}

	}

}