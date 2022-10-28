package co.empathy.academy.searchmyexample.service;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.*;

import javax.json.Json;
import java.io.IOException;

@Service
public class ElasticService {

    @Autowired
    private RestClient elasticClient;


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
