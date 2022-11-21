package src.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestMap {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("id", 123);
		obj.put("name", "eton");
		JSONObject obj1 = new JSONObject();
		obj1.put("id", 123);
		obj1.put("name", "jack");
		List<JSONObject> list = new ArrayList<JSONObject>();
		list.add(obj1);
		list.add(obj);
		JSONArray listArray = new JSONArray();
		
		list.stream().forEach(listArray::put);
		System.out.println(listArray.toString());
	}
}
