package linkedStructure;

public class Node {
	int item;
	Node next;

	Node(int data) {
		this.item = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [item=" + item + ", next=" + next + "]";
	}
	

}