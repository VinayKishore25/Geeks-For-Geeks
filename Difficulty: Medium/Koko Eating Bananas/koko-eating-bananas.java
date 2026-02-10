class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
         int n = arr.length;
        int minTime = findMax(arr);
        int low = 0, high = minTime;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid==0){
                low = mid+1;
                continue;
            }
            if(didEatAll(arr,k,mid)){
                minTime = Math.min(minTime, mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return minTime;
    }
    int findMax(int [] arr){
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>ans) ans = arr[i];
        }
        return ans;
    }
    boolean didEatAll(int[] arr, int k, int minHours) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
            sum += ((arr[i] + minHours - 1) / minHours);
        if (sum > k) return false;
    }
    return true;
    }
}
