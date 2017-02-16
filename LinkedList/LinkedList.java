package List;

public class LinkedList<T> {
	private class Node{
		private Node next;
		private Node previous;
		private T value;
		Node(T value, Node previous, Node next){
			super();
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		public void setPrevious(Node previous) {
			this.previous = previous;
		}
		
		public boolean hasNext() {
			return !(next == null);
		}
		
		public boolean hasPrevious(){
			return !(previous == null);
		}
		
		public Node getNext() {
			return next;
		}
		
		public Node getPrevious(){
			return previous;
		}
		
		public T getValue() {
			return value;
		}
		
		public void setValue(T value) {
			this.value = value;
		}
	}
	
	private class Iterator{
		private Node current;
		Iterator(){
			Node copy = head;
			current = copy;
		}
		
		boolean hasNext(){
			return current != null;
		}
		
		void goToNext(){
			current = current.getNext();
		}
		
		T getValue(){
			return current.getValue();
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	LinkedList(){
		head = new Node(null, null, null);
		tail = head;
		this.size = 0;
	}
	
	private LinkedList(LinkedList<T> other){
		Node copy = other.find(0);
		head = new Node(null, null, null);
		tail = head;
		this.size = 0;
		while(copy.hasNext()){
			this.add(copy.getValue());
			copy = copy.getNext();
		}
	}
	
	private Node find(int index){
		int currentIndex = 0;
		Node copy = new Node(null, null, null);
		if(index <= size/2){
			copy = head;
			while(currentIndex < index){
				currentIndex++;
				copy = copy.getNext();
			}
		}
		else{
			copy = tail;
			while(currentIndex < size - index){
				currentIndex++;
				copy = copy.getPrevious();
			}
		}
		return copy;
	}
	
	public void add(T value){
		if(size != 0){
			addLast(value);
		}
		else{
			tail.setValue(value);
			this.size++;
		}
	}
	
	public void add(int index, T value){
		if(index < 0 || index > this.size){
			return;
		}
		int currentElement = 0;
		Node copy = find(index);
		//The actual adding
		Node newNode = new Node(value, null, null);
		if(copy == head){
			this.addFirst(value);
		}
		else if(copy == tail){
			this.addLast(value);
		}
		else{
			System.out.println(copy.getValue());
			newNode.setPrevious(copy);
			newNode.setNext(copy.getNext());
			copy.getNext().setPrevious(newNode);
			copy.setNext(newNode);
			this.size++;
		}
	}
	
	public void addFirst(T value){
		Node copy = head;
		Node newNode = new Node(value, null, copy);
		copy.setPrevious(newNode);
		head = newNode;
		this.size++;
	}
	
	public void addLast(T value){
		Node copy = tail;
		Node newNode = new Node(value, copy, null);
		copy.setNext(newNode);
		tail = newNode;
		this.size++;
	}
	
	public void remove(T value){
		if(!this.contains(value)){
			return;
		}
		if(size == 1){
			head = new Node(null, null, null);
			tail = head;
			size--;
			return;
		}
		int index = this.indexOf(value);
		Node toRemove = find(index);
		toRemove.getPrevious().setNext(toRemove.getNext());
		toRemove.getNext().setPrevious(toRemove.getPrevious());
		toRemove = null;
		this.size--;
	}
	
	public void removeFirst(){
		if(!head.hasNext()){
			return;
		}
		Node copy = head;
		copy = copy.getNext();
		head = copy;
		copy = null;
		this.size--;
	}
	
	public void removeLast(){
		if(!tail.hasPrevious()){
			return;
		}
		Node copy = tail;
		copy = copy.getPrevious();
		tail = copy;
		copy = null;
		this.size--;
	}
	
	public int size(){
		return this.size;
	}
	
	public T get(int index){
		if(index < 0 || index >= this.size){
			return null;
		}
		return find(index).getValue();
	}
	
	public T getFirst(){
		return head.getValue();
	}
	
	public T getLast(){
		return tail.getValue();
	}

	public boolean contains(T value){
		for(Iterator i = new Iterator();i.hasNext();i.goToNext()){
			if(i.getValue().equals(value)){
				//FUCK YOU INTEGER POOL
				//i.getValue() == value works for the first 0 to 128 numbers
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(T value){
		if(!this.contains(value)){
			return -1;
		}
		int index = 0;
		for(Iterator i = new Iterator(); i.hasNext();i.goToNext()){
			if(i.getValue().equals(value)){
				break;
			}
			index++;
		}
		return index;
	}
	
	public LinkedList<T> clone(){
		return new LinkedList<>(this);
	}
	@Override
	public String toString() {
		String result = "[";
		Node copy = head;
		for(int i = 0; i < size; i++){
			result += copy.getValue();
			copy = copy.getNext();
			if(i < size - 1){
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}
