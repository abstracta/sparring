package us.abstracta.sparring.issues;

public interface Issue {

    public void setOn();

    public void setOn(String input);

    public void setOff();

    public boolean isOn();

    public boolean hasInput();

    public String getName();
}
