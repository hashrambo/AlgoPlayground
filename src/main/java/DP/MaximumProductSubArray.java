package DP;

/**
 * Leetcode 152 - Maximum Product Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2, 3, -2, 4],
 * the contiguous subarray [2, 3] has the largest product = 6.
 *
 * Created by hashrambo on 3/30/2017.
 */
public class MaximumProductSubArray {

    // this is not correct
    public static int maxProduct(int [] nums) {
        int size = nums.length;
        if (size == 0)
            return 0;

        int product = nums[0];
        int max = nums[0];

        for (int i=1; i<size-1; i++) {
            if (max > product * nums[i]) // reset to tracker to current element if product max not contiguous
                product = nums[i];
            else {
                product = Math.max(product * nums[i], product);
            }
            max = Math.max(product, max);
        }
        return max;
    }

    public static int maxProduct2(int [] nums) {
        int size = nums.length;

        int [] max = new int [size];
        int [] min = new int [size];
        int maxProduct;

        max[0] = min[0] = maxProduct = nums[0];

        for (int i=1; i<size; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i-1] * nums[i]);
                min[i] = Math.min(min[i], min[i-1] * nums[i]);
            } else {
                max[i] = Math.max(max[i], min[i-1] * nums[i]);
                min[i] = Math.min(min[i], max[i-1] * nums[i]);
            }
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }

    public static void main (String[] args) {
        int [] nums = new int [] {2, 3, -2, 4};
        System.out.println(maxProduct(nums)); //6
        System.out.println(maxProduct2(nums)); //6

        int [] nums2 = new int [] {2};
        System.out.println(maxProduct(nums2)); //2
        System.out.println(maxProduct2(nums2)); //2

        int [] nums3 = new int [] {-2, 3, -4}; //expected: 24
        System.out.println(maxProduct(nums3)); //3
        System.out.println(maxProduct2(nums3)); //24

        int [] nums4 = new int [] {0, -2};
        System.out.println(maxProduct(nums4)); //0
        System.out.println(maxProduct2(nums4)); //0
    }
}
