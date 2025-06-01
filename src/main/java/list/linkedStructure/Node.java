package list.linkedStructure;

public class Node<T> {
	public T item;
	public Node<T> next;

	public Node(T data) {
		this.item = data;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [item=" + item + ", next=" + next + "]";
	}
}