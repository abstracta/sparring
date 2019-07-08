package us.abstracta.sparring.issues.impl;

import us.abstracta.sparring.utils.IssueHelper;

public class AcceptCountIssue extends TomcatIssue {

    private boolean on;
    private String name="Tomcat-Accept Count";
    private String description;

    public AcceptCountIssue(){
        setDescription("The maximum queue length for incoming connection requests can be edited. Default value 100.");
    }

    public void setOn(){}


    public void setOn(String input){
        IssueHelper.sendRequestToSetIssue("server.tomcat.accept-count", input);
        on=true;
    }

    public void setOff(){
        IssueHelper.sendRequestToSetIssue("server.tomcat.accept-count", "100");
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

