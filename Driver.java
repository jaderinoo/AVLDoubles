
public class Driver {

	public static void main(String[] args) {
		AVLTree avl = new AVLTree();

		avl.insert(new Node(3));
		avl.insert(new Node(2));
		avl.insert(new Node(1));
		avl.insert(new Node(4));
		avl.insert(new Node(5));
		avl.insert(new Node(6));
		avl.insert(new Node(7));
		
		avl.insert(new Node(16));
		avl.insert(new Node(15));
		avl.insert(new Node(14));
		Node node13= new Node(13);
		avl.insert(node13);
		Node twelve = new Node(12);
		avl.insert(twelve);
		avl.insert(new Node(11));
		avl.insert(new Node(10));
		avl.insert(new Node(8));
		avl.insert(new Node(9));

		avl.remove(node13);
		System.out.println(avl);
	}

}
