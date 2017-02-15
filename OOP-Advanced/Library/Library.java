import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Library {
	public static enum Types { BOOK, MAGAZINE, SCHOOLBOOK };
	private String name;
	private HashMap<Types, TreeSet<AComparable>> books;
	private HashMap<AComparable, HashMap<LocalDate, LocalDate>> taken;
	Library(String name){
		this.name = name;
		books = new HashMap<>();
		taken = new HashMap<>();
	}
	
	void add(AComparable toAdd){
		if(!books.containsKey(toAdd.getType())){
			books.put(toAdd.getType(), new TreeSet<>());
		}
		TreeSet<AComparable> temp = books.get(toAdd.getType());
		temp.add(toAdd);
		books.put(toAdd.getType(), temp);
	}
	
	void printLibrary(){
		for(Entry<Types, TreeSet<AComparable>> i : books.entrySet()){
			System.out.println(i.getKey() + " " + i.getValue());
		}
	}
	
	void rent(AComparable toRent, LocalDate rentDate){
		if(!taken.containsKey(toRent)){
			if(toRent instanceof ITakable){
				((ITakable)toRent).addTake(rentDate);
				long toAddDays = ((ITakable)toRent).getRentDays();
				HashMap<LocalDate, LocalDate> temp = new HashMap<>();
				temp.put(rentDate, rentDate.plusDays(toAddDays));
				taken.put(toRent, temp);
			}
			else{
				System.out.println("You cannot rent this!");
			}
		}
	}
	
	void giveBack(AComparable toRefund, LocalDate refundDate){
		if(!taken.containsKey(toRefund)){
			System.out.println("Sorry no item with this name!");
		}
		else{
			//checks with the date first
			
			taken.remove(toRefund);
			((ITakable)toRefund).getTakes().remove(toRefund);
		}
	}
}
