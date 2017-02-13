
public abstract class Jurist implements IJurist{

	private String position;
	private String name;
	private int experience;
	private int countCase;
	private String answers;	
	public Jurist(String position, String name, int experience, int countCase, String answers) {
		super();
		this.position = position;
		this.name = name;
		this.experience = experience;
		this.countCase = countCase;
		this.answers = answers;
	}
	
	String getName(){
		return name;
	}
	
	String getAnswer(){
		return answers;
	}
	
	int getCountCase(){
		return countCase;
	}
	
	void setCountCase(int newCount){
		if(countCase > 0){
			countCase = newCount;
		}	
	}
	
	void addAnswer(String ans){
		answers += ans + " ";
	}
	
	public void incrementCase(){
		countCase++;
	}

	@Override
	public void askQuestion(Citizen newCitizen) {
		Questions q = new Questions();
		String question = q.getQuestion();
		addAnswer(question);
	}

	@Override
	public void writeAnswer(Citizen newCitizen) {
		Answers a = new Answers();
		String ans = a.getAnswer();
		addAnswer(ans);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countCase;
		result = prime * result + experience;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jurist other = (Jurist) obj;
		if (countCase != other.countCase)
			return false;
		if (experience != other.experience)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

}
