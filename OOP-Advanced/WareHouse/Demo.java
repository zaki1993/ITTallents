
public class Demo {

	public static void main(String[] args) {
		Shop s = new Shop("asdas", "Gosho");
		Client zaki = new Client("Zaki", s);
		while(true){
			zaki.buyProducts();
		}
	}

}
