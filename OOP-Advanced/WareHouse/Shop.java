import java.util.HashMap;
import java.util.Map.Entry;

public class Shop {
	private class Deliver{
		private String name;
		private HashMap<Products, Integer> products;
		private final static int DELIVER = 500;
		public Deliver(String name) {
			super();
			this.name = name;
			this.products = new HashMap<>();
			products.put(new Banana(), 1000);
			products.put(new Orange(), 1000);
			products.put(new Apple(), 1000);
			products.put(new Potato(), 1000);
			products.put(new Eggplant(), 1000);
			products.put(new Cucumber(), 1000);
			products.put(new Pork(), 1000);
			products.put(new Beef(), 1000);
			products.put(new Chicken(), 1000);
		}
		
		void reload(){
			for(Entry<Products, Integer> i : products.entrySet()){
				if(i.getValue() < DELIVER){
					i.setValue(1000);
				}
			}
		}
		
		void remove(String name, int quantity){
			for(Entry<Products, Integer> i : products.entrySet()){
				if(i.getKey().getName() == name){
					i.setValue(i.getValue() - quantity);
				}
			}
		}
	}
	private class Sklad{
		private HashMap<Products, Integer> products;
		private Deliver deliver;
		private static final int DELIVER = 10;
		public Sklad(String name) {
			super();
			deliver = new Deliver(name);
			this.products = new HashMap<>();
				products.put(new Banana(), 15);
				products.put(new Orange(), 15);
				products.put(new Apple(), 15);
				products.put(new Potato(), 15);
				products.put(new Eggplant(), 15);
				products.put(new Cucumber(), 15);
				products.put(new Pork(), 15);
				products.put(new Beef(), 15);
				products.put(new Chicken(), 15);
		}
		
		void deliver(){
			for(Entry<Products, Integer> i : products.entrySet()){
				if(i.getValue() < DELIVER){
					i.setValue(i.getValue() + 25);
					deliver.remove(i.getKey().getName(), 25);
					deliver.reload();
				}
			}
		}
		
		void removeProduct(String name){
			for(Entry<Products, Integer> i : products.entrySet()){
				if(i.getKey().getName() == name){
					i.setValue(i.getValue() - 5);
				}
			}
		}
		
		HashMap<Products, Integer> getProducts(){
			return products;
		}
	}
	private String name;
	private Sklad sklad;
	private HashMap<Products, Integer> products;
	private static final int DELIVER = 10;
	public Shop(String name, String dostavchik) {
		super();
		this.name = name;
		sklad = new Sklad(dostavchik);
		products = new HashMap<>();
		reload();
	}
	
	void reload(){
		for(Entry<Products, Integer> i : sklad.getProducts().entrySet()){
			if(i.getValue() < DELIVER){
				if(products.containsKey(i.getKey().getName())){
					products.put(i.getKey(), 5);
					sklad.removeProduct(i.getKey().getName());
				}
				else{
					products.put(i.getKey(), i.getValue() + 5);
					sklad.removeProduct(i.getKey().getName());
				}
			}
		}
	}
	
	void remove(String name, int quantity){
		for(Entry<Products, Integer> i : products.entrySet()){
			if(i.getKey().getName() == name){
				i.setValue(i.getValue() - quantity);
			}
		}
	}
	
	HashMap<Products, Integer> getProducts(){
		return products;
	}
}
