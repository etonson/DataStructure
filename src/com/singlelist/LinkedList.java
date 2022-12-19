package com.singlelist;

public class LinkedList {
	private Node first;

	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		obj.addLast(40);
		obj.addLast(50);
		obj.addLast(60);
		obj.show();
	}

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
			System.out.println(String.format("串列中沒有結點 [%d] ", special));
		} else {
			Node newNode = new Node(data);
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}

	public void insertAt(int data, int pos) {
		Node newNode;
		if (pos == 1) {
			addHead(data);
		} else {
			Node currentNode = first;
			for (int j = 1; j < pos - 1 && currentNode != null; j++) {
				currentNode = currentNode.next;
				if (currentNode == null) {
					System.out.println(String.format("只有位置<%d>可插入", j));
				} else {
					newNode = new Node(data);
					newNode.next = currentNode.next;
					currentNode.next = newNode;
				}
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
		Node currentNode = first;
		if (first == null) {
			System.out.println("串列是空的!");
		} else if (first.next == null) {
			first = null;
		} else {
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = null;
		}
	}

	public void removeAt(int data) {
		if (first == null) {
			System.out.println("串列是空的");
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
				System.out.println(String.format("無此節點<%d>可插入", data));
			} else {
				ptr.next = ptr.next.next;
			}
		}
	}

	public void show() {
		Node ptr = first;
		if (ptr == null) {
			System.out.println("鏈結串列為空");
			System.out.println(1);
			return;
		}
		while (ptr != null) {
			System.out.println(ptr);
			ptr = ptr.next;
		}
	}
}
