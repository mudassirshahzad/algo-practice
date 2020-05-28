package com.mudassirshahzad.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TopKFrequentlyMentionedKeywords {

    // Problem statement - src/main/resources/TopKFrequentlyMentionedKeywords.md

    public static void main(String[] args) {
        int k1 = 2;
        List<String> keywords1 = Arrays.asList("anacell", "cetracular", "betacellular");
        List<String> reviews1 = Arrays.asList("Anacell provides the best services in the city", "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell");

        int k2 = 2;
        List<String> keywords2 = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        List<String> reviews2 = Arrays.asList("I love anacell Best services; Best services provided by anacell",
            "betacellular has great services", "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell", "BetaCellular is better than deltacellular.");

        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }

    private static List<String> solve(int k, List<String> keywords, List<String> reviews) {

        Map<String, Integer> store = new HashMap<>();
        Set<String> lookUp = new HashSet<>(keywords);

        reviews.stream().forEach(review -> {

            Set<String> seen = new HashSet<>();
            String[] words = review.toLowerCase().split("\\W+");

            Arrays.stream(words).forEach(word -> {
                if (seen.add(word) && lookUp.contains(word)) {
                    store.put(word, store.getOrDefault(word, 0) + 1);
                }

            });
        });

        return store.entrySet().stream()
            .sorted((first, second) -> first.getValue().equals(second.getValue()) ? first.getKey().compareTo(second.getKey())
                : second.getValue().compareTo(first.getValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
