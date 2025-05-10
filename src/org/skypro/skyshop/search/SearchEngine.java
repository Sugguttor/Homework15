package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String searchString) {

        return searchableItems.stream()
                .filter(item -> item.getName().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchResultComparator())));

    }

    public class SearchResultComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o2, Searchable o1) {
            int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
            if (lengthCompare == 0) {
                return o2.getName().compareToIgnoreCase(o1.getName());
            }
            return lengthCompare;
        }
    }


    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchableItems) {
            String searchTerm = searchable.getSearchTerm();
            int occurrences = countOccurrences(searchTerm, search);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = searchable;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFoundException(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String subString) {
        int count = 0;
        int index = 0;
        int subStringIndex;

        while ((subStringIndex = text.indexOf(subString, index)) != -1) {
            count++;
            index = subStringIndex + subString.length();
        }

        return count;

    }


}
