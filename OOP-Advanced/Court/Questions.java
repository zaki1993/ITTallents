import java.util.Random;

public class Questions {
	private String[] questions;
	private final static String[] HELPER = {"Are you guilty", "Do you sux", "Who are you", "Obichash li qice", "Do she me who ya"};
	public Questions() {
		questions = new String[100];
		for(int i = 0;i < 100;i++){
			int idx = new Random().nextInt(5);
			questions[i] = HELPER[idx] + i;
		}
	}
	String getQuestion(){
		return questions[new Random().nextInt(99)];
	}
}
