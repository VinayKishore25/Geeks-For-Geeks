/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {

    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        Node dummy = head;
        int length = 0 ;
        while(dummy != null){
            length++;
            dummy = dummy.next;
        }
        if(length < k){
            return -1;
        }
        int lengthFromFirst = length - k ;
        dummy = head;
        while(dummy != null && lengthFromFirst > 0){
            dummy = dummy.next;
            lengthFromFirst--;
        }
        return dummy.data;
    }
}