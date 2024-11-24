#Your task is to complete this function
 
class Solution:
    def maxLen(self, arr):
        # code here
        n = len(arr)
        s = 0
        dic = {}
        sub_len = 0
        for i in range(n):
            s += arr[i]
            if s == 0:
                sub_len = max(sub_len,i+1)
            if s in dic:
                curr_len = i - dic[s]
                sub_len = max(sub_len,curr_len)
            else:
                dic[s] = i
        return sub_len
                 

#{ 
 # Driver Code Starts
if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.maxLen(arr))
        print("~")

# } Driver Code Ends