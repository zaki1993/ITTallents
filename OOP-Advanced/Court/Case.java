import java.util.HashSet;

public abstract class Case {
	private Judge judge;
	private HashSet<Juror> jurors;
	private DeloObvinitel obvinitel;
	private Obvinqem obvinqem;
	private HashSet<Svidetel> svideteli;
	public Case(Judge judge, DeloObvinitel obvinitel, Obvinqem obvinqem) {
		super();
		this.judge = judge;
		this.obvinitel = obvinitel;
		this.obvinqem = obvinqem;
		this.jurors = new HashSet<>();
		this.svideteli = new HashSet<>();
	}
	
	void addSvidetel(Svidetel newSvidetel){
		svideteli.add(newSvidetel);
	}
	
	HashSet<Juror> getJurors(){
		return jurors;
	}
	
	public Judge getJudge() {
		return judge;
	}
	
	public DeloObvinitel getObvinitel(){
		return obvinitel;
	}
	
	public Obvinqem getObvinqem(){
		return obvinqem;
	}
	
	public HashSet<Svidetel> getSvideteli(){
		return svideteli;
	}
	
	public abstract void addJuror(Juror newJuror);
	public abstract void provedi();
}
