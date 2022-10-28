package co.empathy.academy.searchmyexample.service;

// This is the service class that will implement your search service logic
// It has a SearchEngine as a dependency
// Endpoint: /search (controller) -> SearchService -> SearchEngine
public class SearchServiceImpl implements SearchService {

    private final SearchEngine searchEngine;

    public SearchServiceImpl(SearchEngine searchEngine) {

        this.searchEngine = searchEngine;
    }

    @Override
    public int search(String query) {

        return searchEngine.search(query);
    }
}
