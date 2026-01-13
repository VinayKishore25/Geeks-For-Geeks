class Solution {
    public boolean canServe(int[] arr) {
        // code here
         if(arr[0]>5) return false;
        
        int n = arr.length;
        int five_count = 1;
        int ten_count = 0;
        for(int i=1; i<n; i++){
            if(arr[i] == 5) {
                five_count += 1;
            }
            if(arr[i] == 10){
                five_count -= 1;
                ten_count += 1; 
            }
            if(arr[i] == 20){
                if(ten_count > 0) {
                    ten_count -= 1;
                }
                else{
                    five_count -= 2;
                }
                five_count -= 1;
            }
            if (five_count < 0 || ten_count<0){
                return false;
            }
        }
        return true;
    }
}