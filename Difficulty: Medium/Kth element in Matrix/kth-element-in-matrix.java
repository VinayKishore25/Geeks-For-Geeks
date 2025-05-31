class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // code here
        int n = matrix.length;
        List<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                al.add(matrix[i][j]);
            }
        }
        Collections.sort(al);
        return al.get(k-1);
    }
}