class Solution {
    public int findKRotation(int arr[]) {
        // Code here
         int ans=0,min = arr[0],n=arr.length;
        int low=0,high=(n-1);
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(arr[mid] < min)
            {
                min = arr[mid];
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}