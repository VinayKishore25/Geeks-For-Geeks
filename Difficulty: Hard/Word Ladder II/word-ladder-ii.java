//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    public ArrayList<String> words;
    public int level;
    Pair(ArrayList<String> words,int level){
        this.words = words;
        this.level = level;
    }
}
class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for(String word : wordList){
            hs.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        ArrayList<String> init = new ArrayList<>();
        init.add(startWord);
        q.offer(new Pair(init,1));
        hs.remove(startWord);
        while(!q.isEmpty()){
            int x = q.size();
            HashSet<String> temp = new HashSet<>();
            // if(ans.size() > 0){
            //     return ans;
            // }
            for(int k = 0 ; k < x ; k++){
                Pair node = q.poll();
                ArrayList<String> words = node.words;
                String word = words.get(words.size() -1);
                int level = node.level;
                    // System.out.println(words);
                if(word.equals(targetWord)){
                    ans.add(new ArrayList<>(words));
                }
                StringBuilder sb = new StringBuilder(word);
                int n = word.length();
                for(int i = 0 ; i < n ; i++){
                    char original = sb.charAt(i);
                    for(int j = 0 ; j < 26 ; j++){
                        sb.setCharAt(i,(char)(j+'a'));
                        if(hs.contains(sb.toString())){
                            ArrayList<String> newPath = new ArrayList<>(words);
                            newPath.add(sb.toString());
                            q.add(new Pair(newPath,level+1));
                            temp.add(sb.toString());
                        }
                        
                    }
                    sb.setCharAt(i,original);
                }
            }
            for(String rem : temp){
                hs.remove(rem);
            }
        }
        return ans;
    }
}