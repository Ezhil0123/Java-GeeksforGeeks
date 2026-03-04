class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k > n) return -1;
        int currentXor = 0;
        for(int i = 0; i < k; i ++){
            currentXor ^= arr[i];
        }
        int maxXor = currentXor;
        for(int i = k; i < n; i ++){
            currentXor ^= arr[i - k];
            currentXor ^= arr[i];
            maxXor = Math.max(maxXor, currentXor);
        }
        return maxXor;
    }
}
