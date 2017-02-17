
public class Demo {
	public static void main(String[] args) {
		BSTree<Integer> zaki = new BSTree<>();
		zaki.add(5);
		zaki.add(7);
		zaki.add(6);
		zaki.add(4);
		zaki.add(8);
		System.out.println(zaki.contains(77));
		System.out.println(zaki.contains(5));
		System.out.println(zaki.contains(7));
		zaki.preOrderTraversal();
		zaki.postOrderTraversal();
		zaki.inOrderTraversal();
		
		zaki.remove(5);
		zaki.remove(7);
		zaki.remove(8);
		zaki.remove(6);
		zaki.remove(4);
		zaki.preOrderTraversal();
		zaki.add(5);
		zaki.add(7);
		zaki.add(6);
		zaki.add(4);
		zaki.add(8);
		zaki.preOrderTraversal();

		zaki.remove(99);
		zaki.preOrderTraversal();
		zaki.remove(5);
		zaki.preOrderTraversal();
	}
}
