package list.doubleList;

public class DoubleLinkedList {
	Node first;
	int count = 0;
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
	public int getMaxCount() {
		Node current = first;
		while(current !=null) {
			count+=1;
			current = current.next;
		}
		return count;
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

	public void insertAt(String name, String nickName, int pos) {
		if (pos == 0) {
			Node newNode = new Node(0, name, nickName);
			newNode.next = first;
			return;
		}
		if (pos > getMaxCount() - 1) {
			Node newNode = new Node(getMaxCount() + 1, name, nickName);
			first.next = newNode;
			return;
		}
		Node current = first;
		Node newNode = new Node(pos, name, nickName);
		while (current != null) {
			current = current.next;
			if (pos == current.no) {
				break;
			}
		}
		newNode.next = current.next;
		newNode.prev = current.prev;
		current.next = newNode;
	}

	public void reSort() {
		Node current = first;
		int i = 0;
		while (current != null) {
			current.setNo(i);
			current = current.next;
			i++;
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

	// 更新節點
	public void update(Node newNode) {
		if (first.next == null) {
			System.out.println("鏈結串列為空,無法刪除");
		} else {
			Node current = first;
			while (current.next != null) {
				if (current.no == newNode.no) {
					current.name = newNode.name;
					current.nickname = newNode.nickname;
					break;
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