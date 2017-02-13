import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		Court sud = new Court("Veliko Tarnovo", "Ne purviq a vtoriq desen");
		Judge[] judges = new Judge[3];
		for(int i = 0; i<3;i++){
			judges[i] = new Judge("Gosho" + i, 5, 0);
			sud.addJurist(judges[i]);
		}
		
		Juror[] jurors = new Juror[10];
		for(int i = 0; i< 10;i++){
			jurors[i] = new Juror("Ivan" + i, 0, 0);
			sud.addJurist(jurors[i]);
		}
		
		Lawyer[] lawyers = new Lawyer[5];
		for(int i = 0; i< 5;i++){
			lawyers[i] = new Lawyer("Pesho" + i, 0, 10);
			sud.addJurist(lawyers[i]);
		}
		
		Prokoror[] prokorori = new Prokoror[2];
		for(int i = 0; i< 2;i++){
			prokorori[i] = new Prokoror("Mincho" + i, 10, 10);
			sud.addJurist(prokorori[i]);
		}
		
		DeloObvinitel[] obviniteli = new DeloObvinitel[5];
		for(int i = 0; i< 5;i++){
			if(new Random().nextBoolean()){
				obviniteli[i] = new Obvinitel("Yoto" + i, "Pazardjik" + i, 20);
				((Obvinitel)obviniteli[i]).addLawyer(lawyers[new Random().nextInt(lawyers.length)]);
			}
			else{
				obviniteli[i] = new Prokoror("asdad" + i, 10, 10);
				sud.addJurist((Prokoror)obviniteli[i]);
			}
		}
		
		Obvinqem[] obvinqem = new Obvinqem[5];
		for(int i = 0; i< 5;i++){
			obvinqem[i] = new Obvinqem("Kruncho" + i, "Pazardjik" + i, 20);
			obvinqem[i].addLawyer(lawyers[new Random().nextInt(lawyers.length)]);
		}
		
		Svidetel[] svideteli = new Svidetel[10];
		for(int i = 0; i< 2;i++){
			svideteli[i] = new Svidetel("Mariika" + i, "Pazardjik" + i, 20);
		}
		
		GrajdanskoDelo[] grdela = new GrajdanskoDelo[3];
		NakazatelnoDelo[] nakdela = new NakazatelnoDelo[3];
		
		for(int i = 0; i < 3; i++){
			int idx = 0;
			do{
				idx = new Random().nextInt(5);
			}while(!(obviniteli[idx] instanceof Obvinitel));
			grdela[i] = new GrajdanskoDelo(judges[new Random().nextInt(3)], obviniteli[idx], obvinqem[new Random().nextInt(2)]);
			do{
				idx = new Random().nextInt(5);
			}while(!(obviniteli[idx] instanceof Prokoror));
			nakdela[i] = new NakazatelnoDelo(judges[new Random().nextInt(3)], obviniteli[idx], obvinqem[new Random().nextInt(2)]);
		}
		for(int j = 0;j < 3;j++){
			for(int i = 0; i < jurors.length;i++){
				grdela[j].addJuror(jurors[new Random().nextInt(jurors.length)]);
				nakdela[j].addJuror(jurors[new Random().nextInt(jurors.length)]);
			}
			for(int i = 0; i < svideteli.length; i++){
				grdela[j].addSvidetel(svideteli[new Random().nextInt(svideteli.length)]);
				nakdela[j].addSvidetel(svideteli[new Random().nextInt(svideteli.length)]);
			}
			sud.addCase(grdela[j]);
			sud.addCase(nakdela[j]);
		}
		
		sud.printInfo();
		
		for(int i = 0;i< 3; i++){
			grdela[i].provedi();
			nakdela[i].provedi();
		}
		
		sud.printInfo();
		Character
	}

}
