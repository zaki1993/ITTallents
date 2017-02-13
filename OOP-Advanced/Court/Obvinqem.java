import java.util.HashSet;

public class Obvinqem extends Citizen{
	HashSet<Lawyer> lawyers;
	public Obvinqem(String name, String address, int age) {
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
