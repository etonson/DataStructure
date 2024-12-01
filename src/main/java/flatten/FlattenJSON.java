package flatten;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/*
    @author : Eton.lin
    @description 巢狀結構之json物件攤平
    @date 2024-12-01 下午 07:58
*/
public class FlattenJSON {

    public static void main(String[] args) {
        String jsonString = """
                {
                    "id": "111",
                    "profilo": {
                        "age": 30,
                        "fireTest": {
                            "t1": "john lin",
                            "t2": 30
                        },
                        "name": "john lin"
                    }
                }
                """;

        JSONObject jsonObject = new JSONObject(jsonString);

        Map<String, Object> flattenedMap = new HashMap<>();
        flattenJSON(jsonObject, "", flattenedMap);

        JSONObject flattenedJson = new JSONObject(flattenedMap);
        System.out.println(flattenedJson.toString(4));
    }

    /*
      遞迴攤平 JSON 結構
      @param jsonObject  當前之json物件
      @param parentKey   當前鍵值
      @param flattenedMap 攤平結果
     */
    public static void flattenJSON(JSONObject jsonObject, String parentKey, Map<String, Object> flattenedMap) {

        jsonObject.keySet().forEach(key -> {
            Object value = jsonObject.get(key);
            String fullKey = parentKey.isEmpty() ? key : parentKey + "-" + key;
            if (value instanceof JSONObject) {
                flattenJSON((JSONObject) value, fullKey, flattenedMap);
            } else {
                flattenedMap.put(fullKey, value);
            }
        });
    }
}