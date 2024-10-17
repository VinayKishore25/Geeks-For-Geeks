//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        // code here
        Node[] arr = new Node[2];
        if(head == null)
        {
            return arr;
        }
        if(head.next == null)
        {
            arr[0] = head;
            return arr;
        }
        Node head1 = head;
        Node head2 = head.next;
        Node p1 = head1;
        Node p2 = head2;
        while(p2.next !=null && p1.next != null)
        {
            p1.next = p2.next;
            p1 = p2.next;
            if(p1.next == null)
            {
                break;
            }
            p2.next = p1.next;
            p2 = p1.next;
        }
        p1.next = null;
        p2.next = null;
        arr[0] = head1;
        arr[1] = head2;
        return arr;
    }
}
