class Solution {
    public String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] maxIndex = new int[n];
        int maxIdx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
            maxIndex[i] = maxIdx;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < arr[maxIndex[i]]) {
                char temp = arr[i];
                arr[i] = arr[maxIndex[i]];
                arr[maxIndex[i]] = temp;
                break;
            }
        }
        return new String(arr);
    }
}