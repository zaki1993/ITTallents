import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class SchoolBook extends AComparable implements Comparable<SchoolBook>, ITakable{
	public static enum Theme { MATH, HISTORY };
	private String name;
	private String author;
	private String izdatelstvo;
	private Theme theme;
	private HashMap<LocalDate, LocalDate> takes;
	public final static boolean TAKABLE = true;
	public final static double RENT_PRICE = 3;
	private final static long RENT_DAYS = 150;
	public SchoolBook(String name, String author, String izdatelstvo, Theme theme) {
		super(Library.Types.SCHOOLBOOK);
		this.name = name;
		this.author = author;
		this.izdatelstvo = izdatelstvo;
		this.theme = theme;
		takes = new HashMap<>();
	}
	
	Theme getTheme(){
		return theme;
	}
	
	String getName(){
		return name;
	}
	
	@Override
	public int compareTo(SchoolBook o) {
		if(getTheme().ordinal() - o.getTheme().ordinal() == 0){
			return getName().compareTo(o.getName());
		}
		return getTheme().ordinal() - o.getTheme().ordinal();
	}

	@Override
	public HashMap<LocalDate, LocalDate> getTakes() {
		return takes;
	}

	@Override
	public void addTake(LocalDate toAdd) {
		takes.put(toAdd, null);	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{" + name + ", " + theme + "}";
	}

	@Override
	public long getRentDays() {
		return RENT_DAYS;
	}
}
