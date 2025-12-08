package context;

import java.util.HashMap;

public class DataContext {

    private static final HashMap<String, Object> testData = new HashMap<>();

    public static void saveData(String key, Object value) {
        testData.put(key, value);
    }

    public static <T> T getData(String key, Class<T> valueType) {
        if (checkKeyPresence(key)) {
            Object value = testData.get(key);
            if (valueType.isInstance(value)) {
                return valueType.cast(value);
            } else {
                throw new ClassCastException("Data type mismatch for key: " + key);
            }
        } else {
            throw new RuntimeException("There is no value stored on key: " + key);
        }
    }

    public static boolean checkKeyPresence(String key) {
        return testData.containsKey(key);
    }

    public static void clearContext() {
        testData.clear();
    }
}
