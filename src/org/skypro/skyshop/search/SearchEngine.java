package org.skypro.skyshop.search;

import java.util.LinkedList;

public class SearchEngine {
    private final LinkedList<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new LinkedList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public LinkedList<Searchable> search(String searchString) {
        LinkedList<Searchable> results = new LinkedList<>();
        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().contains(searchString)) {
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
