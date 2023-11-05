package linkedStructure;



public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		Node n1 = new Node(0);
		l1.first = n1;
		l1.addLast(5);
		l1.addLast(10);
		l1.addLast(15);
		l1.addLast(20);
//		l1.insertBehind(200, 15);
		System.out.println(l1.toString());
	}
}
