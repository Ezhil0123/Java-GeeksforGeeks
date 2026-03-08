class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        HashSet<Long> set = new HashSet<>();
        for (int x : arr) {
            set.add((long) x * x);
        }
        for (int i = 0; i < n; i ++){
            long a1 = (long) arr[i] * arr[i];
            for (int j = i + 1; j < n; j ++){
                long b1 = (long) arr[j] * arr[j];
                if (set.contains(a1 + b1)) {
                    return true;
                }
            }
        }
        return false;
    }
}