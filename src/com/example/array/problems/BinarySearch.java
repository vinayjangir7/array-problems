package com.example.array.problems;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 40, 10};
        int n = arr.length;
        int x = 10;
        System.out.println(binarySearch(arr, 0, n - 1, x));
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        Arrays.sort(arr);
        if (l <= r) {
            int mid = 1 + (r - l) / 2;
            if (x == arr[mid]) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            } else {
                return binarySearch(arr, mid + 1, r, x);
            }
        }
        return -1;
    }
}
