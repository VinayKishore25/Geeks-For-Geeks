class Solution {
    public int subarrayRanges(int[] arr) {
        // code here
         int n = arr.length;
        long maxSum = sumSubarrayMax(arr, n);
        long minSum = sumSubarrayMin(arr, n);
        return (int)(maxSum - minSum);
    }

    private long sumSubarrayMax(int[] arr, int n) {
        long sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Previous greater element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next greater or equal element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }

        return sum;
    }

    private long sumSubarrayMin(int[] arr, int n) {
        long sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Previous smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next smaller or equal element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }

        return sum;
    }
}
