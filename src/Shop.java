public class Shop{
	public static Stuff stuff[] = new Stuff[ Constants.total_shop_stuff ];
	public static int stuff_acc;
	public static boolean[] stuff_sold_out = new boolean[4];
	
	public Shop(){
		// first stuff
		stuff[0] = new Stuff( 80, "Thresure", 100);
		stuff[1] = new Stuff( 150, "Shan-Kuo-Ting", 200);
		stuff[2] = new Stuff( 30, "Spring-Fall", 50);
		stuff[3] = new Stuff( 50, "Bow", 75);
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