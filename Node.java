
public class Node {
	int key;
	double data;
	int height;
	
	Node left;
	Node right;

	public Node(int key) {
		this.key = key;
		data = -100;
	}

	public String toString() {
		return "" + key;
	}
}
