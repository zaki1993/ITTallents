
public class Prokoror extends Jurist implements DeloObvinitel{

	public Prokoror(String name, int experience, int countCase) {
		super("Prokoror" , name, experience >= 10 ? experience : 10, countCase, "");
	}

}
