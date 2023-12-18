package list.doubleList;

public class TestDoubleList {

	public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add("宋江", "及時雨");
        doublyLinkedList.add("盧俊義", "玉麒麟");
        doublyLinkedList.add("吳用", "智多星");
        doublyLinkedList.add("林沖", "豹子頭");
        doublyLinkedList.delete(2);
        doublyLinkedList.list();
	}
}
