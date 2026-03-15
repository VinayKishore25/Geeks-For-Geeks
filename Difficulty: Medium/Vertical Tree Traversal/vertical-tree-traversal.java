/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();

        q.add(new Object[]{root, 0});

        while(!q.isEmpty()) {

            Object[] arr = q.poll();
            Node node = (Node) arr[0];
            int hd = (int) arr[1];

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if(node.left != null)
                q.add(new Object[]{node.left, hd - 1});

            if(node.right != null)
                q.add(new Object[]{node.right, hd + 1});
        }

        return new ArrayList<>(map.values());
    }
}