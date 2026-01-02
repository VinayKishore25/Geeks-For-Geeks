class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();
        int maxValue = 0;
        for(int i = 0 ; i < n ; i++){
            int squared = arr[i] * arr[i];
            hs.add(squared);
            maxValue = Math.max(maxValue,squared);
        }
        for(int i = 0 ; i < n ; i++){
            int squared = arr[i] * arr[i];
            for(int j = 1 ; j <= Math.max(1,maxValue-squared); j++){
                if(hs.contains(squared + j) && hs.contains(j)){
                    return true;
                }
            }
        }
        return false;
    }
}