package us.abstracta.sparring.issues.impl;

import us.abstracta.sparring.utils.IssueHelper;


public class BadSqlDAO extends DAOIssue {

    private boolean on;
    private String name="BadSqlDAO";
    private String description;

    public BadSqlDAO(){
        setDescription("Use of inefficient SQL queries in order to increase response time");
    }


    public void setOn(){
        IssueHelper.sendRequestToSetIssue("articleDAO", "BadSql");
        on=true;
    }

    public void setOn(String input){ }

    public void setOff(){
        IssueHelper.sendRequestToSetIssue("articleDAO", "Default");
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
