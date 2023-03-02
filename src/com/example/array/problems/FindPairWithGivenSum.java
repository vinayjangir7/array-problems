package com.example.array.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1, -6, 4};
        int n = 7;
        int x = -2;
        System.out.println(findPair(arr, n, x));
    }

    public static List<Integer> findPair(int[] arr, int n, int x) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = x - arr[i];
            if (set.contains(temp)) {
                list.add(temp);
                list.add(arr[i]);
            }
            set.add(arr[i]);
        }
        return list;
    }
}
