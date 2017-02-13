import java.util.ArrayList;
import java.util.TreeSet;

public class Court {
	private String name;
	private String address;
	private ArrayList<Jurist> jurist;
	private ArrayList<Case> cases;
	public Court(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		jurist = new ArrayList<>();
		cases = new ArrayList<>();
	}
	
	void addJurist(Jurist newJurist){
		jurist.add(newJurist);
	}
	
	void addCase(Case newCase){
		cases.add(newCase);
	}
	
	void printInfo(){
		TreeSet<Jurist> result = new TreeSet<>(new JuristComparator());
		for(int i = 0; i < jurist.size(); i++){
			result.add(jurist.get(i));
		}
		for(Jurist i : result){
			System.out.println(i.getName() + "-" + i.getCountCase() + i.getAnswer());
		}
	}
	
}
