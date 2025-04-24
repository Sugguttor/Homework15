package org.skypro.skyshop.search;

public interface Searchable {

    public String getSearchTerm();

    public String getTypeOfContent();

    default String getStringRepresentation() {
        return "имя " + getSearchTerm() + " - тип " + getTypeOfContent();
    }

}
