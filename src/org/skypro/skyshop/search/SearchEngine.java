package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
        count = 0;
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count++] = item;
        }
    }

    public Searchable[] search(String searchString) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().contains(searchString)) {
                if (resultCount < 5) {
                    results[resultCount++] = item;
                } else {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (searchableItems == null) {
            throw new BestResultNotFound(search);
        }

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
