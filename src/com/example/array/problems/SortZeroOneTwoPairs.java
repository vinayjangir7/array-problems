package com.example.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortZeroOneTwoPairs {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        sort(arr);
    }

    static void sort(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.get(0); i++) {
            list.add(0);
        }
        for (int i = 0; i < map.get(1); i++) {
            list.add(1);
        }
        for (int i = 0; i < map.get(2); i++) {
            list.add(2);
        }
        list.forEach(a ->
                System.out.print(a + " ")
        );
    }
}
