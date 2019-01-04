
public class AVLTree {
	Node root = null;
	
	public void insert(Node n) {
		if(root == null)
			root = n;
		else
			root = insert(n, root);
	}
	
	public Node insert(Node n, Node current) {
		if(current == null)
			return n;
		
		if(n.key < current.key)
			current.left = insert(n, current.left);
		else if(n.key > current.key)
			current.right = insert(n, current.right);
		
		return balance(current);
	}
	
	private Node balance(Node n) {
		if(n == null)
			return n;
		
		if(height(n.left) - height(n.right) > 1) {
			if(height(n.left.left) >= height(n.left.right))
				n = rotateWithLeftChildCase1(n);
			else
				n = doubleWithLeftChildCase2(n);
		} else if(height(n.right) - height(n.left) > 1){
			if(height(n.right.right) >= height(n.right.left))
				n = rotateWithRightChildCase4(n);
			else
				n = doubleWithRightChildCase3(n);
		}
			
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		return n;
	}
	
	public int height(Node n) {
		if ( n == null)
			return -1;
		else
			return n.height;
	}
	
	private Node efficientDblRotRightLeft(Node k3){
		Node k1 = k3.left;
		Node k2 = k1.right;
		
		k1.right = k2.left;
		k3.left = k2.right;
		k2.left = k1;
		k2.right = k3;
		
		k1.height = Math.max(k1.left.height,k1.right.height) + 1;
		k2.height = Math.max(k1.left.height,k3.right.height) + 1;
		k3.height = Math.max(k3.left.height,k3.right.height) + 1;
		
		return k2;
	}
	
	private Node efficientDblRotLeftRight(Node k1){
		Node k3 = k1.right;
		Node k2 = k3.left;
		
		k1.right = k2.left;
		k3.left = k2.right;
		k2.left = k1;
		k2.right = k3;
		
		k1.height = Math.max(k1.left.height,k1.right.height) + 1;
		k2.height = Math.max(k1.left.height,k3.right.height) + 1;
		k3.height = Math.max(k3.left.height,k3.right.height) + 1;
		
		return k2;
	}
	
	private Node rotateWithLeftChildCase1(Node k2){
		Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		return k1;
	}
	
	private Node rotateWithRightChildCase4(Node k1) {
		Node k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		return k2;
	}
	
	private Node doubleWithLeftChildCase2(Node k3){
		k3.left = rotateWithRightChildCase4(k3.left);
		return rotateWithLeftChildCase1(k3);
	}
	
	private Node doubleWithRightChildCase3(Node k3){
		k3.right = rotateWithLeftChildCase1(k3.right);
		return rotateWithRightChildCase4(k3);
	}
	
	public void remove(Node x){
		if(root == null)
			return;
		else
			root = remove(x, root);
	}
	
	public Node remove(Node x, Node current){
		if(current == null)
			return current;
		
		if(x.key < current.key)
			current.left = remove(x, current.left);
		else if(x.key > current.key)
			current.right = remove(x, current.right);
		else if(current.left != null && current.right != null){
			// has both children:
			current.data = findMin(current.right).data;
			current.key = findMin(current.right).key;
			current.right = remove(current, current.right);
		} else
			current = (current.left != null) ? current.left : current.right;
		return balance(current);
	}
	
	public Node findMin(Node current){
		while(current.left != null)
			current = current.left;
		return current;
	}
	
	public String toString() {
		if (root == null)
			return "";
		return toString(root);
	}

	public String toString(Node n) {
		String output = "";
		output = String.valueOf(n.key) + " ";
		if (n.left != null)
			output += n.left.key + " ";
		else
			output += "\t";
		if (n.right != null)
			output += n.right.key + "\n";

		output += "\n";

		if (n.left != null)
			output += toString(n.left);
		if (n.right != null)
			output += toString(n.right);
		return output;
	}
	

		
	
	
	
	
	
	
}





