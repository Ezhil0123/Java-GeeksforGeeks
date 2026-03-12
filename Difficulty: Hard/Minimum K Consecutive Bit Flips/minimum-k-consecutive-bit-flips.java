class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int n = arr.length;
        int[] isFlipped = new int[n];
        int flipCount = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(i >= k)
                flipCount ^= isFlipped[i - k];
            if((arr[i] ^ flipCount) == 0) {
                if(i + k > n)
                    return -1;
                isFlipped[i] = 1;
                flipCount ^= 1;
                ans++;
            }
        }
        return ans;
    }
}
