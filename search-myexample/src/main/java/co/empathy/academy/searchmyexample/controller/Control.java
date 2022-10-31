package co.empathy.academy.searchmyexample.controller;


import co.empathy.academy.searchmyexample.service.SearchEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Control {
    private SearchEngine elastic;

    public Control(SearchEngine elastic){
        this.elastic = elastic;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello "+ name;
    }

    @GetMapping("/search")
    public String search(@RequestParam(value="query", defaultValue = "null") String query) {
         String version= elastic.getVersion();
        return "QUERY:"+ query + "\t" + "version:"+ version;

    }


}
