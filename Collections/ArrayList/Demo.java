
public class Demo {

	public static void main(String[] args) {
		ArrayList<Integer> zaki = new ArrayList<>();
		zaki.add(5);
		zaki.add(2);
		zaki.add(7);
		zaki.add(8);
		for(int i = 0; i < 40; i++){
			zaki.add(i);
		}
		
		
		System.out.println(zaki);
		zaki.add(4, 111111);
		zaki.add(0,5555);
		System.out.println(zaki);
		
		System.out.println(zaki.size());
		zaki.add(zaki.size(), 999999);
		System.out.println(zaki);
		
		zaki.remove(5);
		System.out.println(zaki);
		
		zaki.removeAll(2);
		System.out.println(zaki);
		zaki.removeAt(8);
		zaki.removeAt(zaki.size());
		System.out.println(zaki);
		
		ArrayList<Integer> pesho = zaki.clone();
		pesho.add(333333);
		System.out.println(pesho);
		System.out.println(zaki);
		
		pesho.clear();
		System.out.println(pesho);
		pesho.add(5);
		System.out.println(pesho);
		System.out.println(pesho.contains(5));
		System.out.println(pesho.contains(5555));
	}

}
