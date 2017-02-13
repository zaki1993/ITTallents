
public class Judge extends Jurist{

	public Judge(String name, int experience, int countCase) {
		super("Judge", name, experience >= 5 ? experience : 5, countCase, "");
	}

}
