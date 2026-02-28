class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = m - 1;
        int a = 0;
        int b = 0;
        int minDiff = Integer.MAX_VALUE;
        while(i < n && j >= 0){
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum-x);
            if(diff < minDiff){
                minDiff = diff;
                a = arr1[i];
                b = arr2[j];
            }
            if(sum > x){
                j--;
            }
            else{
                i++;
            }
        }
        result.add(a);
        result.add(b);
        return result;
    }
}