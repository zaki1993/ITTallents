
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
		System.out.print(root.m_value + " ");
		preOrderPrivate(root.m_left);
		preOrderPrivate(root.m_right);
	}
	
	private void postOrderPrivate(Node root){
		if(root == null){
			return;
		}
		postOrderPrivate(root.m_left);
		postOrderPrivate(root.m_right);
		System.out.print(root.m_value + " ");
	}
	
	private void inOrderPrivate(Node root){
		if(root == null){
			return;
		}
		inOrderPrivate(root.m_left);
		System.out.print(root.m_value + " ");
		inOrderPrivate(root.m_right);
	}
	
	private void removeRootPrivate(){
		if(m_root.m_left == null && m_root.m_right == null){
			m_root = null;
		}
		else if(m_root.m_left == null){
			m_root = m_root.m_right;
		}
		else{
			Node right = m_root.m_right;
			Node left = m_root.m_left;
			Node mostLeft = right;
			if(right != null){
				while(mostLeft.m_left != null){
					mostLeft = mostLeft.m_left;
				}
				mostLeft.m_left = left;
				m_root.m_left = null;
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
			if(value.hashCode() - copy.m_value.hashCode() < 0){
				if(copy.m_left == null){
					copy.m_left = new Node(value, null, null);
					this.m_size++;
					return;
				}
				else{
					copy = copy.m_left;
				}
			}
			else{
				if(copy.m_right == null){
					copy.m_right = new Node(value, null, null);
					this.m_size++;
					return;
				}
				else{
					copy = copy.m_right;
				}				
			}
		}
	}
	
	public boolean contains(T value){
		Node copy = m_root;
		while(copy != null){
			if(copy.m_value.equals(value)){
				return true;
			}
			if(value.hashCode() - copy.m_value.hashCode() < 0){
				copy = copy.m_left;
			}
			else{
				copy = copy.m_right;
			}
		}
		return false;
	}
	
	public boolean remove(T value){
		if(!contains(value)){
			return false;
		}
		Node copy = m_root;
		if(copy.m_value.hashCode() - value.hashCode() == 0){
			removeRootPrivate();
			return true;
		}
		Node left = null;
		Node right = null;
		boolean toDeleteLeft = false;
		//find the node to delete
		while(true){
			if(copy.m_left.m_value.hashCode() - value.hashCode() == 0){
				left = copy.m_left.m_left;
				right = copy.m_left.m_right;
				toDeleteLeft = true;
				break;
			}
			if(copy.m_right.m_value.hashCode() - value.hashCode() == 0){
				left = copy.m_right.m_left;
				right = copy.m_right.m_right;
				break;
			}
			if(copy.m_value.hashCode() - value.hashCode() > 0){
				copy = copy.m_left;
			}
			else{
				copy = copy.m_right;
			}
		}
		if(right == null && left == null){
			if(toDeleteLeft){
				copy.m_left = null;
			}
			else{
				copy.m_right = null;
			}
		}
		else if(right == null){
			copy.m_right = left;
		}
		else if(left == null){
			copy.m_right = right;
		}
		else{
			Node mostLeft = right;
			while(mostLeft.m_left != null){
				mostLeft = mostLeft.m_left;
			}
			mostLeft.m_left = left;
			if(toDeleteLeft){
				copy.m_left = right;
			}
			else{
				copy.m_right = right;
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
