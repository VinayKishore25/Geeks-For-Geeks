

//User function Template for Java
class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node p = null , q = new Node(data);
        if(head == null)
        {
            q.next=q;
            return q;
        }
        if(head.data >= data)
        {
            q.next = head;
            Node temp = head;
            while(temp.next!=head)
            {
                temp = temp.next;
            }
            temp.next = q;
            return q;
        }
        Node temp1 = head;
        while(temp1.next!= head && temp1.next.data<data)
        {
            temp1 = temp1.next;
        }
        q.next = temp1.next;
        temp1.next = q;
        return head;
    }
}