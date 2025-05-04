package org.skypro.skyshop.search;

public interface Searchable {

    public String getSearchTerm();

    public String getTypeOfContent();

    String getName();

    default String getStringRepresentation() {
        return getName() + "-" + getTypeOfContent();
    }



}
