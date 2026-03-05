class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = -1;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            if(map.size() == k){
                maxLen = Math.max(maxLen, i - left + 1);
            }
        }
        return maxLen;
    }
}