
package com.example.course;

public class Course {
    private final String name;
    private final int credits;

    public Course(String name, int credits) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course name is required");
        }
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive");
        }
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
