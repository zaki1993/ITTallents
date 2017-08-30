import java.util.ArrayList;
import java.util.LinkedList;

public class HashSet<T> {
	private ArrayList<LinkedList<T>> data;
	private int limit;
	private int size;
	public HashSet() {
		this(7);
	}
	
	public HashSet(int limit) {
		this.limit = limit;
		this.data = new ArrayList<>(this.limit);
		this.size = 0;
		for(int i = 0; i < limit; i++){
			data.add(new LinkedList<>());
		}
	}
	
	private boolean isPrime(int number){
		for(int i = 2; i < number; i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}
	
	private int findNextPrime(int currentLimit){
		while(!isPrime(++currentLimit)){
			//find the prime number
		}
		return currentLimit;
	}
	
	private void resize(){
		int oldLimit = this.limit;
		this.limit = findNextPrime(this.limit);
		HashSet<T> temp = new HashSet<>(this.limit);
		for(int i = 0; i < oldLimit; i++){
			LinkedList<T> toAdd = this.data.get(i);
			if(!toAdd.isEmpty()){
				for(int j = 0; j < toAdd.size(); j++){
					temp.add(toAdd.get(j));
				}
			}	
		}
		this.data = temp.toArray();
		temp = null;
	}
	
	public boolean contains(T value){
		int idx = value.hashCode() % this.limit;
		LinkedList<T> temp = data.get(idx);
		for(int i = 0; i < temp.size(); i++){
			if(temp.get(i).equals(value)){
				return true;
			}
		}
		return false;
	}
	
	public boolean add(T value){
		int idx = value.hashCode() % this.limit;
		if(data.get(idx).isEmpty()){
			data.get(idx).add(value);
		}
		else{
			for(int i = 0; i < data.get(idx).size(); i++){
				if(data.get(idx).get(i).equals(value)){
					return false;
				}
			}
			data.get(idx).add(value);
		}
		this.size++;
		if(this.size >= limit * 75 / 100){
			resize();
		}
		return true;
	}
	
	public boolean remove(T value){
		if(value == null){
			return false;
		}
		int idx = value.hashCode() % this.limit;
		if(data.get(idx).isEmpty()){
			return false;
		}
		data.get(idx).remove(value);
		this.size--;
		return true;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public String toString() {
		String result = "[";
		int counter = 0;
		for(int i = 0; i < limit; i++){
			LinkedList<T> temp = data.get(i);
			if(!temp.isEmpty()){
				counter++;
				result += "{";
				for(int j = 0; j < temp.size(); j++){
					result += temp.get(j);
					if(j < temp.size() - 1){
						result += ", ";
					}
				}
				result += "}";
				if(counter < size){
					result += ", ";
				}
			}
		}
		result += "]";
		return result;
	}

	public ArrayList<LinkedList<T>> toArray(){
		return this.data;
	}
}
