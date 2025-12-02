package utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    public Map<String, String> flattenJsonToStringMap(Object obj) {
        Map<String, String> flatMap = new LinkedHashMap<>();
        flatten("", obj, flatMap);
        return flatMap;
    }

    private void flatten(String prefix, Object value, Map<String, String> result) {
        if (value instanceof Map) {
            for (Map.Entry<?, ?> entry : ((Map<?, ?>) value).entrySet()) {
                flatten(prefix + entry.getKey() + ".", entry.getValue(), result);
            }
        } else if (value instanceof List) {
            List<?> list = (List<?>) value;
            for (int i = 0; i < list.size(); i++) {
                flatten(prefix + "[" + i + "].", list.get(i), result);
            }
        } else {
            String formattedKey = prefix.substring(0, prefix.length() - 1).replace(".[", "[");
            result.put(formattedKey, String.valueOf(value));
        }
    }

}
