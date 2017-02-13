import java.util.Random;

public class Answers {
	private String[] answers;
	private final static String[] HELPER = {"Bez komentar", "Iskam advokat", "Fuck you", "Hlqb", "Kartof", "Axa ok!"};
	public Answers() {
		answers = new String[100];
		for(int i = 0;i < 100;i++){
			int idx = new Random().nextInt(6);
			answers[i] = HELPER[idx] + i;
		}
	}
	String getAnswer(){
		return answers[new Random().nextInt(99)];
	}
}
