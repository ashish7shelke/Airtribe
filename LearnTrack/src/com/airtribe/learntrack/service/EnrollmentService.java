package com.airtribe.learntrack.service;

import java.util.ArrayList;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollmentList = new ArrayList<>();

    public void addEnrollment(Enrollment enroll) {
        enrollmentList.add(enroll);
        System.out.println("Enrollment added with ID: " + enrollmentList.get(enrollmentList.size() - 1).getId());        
    }

    public void removeEnrollment(int enrollmentId) throws EntityNotFoundException {
        Enrollment enrollment = findById(enrollmentId);
        enrollmentList.remove(enrollment);
        System.out.println("Enrollment removed with ID: " + enrollmentId);
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status)
            throws EntityNotFoundException {
        Enrollment enrollment = findById(enrollmentId);
        enrollment.setStatus(status);
        System.out.println("Enrollment updated with ID: " + enrollmentId);
    }    

    public Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollmentList) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with ID: " + id);
    }

    public void listEnrollments() 
    {
        if (enrollmentList.isEmpty()) {
            System.out.println("No enrollment available.");
            return;
        }
        for (Enrollment e : enrollmentList) {
            e.showEnrollmentDetails();
        }
    }
    
    public void listEnrollmentsByStudent(int studentId)
    {
       boolean found = false;

        for (Enrollment e : enrollmentList) {
            if (e.getStudentId() == studentId) {
                e.showEnrollmentDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for Student ID: " + studentId);
        } 
    }
}
