package org.skypro.skyshop.search;

import java.util.LinkedList;
import java.util.TreeMap;

public class SearchEngine {
    private final LinkedList<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new LinkedList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public TreeMap<String, Searchable> search(String searchString) {
        TreeMap<String, Searchable> results = new TreeMap<>();
        for (Searchable item : searchableItems) {
            if (item.getName().toLowerCase().contains(searchString.toLowerCase())) {
                results.putIfAbsent(item.getName(), item);
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
