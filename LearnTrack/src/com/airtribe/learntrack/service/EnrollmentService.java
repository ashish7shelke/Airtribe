package src.com.airtribe.learntrack.service;

import java.util.ArrayList;

import src.com.airtribe.learntrack.entity.Enrollment;
import src.com.airtribe.learntrack.enums.EnrollmentStatus;
import src.com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollmentList = new ArrayList<>();

    public void addEnrollment(Enrollment enroll) {
        enrollmentList.add(enroll);
        System.out.println("Enrollment added with ID: " + enrollmentList.getLast().getId());        
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
    /*public Enrollment captureEnroll()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tStudent ID range: 101 to " + IdGenerator.getStudentId());
        System.out.print("\tStudent Id ");
        int si = scanner.nextInt();
        System.out.println("\tCourse ID range: 301 to " + IdGenerator.getCourseId());
        System.out.print("\tCourse Id: ");
        int ci = scanner.nextInt();
        int id = IdGenerator.nextEnrollmentId();
        scanner.close();
        return new Enrollment(id, si, ci); 
    }*/

    public Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollmentList) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment not found with ID: " + id);
    }

    public void listEnrollments() {
        if (enrollmentList.isEmpty()) {
            System.out.println("No enrollment available.");
            return;
        }
        for (Enrollment e : enrollmentList) {
            e.getEnrollmentDetails();
        }
    }
    
    public void listEnrollmentsByStudent(int studentId)
    {
       boolean found = false;

        for (Enrollment e : enrollmentList) {
            if (e.getStudentId() == studentId) {
                e.getEnrollmentDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for Student ID: " + studentId);
        } 
    }
}
