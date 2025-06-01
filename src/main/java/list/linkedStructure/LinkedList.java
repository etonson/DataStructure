package list.linkedStructure;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LinkedList {
	Node<Integer> first;

	public void addLast(int value) {
		Node<Integer> currentNode, newNode;
		newNode = new Node<>(value);
		if (first == null) {
			first = newNode;
		} else {
			currentNode = first;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public void addHead(int value) {
		Node<Integer> newNode = new Node<>(value);
		newNode.next = first;
		first = newNode;
	}

	public void insertBehind(int data, int special) {
		Node<Integer> ptr = first;
		while (ptr != null) {
			if (ptr.item == special) {
				break;
			}
			ptr = ptr.next;
		}
		if (ptr == null) {
			System.out.println("串列中沒有結點");
		} else {
			Node<Integer> newNode = new Node<>(data);
			newNode.next = ptr.next;
			ptr.next = newNode;
		}

	}

	public void insertAt(int data, int pos) {
		Node<Integer> newNode;
		int j;
		if (pos == 1) {
			addHead(data);
		} else {
			Node<Integer> ptr = first;
			for (j = 1; j < pos - 1 && ptr != null; j++) {
				ptr = ptr.next;
			}
			if (ptr == null) {
				System.out.println("no node");
			} else {
				newNode = new Node<>(data);
				newNode.next = ptr.next;
				ptr.next = newNode;
			}
		}
	}

	public void removeFirst() {
		if (first == null) {
			System.out.println("no Node");
		} else {
			first = first.next;
		}
	}

	public void removeLast() {
		if (first == null) {
			System.out.println("串列是空的");
		} else if (first.next == null) {
			first = null;
		} else {
			Node<Integer> ptr = first;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = null;
		}
	}

	public void removeAt(int data) {
		if (first == null) {
			System.out.println("no Node");
		} else if (first.next == null) {
			first = null;
		} else {
			Node<Integer> ptr = first;
			while (ptr.next != null) {
				if (ptr.next.item == data) {
					break;
				}
				ptr = ptr.next;
			}
			if (ptr.next == null) {
				System.out.println("串列無節點");
			} else {
				ptr.next = ptr.next.next;
			}
		}
	}

	public void revertNode() {
		Node<Integer> previous = null, current;
		while (first != null) {
			current = first;
			first = current.next;
			current.next = previous;
			previous = current;
		}
		first = previous;
	}

	@Override
	public String toString() {
		return "LinkedList [first=" + first + "]";
	}

}
