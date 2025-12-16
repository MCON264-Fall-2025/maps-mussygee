package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2342 - Max Sum of a Pair With Equal Sum of Digits
 *
 * You are given a 0-indexed integer array nums.
 * Find the maximum sum of a pair of numbers (nums[i] + nums[j]) such that
 * the sum of digits of nums[i] is equal to the sum of digits of nums[j],
 * and i != j.
 *
 * If no such pair exists, return -1.
 *
 * Example:
 * nums = [18, 43, 36, 13, 7]
 * digit sums: 9, 7, 9, 4, 7
 * Pairs with same digit sum:
 *   (18, 36) -> sum = 54 with digit sum 9
 *   (43, 7)  -> sum = 50 with digit sum 7
 * Answer: 54
 */
public class MaxSumPairEqualDigitSum {

    /**
     * @param nums input array
     * @return maximum sum of a pair of numbers sharing the same digit sum,
     *         or -1 if no such pair exists
     */
    public int maximumSum(int[] nums) {
        // TODO: implement
        // Common approach:
        // - For each number, compute its digit sum.
        // - Use a Map<Integer, Integer> digitSum -> highest number seen with this digit sum.
        // - For each number:
        //     if we already have a value for this digit sum,
        //        update answer with (nums[i] + bestSoFar),
        //        and update bestSoFar if nums[i] is larger.
        //     else,
        //        store nums[i] as bestSoFar.
        // - Return answer.

        Map<Integer, Integer> bestSoFarByDigitSum = new HashMap<>();
        int bestPairSum = -1;

        for (int num : nums) {
            int ds = digitSum(num);
            if (bestSoFarByDigitSum.containsKey(ds)) {
                int bestSoFar = bestSoFarByDigitSum.get(ds);
                bestPairSum = Math.max(bestPairSum, bestSoFar + num);

                if (num > bestSoFar) {
                    bestSoFarByDigitSum.put(ds, num);
                }
            } else {
                bestSoFarByDigitSum.put(ds, num);
            }
        }
        return bestPairSum;
    }

    /**
     * Optional helper method:
     * Computes the sum of digits of a non-negative integer.
     */
    int digitSum(int x) {
        // TODO (optional): implement and use it from maximumSum
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

