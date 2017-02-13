import java.util.HashMap;
import java.util.Map.Entry;

public class Buyer implements IBuyer{
	private Shop shop;
	private double money;
	private Cart cart;
	public Buyer(double money, int bag) {
		super();
		this.money = money;
		cart = new Cart(bag);
	}
	
	void setShop(Shop newShop){
		shop = newShop;
	}

	@Override
	public void addProduct(Products newProduct) {
		cart.addProduct(newProduct);
		shop.removeProduct(newProduct);
	}

	@Override
	public void removeProduct(Products newProduct) {
		cart.removeProduct(newProduct);
		shop.addProduct(newProduct);
	}

	@Override
	public void pay() {
		double getProductsPrice = 0;
		HashMap<String, Products> products = cart.getProducts();
		for(Entry<String, Products> i : products.entrySet()){
			getProductsPrice += i.getValue().getPrice() * i.getValue().getQuantity();
		}
		if(money < getProductsPrice){
			System.out.println("You dont have enough money");
		}
		else{
			shop.setMoney(shop.getMoney() + getProductsPrice);
			money -= getProductsPrice;
		}
	}
}
