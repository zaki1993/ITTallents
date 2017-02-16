package List;

public class Demo {

	public static void main(String[] args) {
		LinkedList<Integer> zaki = new LinkedList<>();
		zaki.add(3);
		zaki.add(5);
		zaki.add(9);
		zaki.add(-4);
		for(int i = 0; i < 10; i++){
			zaki.add(i);
		}
		System.out.println(zaki.size());
		System.out.println(zaki.get(11));
		zaki.add(14, 555);
		zaki.add(0, 444);
		zaki.add(4, 222);
		zaki.addFirst(10);
		System.out.println(zaki);
		LinkedList<Integer> ivan = zaki.clone();
		ivan.add(11111);
		System.out.println(ivan);
		System.out.println(zaki);
		
		System.out.println(zaki.contains(555));
		
		Integer y = zaki.getFirst();
		y = 10000;
		System.out.println(zaki);
		System.out.println(zaki.indexOf(555));
		System.out.println(zaki.size());
		
		zaki.remove(222);
		System.out.println(zaki);
		
		zaki.removeFirst();
		zaki.removeLast();
		System.out.println(zaki);
		LinkedList<Integer> pesho = new LinkedList<>();
		pesho.removeLast();
		pesho.removeFirst();
		pesho.removeLast();
		pesho.removeFirst();
		pesho.add(5);
		System.out.println(pesho);
		pesho.remove(5);
		System.out.println(pesho);
		pesho.add(22);
		System.out.println(pesho);
	}

}
