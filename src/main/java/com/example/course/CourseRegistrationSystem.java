
package com.example.course;

import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = new Student(name, studentId);

        System.out.print("How many subjects do you want to register? ");
        int count = Integer.parseInt(scanner.nextLine());

        if (count < 0) {
            System.out.println("Number of subjects cannot be negative.");
            return;
        }

        for (int i = 1; i <= count; i++) {
            System.out.println("\nSubject " + i);

            System.out.print("Enter subject name: ");
            String subjectName = scanner.nextLine();

            System.out.print("Enter credits: ");
            int credits = Integer.parseInt(scanner.nextLine());

            student.registerCourse(new Course(subjectName, credits));
        }

        System.out.println("\n===== REGISTRATION SUMMARY =====");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Registered Subjects:");

        for (Course course : student.getCourses()) {
            System.out.println("- " + course.getName()
                    + " (" + course.getCredits() + " credits)");
        }

        System.out.println("Total Credits: " + student.getTotalCredits());
        System.out.println("Eligibility: "
                + (student.isEligible()
                ? "Eligible"
                : "Not Eligible"));

        scanner.close();
    }
}
