# User function Template for python3

class Solution:
    def longestSubarray(self, arr, k):  
        # code here
        prefix_sum = {}
        current_sum = 0
        max_length = 0
        for i, num in enumerate(arr):
            current_sum += num
            if current_sum == k:
                max_length = max(max_length, i+1)
            if current_sum - k in prefix_sum:
                max_length = max(max_length, i - prefix_sum[current_sum-k])
            if current_sum not in prefix_sum:
                prefix_sum[current_sum] = i
        return max_length
    



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input().strip())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        k = int(input().strip())
        ob = Solution()
        print(ob.longestSubarray(arr, k))
        tc -= 1
        print("~")
# } Driver Code Ends