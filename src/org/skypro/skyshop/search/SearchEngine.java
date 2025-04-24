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


}
