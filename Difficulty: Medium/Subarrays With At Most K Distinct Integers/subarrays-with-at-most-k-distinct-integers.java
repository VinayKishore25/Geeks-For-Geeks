class Solution {
    public int countAtMostK(int nums[], int k) {
        // code here
        int i = 0 , j = 0 , n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        while(j < n){
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
            while(hm.size() > k && i <= j){
                hm.put(nums[i],hm.getOrDefault(nums[i],0) - 1);
                if(hm.get(nums[i]) == 0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            if(hm.size() <= k){
                ans += (j - i + 1);
                j++;
            }
            
        }
        return ans;
    }
}
