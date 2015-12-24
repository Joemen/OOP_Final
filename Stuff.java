public class Stuff{
	public int price;
	public String name;
	public boolean remain;
	public int buyer;
	public int point;

	public Stuff(int price, String name, int point){
		this.name = new String(name);
		this.price = price;
		this.point = point;
	}
	// about get
	public boolean isRemain(){
		return this.remain;
	}

	public String getName(){
		return this.name;
	}

	public int getPrice(){
		return this.price;
	}

	// about set
	public void setPrice(int number){
		price = number;
	}

	public void setName(String string){
		this.name = string;
	}

}