package stack;

public class StackForArray {
	public String[] stack = null;
	public int index;

	StackForArray(int arrayLength) {
		stack = new String[arrayLength];
		index = 0;
	}

	public void pushItem(String data) {
		if (index <= stack.length) {
			stack[index] = data;
			index++;
		} else {
			System.out.println("stack is full!");
		}
	}

	public void popItem() {
		if (index > 0) {
			index--;
			String str = "remove item-->[%s]";
			System.out.println(String.format(str, stack[index]));
		} else {
			System.out.println("stack is empty");
		}
	}

	public void display() {
		if (index <= 0) {
			System.out.println("stack is empty");
		} else {
			for (int i = 0; i < index; i++) {
				String str = "[%s]";
				System.out.println(String.format(str, stack[i]));
			}
		}
	}
}