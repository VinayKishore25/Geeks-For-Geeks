#User function Template for python3
class Solution:
	def countPairsWithDiffK(self,arr, k):
    	# code here
        n = len(arr)
        dic = {}
        count = 0
        for i in arr:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        for i in arr:
            x = i - k
            if x in dic:
                count += dic[x]
        return count
                
                



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        k = int(input().strip())
        ob = Solution()
        ans = ob.countPairsWithDiffK(arr, k)
        print(ans)
        print("~")
        tc -= 1

# } Driver Code Ends