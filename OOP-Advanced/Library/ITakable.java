import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public interface ITakable {
	public HashMap<LocalDate, LocalDate> getTakes();
	public void addTake(LocalDate rentDate);
	public long getRentDays();
}
