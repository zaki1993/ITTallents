
public class BSTree<T> {
	private class Node{
		private Node m_left;
		private Node m_right;
		private T m_value;
		Node(T value, Node left, Node right){
			this.m_value = value;
			this.m_left = left;
			this.m_right = right;
		}
		
		T getValue(){
			return this.m_value;
		}
		
		Node getLeft(){
			return this.m_left;
		}
		
		Node getRight(){
			return this.m_right;
		}
		
		void setLeft(Node toSet){
			this.m_left = toSet;
		}
		
		void setRight(Node toSet){
			this.m_right = toSet;
		}
	};
	
	private Node m_root;
	private int m_size;
	BSTree(){
		m_root = null;
		this.m_size = 0;
	}
	
	private void preOrderPrivate(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.getValue() + " ");
		preOrderPrivate(root.getLeft());
		preOrderPrivate(root.getRight());
	}
	
	private void postOrderPrivate(Node root){
		if(root == null){
			return;
		}
		postOrderPrivate(root.getLeft());
		postOrderPrivate(root.getRight());
		System.out.print(root.getValue() + " ");
	}
	
	private void inOrderPrivate(Node root){
		if(root == null){
			return;
		}
		inOrderPrivate(root.getLeft());
		System.out.print(root.getValue() + " ");
		inOrderPrivate(root.getRight());
	}
	
	private void removeRootPrivate(){
		if(m_root.getLeft() == null && m_root.getRight() == null){
			m_root = null;
		}
		else if(m_root.getLeft() == null){
			m_root = m_root.getRight();
		}
		else{
			Node right = m_root.getRight();
			Node left = m_root.getLeft();
			Node mostLeft = right;
			if(right != null){
				while(mostLeft.getLeft() != null){
					mostLeft = mostLeft.getLeft();
				}
				mostLeft.setLeft(left);
				m_root.setLeft(null);
				m_root = right;
			}
			else{
				m_root = left;
			}
		}
		this.m_size--;
	}
	
	public void add(T value){
		if(contains(value)){
			return;
		}
		if(m_root == null){
			m_root = new Node(value, null, null);
			this.m_size++;
			return;
		}
		Node copy = m_root;
		while(true){
			if(value.hashCode() - copy.getValue().hashCode() < 0){
				if(copy.getLeft() == null){
					copy.setLeft(new Node(value, null, null));
					this.m_size++;
					return;
				}
				else{
					copy = copy.getLeft();
				}
			}
			else{
				if(copy.getRight() == null){
					copy.setRight(new Node(value, null, null));
					return;
				}
				else{
					copy = copy.getRight();
				}				
			}
		}
	}
	
	public boolean contains(T value){
		Node copy = m_root;
		while(copy != null){
			if(copy.getValue().equals(value)){
				return true;
			}
			if(value.hashCode() - copy.getValue().hashCode() < 0){
				copy = copy.getLeft();
			}
			else{
				copy = copy.getRight();
			}
		}
		return false;
	}
	
	public boolean remove(T value){
		if(!contains(value)){
			return false;
		}
		Node copy = m_root;
		if(copy.getValue().hashCode() - value.hashCode() == 0){
			removeRootPrivate();
			return true;
		}
		Node left = null;
		Node right = null;
		boolean toDeleteLeft = false;
		//find the node to delete
		while(true){
			if(copy.getLeft().getValue().hashCode() - value.hashCode() == 0){
				left = copy.getLeft().getLeft();
				right = copy.getLeft().getRight();
				toDeleteLeft = true;
				break;
			}
			if(copy.getRight().getValue().hashCode() - value.hashCode() == 0){
				left = copy.getRight().getLeft();
				right = copy.getRight().getRight();
				break;
			}
			if(copy.getValue().hashCode() - value.hashCode() > 0){
				copy = copy.getLeft();
			}
			else{
				copy = copy.getRight();
			}
		}
		if(right == null && left == null){
			if(toDeleteLeft){
				copy.setLeft(null);
			}
			else{
				copy.setRight(null);
			}
		}
		else if(right == null){
			copy.setRight(left);
		}
		else if(left == null){
			copy.setRight(right);
		}
		else{
			Node mostLeft = right;
			while(mostLeft.getLeft() != null){
				mostLeft = mostLeft.getLeft();
			}
			mostLeft.setLeft(left);
			if(toDeleteLeft){
				copy.setLeft(right);
			}
			else{
				copy.setRight(right);
			}
		}
		this.m_size--;
		return true;
	}
	
	public int size(){
		return m_size;
	}
	
	public void preOrderTraversal(){
		Node copy = m_root;
		System.out.print("{ ");
		preOrderPrivate(copy);
		System.out.println("}");
	}
	
	public void postOrderTraversal(){
		Node copy = m_root;
		System.out.print("{ ");
		postOrderPrivate(copy);
		System.out.println("}");
	}
	
	public void inOrderTraversal(){
		Node copy = m_root;
		System.out.print("{ ");
		inOrderPrivate(copy);
		System.out.println("}");
	}
}
