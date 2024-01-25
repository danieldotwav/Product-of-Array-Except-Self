# Product of Array Except Self

## Introduction
This Java project implements an algorithm for the "Product of Array Except Self" problem, where the goal is to compute an array in which each element at index `i` is the product of all numbers in the array except the one at `i`.

## Constraints
- The product of anyt prefix or suffix of ```nums``` is **guaranteed** to fit in a **32-bit** integer.

## Features
- Handles arrays with zeros.
- Efficiently computes the product without using division.
- Works with negative numbers and single-element arrays.

## Implementation

The algorithm utilizes two auxiliary arrays to store the products of elements to the left and right of each index. It avoids division, making it robust even for arrays containing zeros.

### Code Snippet

```java
public class Main {
    public static void main(String[] args) {
        // Test cases
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
}
```

## Test Cases

The implementation includes various test cases, such as:

- Array with a zero
- Array with negative numbers
- Array with all zeros
- Array with one element
- Array with two elements
- Large array
- Empty array
