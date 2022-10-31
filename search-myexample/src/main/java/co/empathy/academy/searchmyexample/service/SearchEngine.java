package co.empathy.academy.searchmyexample.service;

public interface SearchEngine {

    int search(String query); //returns the number of elements in a query
    String getVersion(); //returns the number of the version
}
