package com.example.array.problems;

import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    public static List<List<String>> groupAnagrams(List<String> words) {
        // your solution goes here

        List<List<String>> listOfLIstOfChar = words.stream().map(Anagram::getCHarArrayAsList).collect(Collectors.toList());
        System.out.println(listOfLIstOfChar);
        return listOfLIstOfChar;
    }

    private static List<String> getCHarArrayAsList(String s) {
        return s.chars().mapToObj(c -> {
            char ch = (char) c;
            return String.valueOf(ch);
        }).toList();
    }

    private static String normalizeSolution(List<List<String>> solution) {
        return solution.stream()
                .map(l ->
                        l.stream()
                                .sorted()
                                .collect(Collectors.joining(",", "[", "]")))
                .sorted()
                .collect(Collectors.joining(",", "[", "]"));

    }

    private static void testEquals(String name, Object actual, Object expected) {
        System.out.println("Test " + name + (expected.equals(actual) ? "PASSED" : "FAILED"));
    }

    public static void main(String args[]) {
        testEquals("Empty list test: ", normalizeSolution(groupAnagrams(List.of())), "[]");

        testEquals("Lowercase: ", normalizeSolution(groupAnagrams(List.of("tn", "cab", "vwa", "bca", "nt", "abc"))), "[[abc,bca,cab],[nt,tn],[vwa]]");

        testEquals("Mixed-case: ", normalizeSolution(groupAnagrams(List.of("Tn", "cab", "vwa", "BCA", "nt", "abc"))), "[[BCA,abc,cab],[Tn,nt],[vwa]]");

    }
}

