package co.empathy.academy.searchmyexample.configuration;


import co.empathy.academy.searchmyexample.service.SearchEngine;
import co.empathy.academy.searchmyexample.service.SearchEngineImpl;
import co.empathy.academy.searchmyexample.service.SearchService;
import co.empathy.academy.searchmyexample.service.SearchServiceImpl;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This is the configuration class where we'll define our beans (objects whose lifecycle is managed by Spring)
@Configuration
public class Conf {

    @Bean
    public SearchEngine searchEngine() {
        return new SearchEngineImpl();
    }

    @Bean
    public SearchService searchService(SearchEngine searchEngine) {
        return new SearchServiceImpl(searchEngine);
    }


}
