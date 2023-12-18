package list.doubleList;

import java.util.HashMap;
import java.util.Map;

public class Example {

	public static void main(String[] args) {
		String[] strArray = { "M","C", "M", "L", "X", "X", "X", "V", "I", "I", "I" };
		int[] intArray = transArray(strArray);
		int result = getNumber(intArray);
		System.out.println(result);
	}

	static int[] transArray(String[] array) {
		Map<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		int[] resultArray = new int[array.length];
		int i = 0;
		for (String str : array) {
			resultArray[i] = map.get(str);
			i++;
		}
		return resultArray;
	}

	static int getNumber(int[] array) {
		int result = array[array.length - 1];
		for (int i = array.length - 1; i > 0; i--) {
			int num1 = array[i];
			int num2 = array[i - 1];
			System.out.println("array["+i+"]=" + array[i] + "....array["+(i-1)+"]=" + array[i - 1]);
			if (num1 <= num2) {
				result = result + num2 ;
			}  else {
				result = result - num2 ;
			}
			System.out.println("result=" + result);
		}
		return result;
	}
}
