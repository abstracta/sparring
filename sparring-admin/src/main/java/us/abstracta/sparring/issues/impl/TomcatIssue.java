package us.abstracta.sparring.issues.impl;

import us.abstracta.sparring.issues.Issue;

public abstract class TomcatIssue implements Issue {

    public abstract void setOn(String input);

    public abstract void setOff();
}
