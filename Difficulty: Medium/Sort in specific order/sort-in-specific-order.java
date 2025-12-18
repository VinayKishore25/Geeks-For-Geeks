class Solution {
    public void sortIt(int[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int[] res = new int[n];
        int i = 0 , j = n - 1;
        for(int k = n - 1 ; k >= 0 ;k--){
            if(arr[k] % 2 == 0){
                res[j--] = arr[k];
            }
            else{
                res[i++] = arr[k];
            }
        }
        for( i = 0 ; i < n ; i++){
            arr[i] = res[i];
        }
    }
}
