package com.mudassirshahzad.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReorderDataInLogs {

    // Problem statement - src/main/resources/ReorderDataInLogsProblemStatement.md

    public static void main(String... strings) {

        String[] arr = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 pwn kit dig", "let2 own kit dig",
            "let3 art zero" };
        String[] result = reorderLogFiles(arr);
        System.out.println(Arrays.toString(result));

    }

    public static String[] reorderLogFiles(final String[] logs) {

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        Arrays.stream(logs).forEach(log -> {
            String[] elements = log.split(" ");
            if (Character.isLetter(elements[1].charAt(0))) {
                letterLogs.add(log);
            }
            else {
                digitLogs.add(log);
            }
        });

        letterLogs.sort(new LogComparator());

        List<String> resultList = Stream.concat(letterLogs.stream(), digitLogs.stream())
            .collect(Collectors.toList());

        return resultList.toArray(new String[0]);
    }

    static class LogComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            String id1 = s1[0];
            String id2 = s2[0];
            int len1 = s1.length;
            int len2 = s2.length;

            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                } else if (i == Math.min(len1, len2) - 1 && s1[i].equals(s2[i])) {
                    return id1.compareTo(id2);
                }
            }
            return 0;
        }

    }

}
