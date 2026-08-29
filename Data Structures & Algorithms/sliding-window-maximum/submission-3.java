class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the max-heap
            heap.offer(new int[]{nums[i], i});

            // Start calculating the result once we've processed at least 'k' elements
            if (i >= k - 1) {
                // Remove elements from the heap that are no longer in the current window
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }

                // The root of the heap is the maximum value in the current window
                output[idx++] = heap.peek()[0];
            }
        }

        return output;
    }

}
