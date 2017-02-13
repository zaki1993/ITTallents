import java.util.Random;

public class NakazatelnoDelo extends Case{
	private final static int MAX_JURORS = 13;
	private int currentJurors;
	public NakazatelnoDelo(Judge judge, DeloObvinitel obvinitel, Obvinqem obvinqem) {
		super(judge, obvinitel, obvinqem);
		currentJurors = 0;
	}

	@Override
	public void addJuror(Juror newJuror) {
		if(currentJurors < MAX_JURORS){
			if(!getJurors().contains(newJuror)){
				getJurors().add(newJuror);
				currentJurors++;
			}
		}
	}

	@Override
	public void provedi() {
		getJudge().incrementCase();
		((Prokoror)getObvinitel()).incrementCase();
		for(int i = 0; i < 5;i++){
			((Prokoror)getObvinitel()).askQuestion(getObvinqem());
			for(Svidetel k : getSvideteli()){
				for (int j = 0; j < 5; j++) {
					((Prokoror)getObvinitel()).askQuestion(k);
					((Prokoror)getObvinitel()).writeAnswer(k);
				}
			}
		}
		for(Lawyer i : getObvinqem().getLawyers()){
			i.incrementCase();
			for(Svidetel k : getSvideteli()){
				for (int j = 0; j < 5; j++) {
					i.askQuestion(k);
					i.writeAnswer(k);
				}
			}
		}
		
		int votedYes = 0;
		int maxVotes = getJurors().size();
		for(Juror i : getJurors()){
			i.incrementCase();
		}
		for(int i = 0; i < maxVotes; i++){
			if(new Random().nextBoolean()){
				votedYes++;
			}
		}
		if(votedYes > maxVotes / 2){
			System.out.println("Jail for: " + (new Random().nextInt(37) + 3));
		}
		else{
			System.out.println("You are free!");
		}
	}

}
