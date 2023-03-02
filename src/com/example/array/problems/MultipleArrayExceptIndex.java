package com.example.array.problems;

public class MultipleArrayExceptIndex {

    public static void main(String[] args) {
        int[] n = {0, 2, 3, 4};
        int[] numbers = multiplyArrayExceptIndexOptimized(n);
        for (int i = 0; i < n.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static int[] multiplyArrayExceptIndexOptimized(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[0] = 1;

        // Multiply all elements to the left of index i
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        // Multiply all elements to the right of index i
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= arr[i];
        }

        return result;
    }

    private static int[] multipliedArrayBruteForce(int[] numbers) {
        int[] returnedArr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int l = 1;
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    l *= numbers[j];
                }
            }
            returnedArr[i] = l;
        }
        return returnedArr;
    }
}


