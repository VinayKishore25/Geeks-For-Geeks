/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Node temp1 = head1;
        Node temp2 = head2;
        Node res1 = head1;
        Node res2 = head2;
        int count1 = 0 , count2 = 0;
        while(temp1 != null){
            count1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            count2++;
            temp2 = temp2.next;
        }
        while(count1 > count2){
            count1--;
            res1 = res1.next;
        }
        while(count2 > count1){
            count2--;
            res2 = res2.next;
        }
        while(res1 != res2){
            res1 = res1.next;
            res2 = res2.next;
        }
        return res1;
    }
}