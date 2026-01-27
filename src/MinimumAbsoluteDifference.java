/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr


Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        List<List<Integer>> l = minimumAbsDifference(new int[]{1,3,2,4});
        System.out.println(l);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);  // Sort first! O(n log n)

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> pairs = new ArrayList<>();

        // Pass 1: Find min diff (only adjacent!)
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }

        // Pass 2: Collect adjacent pairs matching minDiff
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] == minDiff) {
                pairs.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }

        return pairs;  // Already sorted! No extra sort needed
    }

}
