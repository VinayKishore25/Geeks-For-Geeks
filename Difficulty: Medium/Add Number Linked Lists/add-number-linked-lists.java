//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        while(num1.next != null && num1.data == 0) num1 = num1.next;
        while(num2.next != null && num2.data == 0) num2 = num2.next;
        Node temp1 = reverse(num2);
        Node temp2 = reverse(num1);
        int carry = 0;
        Node ans = new Node((temp1.data+temp2.data)%10);
        Node fin = ans;
        carry = (temp1.data + temp2.data)/10;
        temp1 = temp1.next;
        temp2 = temp2.next;
        while(temp1!=null && temp2 != null)
        {
            int x = temp1.data;
            int y = temp2.data;
            int z = (x+y+carry)%10;
            carry = (x+y+carry)/10;
            ans.next = new Node(z);
            ans = ans.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1!=null) 
        {
            int z = (temp1.data + carry) %10;
            carry = (temp1.data + carry) / 10;
            ans.next = new Node(z);
            ans = ans.next;
            temp1 = temp1.next;
        }
        while(temp2!=null) 
        {
            int z = (temp2.data + carry) %10;
            carry = (temp2.data + carry) / 10;
            ans.next = new Node(z);
            ans = ans.next;
            temp2 = temp2.next;
        }
        if(carry!=0) ans.next = new Node(carry);
        Node res = reverse(fin);
        // while(res.next!=null && res.data == 0) res = res.next;
        return res;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends