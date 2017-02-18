import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		BSTree<Double> zaki = new BSTree<>();
		zaki.add(5d);
		zaki.add(7d);
		zaki.add(6d);
		zaki.add(4d);
		zaki.add(8d);
		System.out.println(zaki.contains(77d));
		System.out.println(zaki.contains(5d));
		System.out.println(zaki.contains(7d));
		zaki.preOrderTraversal();
		zaki.postOrderTraversal();
		zaki.inOrderTraversal();
		
		zaki.remove(5d);
		zaki.remove(7d);
		zaki.remove(8d);
		zaki.remove(6d);
		zaki.remove(4d);
		zaki.preOrderTraversal();
		zaki.add(5d);
		zaki.add(7d);
		zaki.add(6d);
		zaki.add(4d);
		zaki.add(8d);
		zaki.preOrderTraversal();

		zaki.remove(99d);
		zaki.preOrderTraversal();
		zaki.remove(5d);
		zaki.preOrderTraversal();
		System.out.println(zaki.count());
		System.out.println(zaki.height());
		System.out.println(zaki.count());
		zaki.add(9d);
		zaki.add(7.5d);
		zaki.add(6.5d);
		System.out.println(zaki.width()); // ok
		zaki.preOrderTraversal();
		ArrayList<Double> kLayer = zaki.getKLayer(2);
		System.out.println(zaki.height());
		System.out.println(kLayer);
		System.out.println(zaki.getLeafs());
		System.out.println(zaki.getNonLeafs());
	}
}
