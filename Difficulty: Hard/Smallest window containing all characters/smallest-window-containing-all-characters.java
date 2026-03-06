class Solution {
    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        int[] freq = new int[256];
        for (char c : p.toCharArray()) {
            freq[c]++;
        }
        int left = 0;
        int count = p.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (freq[c] > 0) count--;
            freq[c]--;
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}