//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int n = words.length;
            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, k);
            if (order.length() == 0) {
                System.out.println("false");
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                System.out.println("~");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int k) {
        // Write your code here
        int n = dict.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[k];
        for(int i = 1 ; i < n ; i++){
            int len = Math.min(dict[i-1].length(),dict[i].length());
            String word1 = dict[i-1];
            String word2 = dict[i];
            for(int j = 0 ; j < len ; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    indegree[word2.charAt(j) - 'a']++;
                    break;
                }
            }
        }
        String ans = "";
        // System.out.println(adj);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){
            if(indegree[i] == 0){
                q.add(i);
                ans += (char)(i+'a');
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                    ans += (char)(neighbour+'a');
                }
            }
        }
        // System.out.println(ans);
        for(int i = 0 ; i < k ; i++){
            if(indegree[i] > 0){
                return "";
            }
        }
        return ans;
    }
}