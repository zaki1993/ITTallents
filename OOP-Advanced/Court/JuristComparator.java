import java.util.Comparator;

public class JuristComparator implements Comparator<Jurist>{

	@Override
	public int compare(Jurist o1, Jurist o2) {
		return o1.getName().compareTo(o2.getName())*-1;
	}

}
