
package com.example.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private final String name;
    private final String studentId;
    private final List<Course> courses = new ArrayList<>();

    public Student(String name, String studentId) {
        if (name == null || name.isBlank()
                || studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException(
                "Student name and ID are required");
        }
        this.name = name;
        this.studentId = studentId;
    }

    public void registerCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course is required");
        }
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public int getTotalCredits() {
        return courses.stream()
                .mapToInt(Course::getCredits)
                .sum();
    }

    public boolean isEligible() {
        return getTotalCredits() >= 15;
    }
}
