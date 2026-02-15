class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        int minidiff = Integer.MAX_VALUE;
        
        Collections.sort(arr);
        int i=0, j=m-1;
        
        while(j<n){
            
            minidiff = Math.min((arr.get(j) - arr.get(i)), minidiff);
            
            i++;
            j++;
        }
        
        return minidiff;
    }
}