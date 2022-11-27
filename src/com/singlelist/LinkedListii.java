package com.singlelist;

public class LinkedListii {
	private Node first;

	public void addLast(int value) {
		Node currentNode, newNode;
		newNode = new Node(value);
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
}
