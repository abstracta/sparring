package us.abstracta.sparring.issues.impl;

import us.abstracta.sparring.utils.IssueHelper;


public class MemoryLeakIssue extends ControllerIssue {
    private boolean on;
    private String name="MemoryLeak";
    private String description;

    public MemoryLeakIssue(){
        setDescription("Generates a Memory Leak issue");
    }


    public void setOn(){
        IssueHelper.sendRequestToSetIssue("controller", "MemoryLeak");
        on=true;
    }

    public void setOn(String input){ }

    public void setOff(){
        IssueHelper.sendRequestToSetIssue("controller", "Default");
        on=false;
    }

    public boolean isOn() {
        return on;
    }

    public boolean hasInput(){return false;}

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
