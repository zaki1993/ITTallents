
public abstract class Products {
	private String name;
	private double price;
	private int quantity;
	public Products(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	String getName(){
		return name;
	}
	
	double getPrice(){
		return price;
	}
	
	int getQuantity(){
		return quantity;
	}
	
	void setQuantity(int newQuantity){
		if(newQuantity < 0){
			return;
		}
		quantity = newQuantity;
	}
}
