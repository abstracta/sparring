package us.abstracta.sparring.issues.impl;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeakIssue extends ControllerIssue {
    private boolean on;
    private String name="MemoryLeak";
    private String description;

    public MemoryLeakIssue(){
        setDescription("Generates a Memory Leak issue");
    }


    public void setOn(){
        final String uri = "http://web:8080/setIssue/{issue}/{value}";

        Map<String, String> params = new HashMap<>();
        params.put("issue", "controller");
        params.put("value", "MemoryLeak");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, null, params);

        on=true;
    }

    public void setOff(){
        final String uri = "http://web:8080/setIssue/{issue}/{value}";

        Map<String, String> params = new HashMap<>();
        params.put("issue", "controller");
        params.put("value", "MemoryLeak");

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
