package us.abstracta.sparring.issues.impl;

import us.abstracta.sparring.utils.IssueHelper;


public class MaxThreadsIssue extends TomcatIssue {

    private boolean on;
    private String name="Tomcat-Max Threads";
    private String description;

    public MaxThreadsIssue(){
        setDescription("The maximum amount of worker threads can be edited. Default value 200.");
    }

    public void setOn(){}

    public void setOn(String input){
        IssueHelper.sendRequestToSetIssue("server.tomcat.max-threads", input);
        on=true;
    }

    public void setOff(){
        IssueHelper.sendRequestToSetIssue("server.tomcat.max-threads", "200");
        on=false;

    }

    public boolean isOn() {
        return on;
    }

    public boolean hasInput(){return true;}

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
