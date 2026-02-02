class Solution {
    int maxCircularSum(int[] arr) {
        int n = arr.length;

        // 1. Normal Kadane
        int normalMax = kadane(arr);

        // If all elements are negative
        if (normalMax < 0) {
            return normalMax;
        }

        // 2. Compute total sum and invert array
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }

        // 3. Circular max
        int circularMax = totalSum + kadane(arr);

        // 4. Final answer
        return Math.max(normalMax, circularMax);
    }

    int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}
