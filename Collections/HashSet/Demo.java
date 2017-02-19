
public class Demo {
	public static void main(String[] args) {
		HashSet<Integer> zaki = new HashSet<>();
		zaki.add(2);
		zaki.add(5);
		for(int i = 0; i < 100; i++){
			zaki.add(i);
		}
		for(int i = 0; i < 70; i++){
			zaki.add(i);
		}
		System.out.println(zaki);
		System.out.println(zaki.size());
		System.out.println(zaki.contains(1));
		System.out.println(zaki.contains(1231231));
		
		HashSet<String> pesho = new HashSet<>();
		pesho.add("zaki");
		pesho.add("pesho");
		pesho.add("gosho");
		pesho.add("goshodd");
		pesho.add("goshodddd");
		System.out.println(pesho);
		System.out.println(pesho.size());
		System.out.println("---------------------");
		//System.out.println(zaki.isEmpty());
		System.out.println(pesho.isEmpty());
		pesho.add("zaki");
		pesho.add("gosho");
		System.out.println(pesho.size());
		System.out.println(pesho);
		pesho.remove("zaki");
		pesho.remove("gosho");
		pesho.remove("goshodd");
		pesho.remove("pesho");
		pesho.remove("goshodddd");
		pesho.remove(null);
		pesho.remove("asda");
		System.out.println(pesho + " " + pesho.size());
	}
}
