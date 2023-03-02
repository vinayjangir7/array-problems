package com.example.array.problems;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLengthSubArrayForGivenSum {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int n = arr.length;
        int k = 15;
        System.out.println("Length = " +
                lengthOfLongestSubArr(arr, n, k));
    }

    static int lengthOfLongestSubArr(int[] arr, int n, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == x) {
                maxLen = i + 1;
            }
            map.putIfAbsent(sum, i);
            if (map.containsKey(sum - x) &&
                    maxLen < i - map.get(sum - x)) {
                maxLen = i - map.get(sum - x);
            }
        }
        return maxLen;
    }
}
