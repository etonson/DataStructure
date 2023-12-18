package list.doubleList;

public class DoublyLinkedList {
	Node first;
	public void list() {
		Node current = first;
		if (current.next == null) {
			System.out.println("list is null");
		} else {
			while (current != null) {
				System.out.println(current.toString());
				current = current.next;
			}
		}
	}

	public void add(String name, String nickname) {
		Node newNode = null;
		if (first == null) {
			newNode = new Node(0, name, nickname);
			first = newNode;
		} else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			newNode = new Node(current.no + 1, name, nickname);
			current.next = newNode;
			newNode.prev = current;
		}
	}

	// 刪除節點
	public void delete(int no) {
		if (first.next == null) {
			System.out.println("鏈結串列為空,無法刪除");
		} else {
			Node current = first;
			while (current != null) {
				if (current.no == no) {
					current.prev.next = current.next;
					if (current.next == null) {
						current.prev.next = null;
					}
				}
				current = current.next;
			}
		}
	}

	public Node getHead() {
		return first;
	}

	@Override
	public String toString() {
		return "DoublyLinkedList [first=" + first + "]";
	}
}