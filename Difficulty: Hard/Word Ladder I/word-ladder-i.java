//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Pair{
    public String word;
    public int level;
    Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> hs = new HashSet<>();
        for(String word : wordList){
            hs.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startWord,1));
        hs.remove(startWord);
        while(!q.isEmpty()){
            Pair node = q.poll();
            String word = node.word;
            int level = node.level;
            if(word.equals(targetWord)){
                return level;
            }
            StringBuilder sb = new StringBuilder(word);
            int n = word.length();
            for(int i = 0 ; i < n ; i++){
                char original = sb.charAt(i);
                for(int j = 0 ; j < 26 ; j++){
                    sb.setCharAt(i,(char)(j+'a'));
                    if(hs.contains(sb.toString())){
                        q.add(new Pair(sb.toString(),level+1));
                        hs.remove(sb.toString());
                    }
                    
                }
                sb.setCharAt(i,original);
            }
        }
        return 0;
    }
}