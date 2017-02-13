import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Client {
	private String name;
	private Shop shop;
	public Client(String name, Shop shop) {
		super();
		this.name = name;
		this.shop = shop;
	}
	
	void buyProducts(){
		int rand = new Random().nextInt(4);
		for(Entry<Products, Integer> i : shop.getProducts().entrySet()){
			if(new Random().nextInt(100) < 25){
				shop.remove(i.getKey().getName(), rand);
				shop.reload();
			}
		}
	}
	
}
