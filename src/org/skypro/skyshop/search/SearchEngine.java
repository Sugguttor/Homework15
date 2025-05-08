package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String searchString) {
        Set<Searchable> results = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o2, Searchable o1) {
                int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
                if (lengthCompare == 0) {
                    return o2.getName().compareToIgnoreCase(o1.getName());
                }
                return lengthCompare;
            }
        });
        for (Searchable item : searchableItems) {
            if (item.getName().toLowerCase().contains(searchString.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
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
