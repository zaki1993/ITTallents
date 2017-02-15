import java.time.LocalDate;
import java.util.HashMap;

public class Magazine extends AComparable implements Comparable<Magazine>{
	public static enum Category { MODE, POPULAR };
	private String name;
	private String izdatelstvo;
	private Category category;
	private int number;
	private LocalDate date;
	public final static boolean TAKABLE = false;
	public Magazine(String name, String izdatelstvo, Category category, int number, LocalDate date) {
		super(Library.Types.MAGAZINE);
		this.name = name;
		this.izdatelstvo = izdatelstvo;
		this.category = category;
		this.number = number;
		this.date = date;
	}
	
	String getName(){
		return name;
	}
	
	int getNumber(){
		return number;
	}
	
	@Override
	public int compareTo(Magazine o) {
		if(getName().compareTo(o.getName()) == 0){
			return getNumber() - o.getNumber();
		}
		return getName().compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{" + name + ", " + category + "}";
	}
}
