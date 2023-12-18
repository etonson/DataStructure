package list.circularList;

public class CircularList {
	private Node first;

	public CircularList() {
		first = null;
	}

	public void display() {
		Node current;
		if (first == null) {
			System.out.println("the node value is null");
		} else {
			current = first;
			while (current != null) {
				System.out.println(current.item);
				current = current.next;
				if (current == first) {
					break;
				}
			}
			System.out.println();
		}
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = first;
		Node current = first;
		System.out.println(current.toString());
		if (first == null) {
			newNode.next = newNode;
		} else {
			while (current.next != first) {
				current = current.next;
			}
			current.next = newNode;
			first = newNode;
		}
	}

	@Override
	public String toString() {
		return "CircularList [first=" + first + "]";
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}
	
}
