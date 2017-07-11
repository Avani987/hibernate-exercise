package main.java;

import javax.persistence.Embeddable;

@Embeddable
public class Subject {

    String subName;

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Subject Name: "+subName+ " ";
    }
}
