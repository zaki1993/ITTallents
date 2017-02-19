
public class LinkedList<T> {
	private class Node{
		private Node m_next;
		private Node m_previous;
		private T m_value;
		Node(T value, Node previous, Node next){
			super();
			this.m_value = value;
			this.m_previous = previous;
			this.m_next = next;
		}
		
		boolean hasNext(){
			return !(m_next == null);
		}
	}
	
	private class Iterator{
		private Node m_current;
		Iterator(){
			Node copy = m_head;
			m_current = copy;
		}
		
		boolean hasNext(){
			return m_current != null;
		}
		
		void goToNext(){
			m_current = m_current.m_next;
		}
	}
	
	private Node m_head;
	private Node m_tail;
	private int size;
	
	LinkedList(){
		m_head = null;
		m_tail = null;
		this.size = 0;
	}
	
	private LinkedList(LinkedList<T> other){
		Node copy = other.find(0);
		m_head = null;
		m_tail = m_head;
		this.size = 0;
		while(copy.hasNext()){
			this.add(copy.m_value);
			copy = copy.m_next;
		}
	}
	
	private Node find(int index){
		int currentIndex = 0;
		Node copy = new Node(null, null, null);
		if(index <= size/2){
			copy = m_head;
			while(currentIndex < index){
				currentIndex++;
				copy = copy.m_next;
			}
		}
		else{
			copy = m_tail;
			while(currentIndex < size - index){
				currentIndex++;
				copy = copy.m_previous;
			}
		}
		return copy;
	}
	
	public void add(T value){
		if(m_head == null){
			m_head = new Node(value, null, m_tail);
			m_tail = m_head;
			size++;
		}
		else{
			addLast(value);
		}
	}
	
	public void add(int index, T value){
		if(index < 0 || index > this.size){
			return;
		}
		Node copy = find(index);
		//The actual adding
		Node newNode = new Node(value, null, null);
		if(copy == m_head){
			this.addFirst(value);
		}
		else if(copy == m_tail){
			this.addLast(value);
		}
		else{
			newNode.m_previous = copy;
			newNode.m_next = copy.m_next;
			copy.m_next.m_previous = newNode;
			copy.m_next = newNode;
			this.size++;
		}
	}
	
	public void addFirst(T value){
		Node copy = m_head;
		Node newNode = new Node(value, null, copy);
		copy.m_previous = newNode;
		m_head = newNode;
		this.size++;
	}
	
	public void addLast(T value){
		Node copy = m_tail;
		Node newNode = new Node(value, copy, null);
		copy.m_next = newNode;
		m_tail = newNode;
		this.size++;
	}
	
	public void remove(T value){
		if(!this.contains(value)){
			return;
		}
		int index = this.indexOf(value);
		Node toRemove = find(index);
		if(toRemove == m_head){
			removeFirst();
		}
		else if(toRemove == m_tail){
			removeLast();
		}
		else{
			toRemove.m_previous.m_next = toRemove.m_next;
			toRemove.m_next.m_previous = toRemove.m_previous;
			toRemove = null;
			this.size--;
		}
	}
	
	public void removeFirst(){
		if(m_head == null){
			return;
		}
		if(m_head == m_tail){
			m_head = null;
			m_tail = m_head;
		}
		else{
			Node copy = m_head;
			copy = copy.m_next;
			m_head = copy;
			copy = null;
		}
		this.size--;
	}
	
	public void removeLast(){
		if(m_tail == null){
			return;
		}
		if(m_head == m_tail){
			m_head = null;
			m_tail = m_head;
		}
		else{
			Node copy = m_tail;
			copy = copy.m_previous;
			m_tail = copy;
			copy = null;
		}
		this.size--;
	}
	
	public int size(){
		return this.size;
	}
	
	public T get(int index){
		if(index < 0 || index >= this.size){
			return null;
		}
		return find(index).m_value;
	}
	
	public T getFirst(){
		return m_head.m_value;
	}
	
	public T getLast(){
		return m_tail.m_value;
	}

	public boolean contains(T value){
		for(Iterator i = new Iterator();i.hasNext();i.goToNext()){
			if(i.m_current.m_value.equals(value)){
				//FUCK YOU INTEGER POOL
				//i.m_value == value works for the first 0 to 128 numbers
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
			if(i.m_current.m_value.equals(value)){
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
		Node copy = m_head;
		for(int i = 0; i < size; i++){
			result += copy.m_value;
			copy = copy.m_next;
			if(i < size - 1){
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}