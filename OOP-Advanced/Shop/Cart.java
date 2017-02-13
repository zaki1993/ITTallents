import java.util.HashMap;

public class Cart {
	private HashMap<String, Products> products;
	private int maxQuantity;
	private int currentQuantity;
	public Cart(int maxQuantity) {
		super();
		this.products = new HashMap<>();
		this.maxQuantity = maxQuantity;
		this.currentQuantity = 0;
	}
	
	void addProduct(Products newProduct){
		if(currentQuantity + newProduct.getQuantity() >= maxQuantity){
			return;
		}
		if(!products.containsKey(newProduct.getName())){
			products.put(newProduct.getName(), newProduct);
			return;
		}
		Products toChange = products.get(newProduct.getName());
		toChange.setQuantity(toChange.getQuantity() + newProduct.getQuantity());
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
	
	HashMap<String, Products> getProducts(){
		return products;
	}
}
