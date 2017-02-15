import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Book extends AComparable implements Comparable<Book>, ITakable{
	public static enum Genre { POEM, ROMAN };
	private String name;
	private String author;
	private LocalDate date;
	private String izdatelstvo;
	private Genre genre;
	private HashMap<LocalDate, LocalDate> takes;
	public final static boolean TAKABLE = true;
	public final static double RENT_PRICE = 2;
	private final static long RENT_DAYS = 300;
	public Book(String name, String author, LocalDate date, String izdatelstvo, Genre genre) {
		super(Library.Types.BOOK);
		this.name = name;
		this.author = author;
		this.date = date;
		this.izdatelstvo = izdatelstvo;
		this.genre = genre;
		takes = new HashMap<>();
	}
		
	Genre getGenre(){
		return genre;
	}
	
	LocalDate getDate(){
		return date;
	}
	
	@Override
	public int compareTo(Book o) {
		if(getGenre().ordinal() - o.getGenre().ordinal() == 0){
			return getDate().compareTo(o.getDate());
		}
		return getGenre().ordinal() - o.getGenre().ordinal();
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
		return "{" + name + ", " + genre + " " + date + "}";
	}

	@Override
	public long getRentDays() {
		return RENT_DAYS;
	}
	
}
