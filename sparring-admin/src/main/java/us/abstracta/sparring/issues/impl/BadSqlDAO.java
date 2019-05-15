package us.abstracta.sparring.issues.impl;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class BadSqlDAO extends DAOIssue{

    private boolean on;
    private String name="BadSqlDAO";
    private String description;

    public BadSqlDAO(){
        setDescription("Use of inefficient SQL queries in order to increase response time");
    }


    public void setOn(){
        final String uri = "http://services:8080/setIssue/{issue}/{value}";

        Map<String, String> params = new HashMap<>();
        params.put("issue", "articleDAO");
        params.put("value", "BadSql");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, null, params);

        on=true;
    }

    public void setOff(){
        final String uri = "http://services:8080/setIssue/{issue}/{value}";

        Map<String, String> params = new HashMap<>();
        params.put("issue", "articleDAO");
        params.put("value", "Default");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, null, params);

        on=false;

    }

    public boolean isOn() {
        return on;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
