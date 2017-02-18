import java.util.ArrayList;

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
	
	private int heightPrivate(Node root){
		return root == null ? 0 : 1 + Math.max(heightPrivate(root.m_left), heightPrivate(root.m_right));
	}
	
	private int widthPrivate(Node root){
		if(root == null){
			return 0;
		}
		if(root.m_left == null || root.m_right == null){
			return 1 + widthPrivate(root.m_left) + widthPrivate(root.m_right);
		}
		return widthPrivate(root.m_left) + widthPrivate(root.m_right);
	}
	
	private void getKLayerPrivate(Node root, ArrayList<T> layer, int k){
		if(root == null){
			return;
		}
		if(k == 0){
			layer.add(root.m_value);
			return;
		}
		getKLayerPrivate(root.m_left, layer, k - 1);
		getKLayerPrivate(root.m_right, layer, k - 1);
	}
	
	private void getLeafsPrivate(Node root, ArrayList<T> leafs){
		if(root == null){
			return;
		}
		if(root.m_left == null && root.m_right == null){
			leafs.add(root.m_value);
		}
		getLeafsPrivate(root.m_left, leafs);
		getLeafsPrivate(root.m_right, leafs);
	}
	
	private void getNonLeafsPrivate(Node root, ArrayList<T> nonLeafs){
		if(root == null){
			return;
		}
		if(root.m_left != null && root.m_right != null){
			nonLeafs.add(root.m_value);
		}
		getNonLeafsPrivate(root.m_left, nonLeafs);
		getNonLeafsPrivate(root.m_right, nonLeafs);
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
	
	public int count(){
		return m_size;
	}
	
	public int height(){
		return heightPrivate(m_root);
	}
	
	public int width(){
		return 1 + widthPrivate(m_root);
	}
	
	public ArrayList<T> getKLayer(int k){
		if(k > height() || k < 0){
			return new ArrayList<T>();
		}
		ArrayList<T> result = new ArrayList<>();
		getKLayerPrivate(m_root, result, k);
		return result;
	}
	
	public ArrayList<T> getLeafs(){
		ArrayList<T> result = new ArrayList<>();
		getLeafsPrivate(m_root, result);
		return result;
	}
	
	public ArrayList<T> getNonLeafs(){
		ArrayList<T> result = new ArrayList<>();
		getNonLeafsPrivate(m_root, result);
		return result;
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
