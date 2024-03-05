package stack;

public class TestStackForArray {
	public static void main(String[] args) {
		StackForArray obj = new StackForArray(5);
		obj.pushItem("Mary");
		obj.pushItem("Eton");
		obj.pushItem("John");
		obj.display();
	}
}