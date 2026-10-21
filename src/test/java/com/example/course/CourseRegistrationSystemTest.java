
package com.example.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationSystemTest {

    @Test
    void eligibleWhenCreditsAre15() {
        Student student = new Student("Kanish", "ST101");
        student.registerCourse(new Course("Java", 5));
        student.registerCourse(new Course("DBMS", 5));
        student.registerCourse(new Course("Networks", 5));

        assertEquals(15, student.getTotalCredits());
        assertTrue(student.isEligible());
    }

    @Test
    void notEligibleWhenCreditsAreBelow15() {
        Student student = new Student("Student", "ST102");
        student.registerCourse(new Course("Java", 4));
        student.registerCourse(new Course("DBMS", 5));

        assertEquals(9, student.getTotalCredits());
        assertFalse(student.isEligible());
    }

    @Test
    void registersMultipleCourses() {
        Student student = new Student("Student", "ST103");
        student.registerCourse(new Course("Java", 3));
        student.registerCourse(new Course("DBMS", 4));

        assertEquals(2, student.getCourses().size());
        assertEquals(7, student.getTotalCredits());
    }

    @Test
    void rejectsInvalidCredits() {
        assertThrows(IllegalArgumentException.class,
                () -> new Course("Java", 0));
    }
}
