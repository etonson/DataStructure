package list.linkedStructure;

public class Node {
	public int item;
	public Node next;

	public Node(int data) {
		this.item = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [item=" + item + ", next=" + next + "]";
	}
}