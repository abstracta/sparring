package us.abstracta.sparring.utils;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class IssueHelper {


    public static void sendRequestToSetIssue(String issue, String value){
        final String uri = "http://web:8080/setIssue/{issue}/{value}";

        Map<String, String> params = new HashMap<>();
        params.put("issue", issue);
        params.put("value", value);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, null, params);

    }
}
