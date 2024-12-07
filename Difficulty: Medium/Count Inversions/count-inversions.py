class Solution:
    #User function Template for python3
    #Function to count inversions in the array.
     def inversionCount(self, arr):
        m = max(arr)
        tree = [0]*(m+1)
        
        def update(tree, i, v):
            while i < len(tree):
                tree[i] += v
                i += i&-i
        
        def query(tree, i):
            s = 0
            while i > 0:
                s += tree[i]
                i -= i&-i 
            return s
        
        ans = 0
        for i in range(len(arr)-1, -1, -1):
            ans += query(tree, arr[i]-1)
            update(tree, arr[i], 1)
        
        return ans

#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER


@atexit.register
def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())


if __name__ == '__main__':
    t = int(input())
    for tt in range(t):
        a = list(map(int, input().strip().split()))
        obj = Solution()
        print(obj.inversionCount(a))
        print("~")

# } Driver Code Ends