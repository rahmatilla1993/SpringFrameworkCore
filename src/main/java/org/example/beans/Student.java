package org.example.beans;

import java.util.List;
import java.util.Map;

public class Student {
    private String fullName;
    private List<String> subjects;
    private Map<String, Integer> rating;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Map<String, Integer> getRating() {
        return rating;
    }

    public void setRating(Map<String, Integer> rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", subjects=" + subjects +
                ", rating=" + rating +
                '}';
    }
}
