public class Shop{
	public static Stuff stuff[] = new Stuff[ Constants.total_shop_stuff ];
	public static int stuff_acc;

	public Shop(){
		// first stuff
		stuff[0] = new Stuff( 120, "treasure1", 12);
		stuff_acc ++ ;
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