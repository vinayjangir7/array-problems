package com.example.array.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EquilibriumPoint {
    // Finds an element in an array such that
    // left and right side sums are equal
    static int findElement(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        List<Integer> list
                = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int i = 1; i <= n; i++) {
            int leftSum = list.subList(0, i)
                    .stream()
                    .mapToInt(x -> x)
                    .sum();
            int rightSum = list.subList(i + 1, n)
                    .stream()
                    .mapToInt(x -> x)
                    .sum();

            if (leftSum == rightSum)
                return list.get(i);
        }
        return -1;
    }

    static int findElementInLinearTime(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        int ls = 0;
        int rs = sum - arr[0];
        for (int i = 1; i < n; i++) {
            ls += arr[i - 1];
            rs -= arr[i];
            if (ls == rs) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Case 1
        int[] arr1 = {1, 4, 2, 5, 0};
        int n1 = arr1.length;
        System.out.println(findElementInLinearTime(arr1, n1));

        // Case 2
        int[] arr2 = {2, 3, 4, 1, 4, 5};
        int n2 = arr2.length;
        System.out.println(findElementInLinearTime(arr2, n2));
    }


}