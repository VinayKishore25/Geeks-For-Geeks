class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = arr.length;
        for(int i = 0 ; i < k ; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
        }
        int currSize = hm.size();
        al.add(currSize);
        for(int i = k ; i < n  ; i++){
            hm.put(arr[i-k],hm.get(arr[i-k]) - 1);
            if(hm.get(arr[i-k]) == 0){
                hm.remove(arr[i-k]);
            }
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
            currSize = hm.size();
            al.add(currSize);
        }
        return al;
    }
}