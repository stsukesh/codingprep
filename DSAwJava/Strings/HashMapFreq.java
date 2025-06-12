import java.util.HashMap;
import java.util.Map;

public class HashMapFreq {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String s = "aabbaac";

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1); // increment existing
            } else {
                map.put(key, 1); // new key
            }
        }

        // Print frequency map
//         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//             System.out.println(entry.getKey() + " -> " + entry.getValue());
//         }

          char temp='x';
          System.out.println(map.get(temp));//returns the keys frequency
    }
}
