package list.doubleList;

public class Node {
	public int no = 0;
	public String name;
	public String nickname;

	 Node next;
	 Node prev;

	// 構造函數
	public Node(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
		this.next = null;
		this.prev = null;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}