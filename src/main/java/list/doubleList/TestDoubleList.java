package list.doubleList;

public class TestDoubleList {

	public static void main(String[] args) {
        DoubleLinkedList doublyLinkedList = new DoubleLinkedList();
        doublyLinkedList.add("宋江", "及時雨");
        doublyLinkedList.add("盧俊義", "玉麒麟");
        doublyLinkedList.add("吳用", "智多星");
        doublyLinkedList.add("林沖", "豹子頭");
        Node newNode = new Node(2, "司馬懿","仲達");
        doublyLinkedList.update(newNode);
        doublyLinkedList.insertAt("王維", "詩佛",2);
        doublyLinkedList.reSort();
        doublyLinkedList.list();
        System.out.println(doublyLinkedList.toString());
	}
}
