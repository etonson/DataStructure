package com.singlelist;

public class LinkedList {
	private Node first;

	public void addLast(int value) {
		Node current, newNode;
		newNode = new Node(value);
		if (first == null) {
			first = newNode;
		} else {
			current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void addHead(int value) {
		Node newNode = new Node(value);
		newNode.next = first;
		first = newNode;
	}

	public void insertBehind(int data, int special) {
		Node currentNode = first;
		while (currentNode != null) {
			if (currentNode.item == special) {
				break;
			}
			currentNode = currentNode.next;
		}
		if (currentNode == null) {
			System.out.println(String.format("��C���S�����I [%d] ", special));
		} else {
			Node newNode = new Node(data);
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}

	public void insertAt(int data, int pos) {
		Node newNode;
		int j;
		if (pos == 1) {
			addHead(data);
		} else {
			Node ptr = first;
			for (j = 1; j < pos - 1 && ptr != null; j++) {
				ptr = ptr.next;
			}
			if (ptr == null) {
				System.out.println(String.format("�u�� [%d] �i���J", j));
			} else {
				newNode = new Node(data);
				newNode.next = ptr.next;
				ptr.next = newNode;
			}
		}
	}

	public void removeFirst() {
		if (first == null) {
			return;
		}
		first = first.next;
	}

	public void removeLast() {
		Node ptr = first;
		if (first == null) {
			System.out.println("��C�O�Ū�!");
		} else if (first.next == null) {
			first = null;
		} else {
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = null;
		}
	}

	public void removeAt(int data) {
		if (first == null) {
			System.out.println("��C�O�Ū�!");
		}
		if (first.item == data) {
			first = first.next;
		} else {
			Node ptr = first;
			while (ptr.next != null) {
				if (ptr.next.item == data) {
					break;
				}
				ptr = ptr.next;
			}
			if (ptr.next == null) {
				System.out.println(String.format("��C�L���`�I[%d]", data));
			} else {
				ptr.next = ptr.next.next;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		System.out.println(list.first.item);
	}
}
