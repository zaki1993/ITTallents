import java.time.*;
public class Demo {

	public static void main(String[] args) {
		Book x = new Book("Ime1", "Avtor1", LocalDate.of(2000, Month.APRIL, 22), "Izdatelstvo1", Book.Genre.POEM);
		Book xx = new Book("Ame1", "Avtor2", LocalDate.of(2000, Month.APRIL, 21), "Izdatelstvo2", Book.Genre.ROMAN);
		
		Magazine y = new Magazine("ime1", "izdatelstvo1", Magazine.Category.MODE, 4, LocalDate.of(1995, Month.DECEMBER, 2));
		Magazine yy = new Magazine("ime2", "izdatelstvo2", Magazine.Category.POPULAR, 5, LocalDate.of(1996, Month.DECEMBER, 2));
		
		SchoolBook z = new SchoolBook("ime1", "avtor1", "izdatelstvo1", SchoolBook.Theme.MATH);
		SchoolBook zz = new SchoolBook("ime2", "avtor2", "izdatelstvo2", SchoolBook.Theme.HISTORY);
		SchoolBook zzz = new SchoolBook("ime2", "avtor2", "izdatelstvo2", SchoolBook.Theme.HISTORY);
		
		Library sofiiska = new Library("Sofiiska biblioteka");
		sofiiska.add(x);
		sofiiska.add(xx);
		sofiiska.add(y);
		sofiiska.add(yy);
		sofiiska.add(z);
		sofiiska.add(zz);
		sofiiska.add(zzz);
		
		sofiiska.printLibrary();
		sofiiska.rent(x, LocalDate.of(2000, Month.APRIL, 22));
	}

}
