package co.empathy.academy.searchmyexample.service;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SearchEngineImpl implements SearchEngine {

    @Autowired
    private RestClient elasticClient;

    // This method should make a request to Elasticsearch to retrieve search results
    // For our example we'll just return the query length as number of results
    @Override
    public int search(String query) {
        if (query == null) {
            throw new RuntimeException("Query is mandatory");
        }

        return query.length();
    }



    public String getVersion()  {
        String version;
        try
        {
            Request request = new Request("GET", "/");
            Response response = elasticClient.performRequest(request);
            String responseStr = EntityUtils.toString(response.getEntity());
            JSONObject responseObj = new JSONObject(responseStr);
            version=responseObj.getString("version");

        } catch (IOException exception)
        {
            throw new RuntimeException("IOException in getVersion() ");
        }

        return version;

    }
}
