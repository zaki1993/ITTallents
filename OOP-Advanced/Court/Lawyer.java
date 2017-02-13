
public class Lawyer extends Jurist{

	public Lawyer(String name, int experience, int countCase) {
		super("Lawyer", name, experience, countCase >= 10 ? countCase : 10, "");
	}

}
