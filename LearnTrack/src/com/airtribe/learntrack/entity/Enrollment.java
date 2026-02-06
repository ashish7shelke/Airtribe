package src.com.airtribe.learntrack.entity;
import java.time.*;
import java.util.ArrayList;

import src.com.airtribe.learntrack.enums.EnrollmentStatus;
public class Enrollment {
    static int EnrollmentCount = 0;
    private int id;
    private int studentId;
    private ArrayList<Integer> courses = new ArrayList<>();
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courses.add(courseId);
        this.enrollmentDate = LocalDate.now();
        this.status = EnrollmentStatus.ACTIVE;
    }

    // All accessor or getter methods
    public int getId() {return id;}
    public int getStudentId(){return studentId;}
    public ArrayList<Integer> getCourseId(){return courses;}
    public LocalDate getEnrollemntData(){return enrollmentDate;}
    public EnrollmentStatus getStatus(){return status;}

    // All mutator or setter methods
    public void setId(int id_) {id = id_;}
    public void setStudentId(int id){studentId = id;}
    public void setCourseId(ArrayList<Integer> course_){courses = course_;}
    public void setEnrollemntData(LocalDate date){enrollmentDate = date;}
    public void setStatus(EnrollmentStatus status_){
        status = status_;
        if(status == EnrollmentStatus.COMPLETED)
            EnrollmentCount = EnrollmentCount + 1;
        if(status == EnrollmentStatus.CANCELLED)
            EnrollmentCount = EnrollmentCount - 1;        
    }

    public void getEnrollmentDetails()
    {
        System.out.println("\tEnrollment Id: " + id);
        System.out.println("\tData :" + enrollmentDate);
        System.out.println("\tStudent Id: " + studentId);
        System.out.println("\tCourses :" + courses);
        System.out.println("\tStatus :" + status);
        System.out.println();
    }
}
