import java.util.HashMap;

public abstract class AComparable{
	private Library.Types type;
	public AComparable(Library.Types type) {
		super();
		this.type = type;
	}
	Library.Types getType(){
		return type;
	}
	
}
