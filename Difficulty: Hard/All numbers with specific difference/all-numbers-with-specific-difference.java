class Solution {
    public int getCount(int n, int d) {
        // code here
        int l =1;
        int r= n;
        int first=-1;
        while(l<=r){
            int mid= l+(r-l)/2;
            int temp= sum(mid);
            if((mid-temp)>=d){
                first=mid;
                r=mid-1;
            }
            else{
               l=mid+1;
        }
        }
        if(first!=-1){
            return n-first+1;
        }
        return 0;
    }
    int sum( int mid){
        int add=0;
        while(mid!=0){
            add= add+mid%10;
            mid = mid/10;
        }
        return add;
    }
}

