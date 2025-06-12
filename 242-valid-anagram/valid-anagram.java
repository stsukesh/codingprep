class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26]; // Use a single array

        // Increment for s
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        // Decrement for t
        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCounts) { // Here, 'count' is correctly the VALUE
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}