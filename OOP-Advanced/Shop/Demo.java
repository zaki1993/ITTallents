
public class Demo {

	public static void main(String[] args) {
		Shop magazin = new Shop("Magazin", "magazina na ugula", 200);
		magazin.addProduct(new PerCount("Beer", 2, 10));
		magazin.addProduct(new PerCount("Book", 5, 10));
		magazin.addProduct(new PerCount("Chair", 20, 5));
		magazin.addProduct(new PerCount("Meat", 3, 10));
		magazin.addProduct(new PerCount("Cheese", 2, 10));
		magazin.addProduct(new PerCount("Fish", 1.5, 10));
		Buyer zaki = new Buyer(50, 10);
		zaki.setShop(magazin);
		zaki.addProduct(new PerCount("Beer", 2, 5));
	}

}
