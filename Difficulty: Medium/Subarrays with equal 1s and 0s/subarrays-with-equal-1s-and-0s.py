#User function Template for python3

class Solution:
    
    #Function to count subarrays with 1s and 0s.
    def countSubarrWithEqualZeroAndOne(self,arr, n):
        #Your code here
        for i in range(n):
            if arr[i] == 0:
                arr[i] = -1
        dic = {}
        s = 0
        ans = 0
        dic[0] = 1
        for i in range(n):
            s += arr[i]
            if s in dic:
                ans += dic[s]
                dic[s] += 1
            else:
                dic[s] = 1
            
        return ans


#{ 
 # Driver Code Starts
#Initial Template for Python 3



def main():
    T=int(input())
    while(T>0):
        
        n=int(input())
        arr=[int(x) for x in input().strip().split()]
        
        obj = Solution()
        print(obj.countSubarrWithEqualZeroAndOne(arr, n))
        
        T-=1

        print("~")
if __name__=="__main__":
    main()
# } Driver Code Ends