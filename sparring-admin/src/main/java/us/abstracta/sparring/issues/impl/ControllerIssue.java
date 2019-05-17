package us.abstracta.sparring.issues.impl;

import us.abstracta.sparring.issues.Issue;

public abstract class ControllerIssue implements Issue {

    public abstract void setOn();

    public abstract void setOff();
}
