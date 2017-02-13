import java.util.HashSet;

public class Obvinitel extends Citizen implements DeloObvinitel{
	HashSet<Lawyer> lawyers;
	public Obvinitel(String name, String address, int age) {
		super(name, address, age);
		// TODO Auto-generated constructor stub
		lawyers = new HashSet<>();
	}
	void addLawyer(Lawyer newLawyer){
		lawyers.add(newLawyer);
	}
	
	HashSet<Lawyer> getLawyers(){
		return lawyers;
	}
}
