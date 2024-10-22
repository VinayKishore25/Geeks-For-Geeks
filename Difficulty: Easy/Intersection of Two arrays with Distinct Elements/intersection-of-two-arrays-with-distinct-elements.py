#User function Template for python3

#Function to return the count of the number of elements in
#the intersection of two arrays.
class Solution:
    def numberofElementsInIntersection(self,a, b):
        #return: expected length of the intersection array.
        d={}
        res=[]
        for i in a:
            if i not in d:
                d[i]=1
            else:
                d[i]+=1
        for i in b:
            if i in d and d[i]>0:
                res.append(i)
                d[i]*=-1
        return len(res)
        #code here


#{ 
 # Driver Code Starts
#Position this line where user code will be pasted.
t = int(input().strip())
while t > 0:
    t -= 1
    # Read first array
    a = list(map(int, input().strip().split()))

    # Read second array
    b = list(map(int, input().strip().split()))

    #input()  # to consume the empty line

    # ADD Solution initialization
    sln = Solution()

    # Assuming numberofElementsInIntersection function is defined in Solution
    print(sln.numberofElementsInIntersection(a, b))

# } Driver Code Ends