package list.circularList;

public class TestCircularList {
	public static void main(String[] args) {
		CircularList c1 = new CircularList();
		Node n1 = new Node(0);
		c1.setFirst(n1);
		c1.addFirst(12);
		System.out.println();
	}
}
