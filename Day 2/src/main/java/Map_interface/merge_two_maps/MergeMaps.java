package Map_interface.merge_two_maps;


import java.util.*;

class MergeMaps {
    public static Map<String, Integer> merge(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            // If key exists, add values; otherwise, put new key-value pair
            if (merged.containsKey(key)) {
                merged.put(key, merged.get(key) + value);
            } else {
                merged.put(key, value);
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);
        System.out.println(merge(map1, map2)); // Output: {A=1, B=5, C=4}
    }
}
