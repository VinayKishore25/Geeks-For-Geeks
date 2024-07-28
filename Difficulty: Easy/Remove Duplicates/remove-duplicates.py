#User function Template for python3
class Solution:
	def removeDups(self, str):
		# code here
		isPresent=[False]*26
        ans=""
        for val in str:
            i=ord(val)-ord("a")
            if not isPresent[i]:
                ans+=val
                isPresent[i]=True
        return ans


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        s = input()

        ob = Solution()
        answer = ob.removeDups(s)

        print(answer)

# } Driver Code Ends