public class Main {
    public static void main(String[] args) {
        // Test Case 1: Default Case
        printArray(productExceptSelf(new int[] { 1, 2, 3, 4 })); // Expected: [24, 12, 8, 6]

        // Test Case 2: Array with a zero
        printArray(productExceptSelf(new int[] { 0, 1, 2, 3, 4 })); // Expected: [24, 0, 0, 0, 0]

        // Test Case 3: Array with negative numbers
        printArray(productExceptSelf(new int[] { -1, 2, -3, 4 })); // Expected: [-24, 12, -8, 6]

        // Test Case 4: Array with all zeros
        printArray(productExceptSelf(new int[] { 0, 0, 0, 0 })); // Expected: [0, 0, 0, 0]

        // Test Case 5: Array with one element
        printArray(productExceptSelf(new int[] { 5 })); // Expected: [0]

        // Test Case 6: Array with two elements
        printArray(productExceptSelf(new int[] { 1, 2 })); // Expected: [2, 1]

        // Test Case 7: Large array
        printArray(productExceptSelf(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })); // Expected: [3628800, 1814400, 1209600, 907200, 725760, 604800, 518400, 453600, 403200, 362880]
    
        // Test Case 8: Empty array
        printArray(productExceptSelf(new int[] {})); // Expected: []
    }

    static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        if (numsLength == 0) { return new int [0]; }
        if (numsLength == 1) { return new int[] { 0 }; }
        
        int[] leftProducts = new int[numsLength];
        int[] rightProducts = new int[numsLength];

        // Do a first pass to sum all products to the left
        for (int i = 0; i < numsLength; ++i) {
            // Get products of values to the left of current index
            if (i == 0) {
                leftProducts[i] = 1;
            }
            else {
                leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
            }
        }

        // Do a second pass to sum all products to the right
        for (int i = numsLength - 1; i >= 0; --i) {
            if (i == numsLength - 1) {
                rightProducts[numsLength - 1] = 1;
            }
            else {
                rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
            }
        }

        // Multiply left and right products for final array
        for (int i = 0; i < numsLength; ++i) {
            nums[i] = leftProducts[i] * rightProducts[i];
        }

        return nums;
    }

    static void printArray(int[] container) {
        System.out.print("[");
        for (int i = 0; i < container.length; ++i) {
            if (i == container.length - 1) {
                System.out.print(container[i]);
            }
            else {
                System.out.print(container[i] + ", ");
            }
        }
        System.out.print("]\n\n");
    }
}