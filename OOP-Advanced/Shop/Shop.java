import java.util.HashMap;

public class Shop {
	private String name;
	private String address;
	private double money;
	private HashMap<String, Products> products;
	public Shop(String name, String address, double money) {
		super();
		this.name = name;
		this.address = address;
		this.money = money;
		products = new HashMap<>();
	}
	
	void addProduct(Products newProduct){
		if(!products.containsKey(newProduct.getName())){
			products.put(newProduct.getName(), newProduct);
			return;
		}
		Products toAdd = products.get(newProduct.getName());
		int quantity = toAdd.getQuantity();
		toAdd.setQuantity(quantity + newProduct.getQuantity());		
	}
	
	Products getProduct(String name){
		if(!products.containsKey(name)){
			return null;
		}
		return products.get(name);
	}
	
	void removeProduct(Products toRemove){
		if(!products.containsKey(toRemove.getName())){
			return;
		}
		if(products.get(toRemove.getName()).getQuantity() - toRemove.getQuantity() < 0){
			return;
		}
		int newQuantity = products.get(toRemove.getName()).getQuantity() - toRemove.getQuantity();
		products.get(toRemove.getName()).setQuantity(newQuantity);
	}
	
	double getMoney(){
		return money;
	}
	
	void setMoney(double money){
		if(money < 0){
			return;
		}
		this.money = money;
	}
}
