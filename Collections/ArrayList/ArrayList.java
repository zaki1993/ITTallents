
public class ArrayList<T> {
	private T[] data;
	private int limit;
	private int size;
	
	private ArrayList(ArrayList<T> other){
		this.limit = other.getLimit();
		this.data = (T[]) new Object[this.limit];
		this.size = 0;
		for(int i = 0; i < other.size(); i++){
			data[this.size++] = other.get(i);
		}
	}
	
	public ArrayList(int limit){
		this.limit = limit;
		data = (T[]) new Object[this.limit];
		size = 0;
	}
	
	public ArrayList() {
		this.limit = 8;
		data = (T[]) new Object[this.limit];
		size = 0;
	}
	
	private void resizeCheck(){
		if(size >= limit){
			resize();
		}
	}
	
	private void resize(){
		this.limit *= 2;
		T[] temp = (T[]) new Object[this.limit];
		for(int i = 0; i < size; i++){
			temp[i] = data[i];
		}
		data = temp;
		temp = null;
	}
	
	public boolean contains(T value){
		for(int i = 0; i < size; i++){
			if(data[i].equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public T get(int index){
		if(index < 0 || index > size){
			return null;
		}
		return data[index];
	}
	
	public void add(T value){
		resizeCheck();
		data[size++] = value;
	}
	
	public void add(int index, T value){
		if(index < 0 || index > size){
			return;
		}
		resizeCheck();
		for(int i = size - 1 ; i >= index; i--){
			data[i + 1] = data[i];
		}
		data[index] = value;
		size++;
	}
	
	public void remove(T value){
		if(!contains(value)){
			return;
		}
		for(int i = 0; i < size; i++){
			if(data[i].equals(value)){
				for(int j = i; j < size - 1; j++){
					data[j] = data[j + 1];
				}
				data[size--] = null;
			}
		}
	}
	
	public void removeAll(T value){
		for(int i = 0; i < size; i++){
			if(data[i].equals(value)){
				remove(value);
				i--;
			}
		}
	}
	
	public void removeAt(int index){
		if(index < 0 || index > size){
			return;
		}
		for(int i = index; i < size - 1; i++){
			data[i] = data[i + 1];
		}
		data[size--] = null;
	}
	
	public int size(){
		return size;
	}
	
	public int getLimit(){
		return limit;
	}
	
	public ArrayList<T> clone(){
		return new ArrayList(this);
	}
	
	public void clear(){
		this.size = 0;
		this.data = (T[]) new Object[this.limit];
	}
	
	@Override
	public String toString() {
		String result = "[";
		for(int i = 0; i < size; i++){
			result += data[i];
			if(i < size - 1){
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}
