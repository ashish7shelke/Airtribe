package src.com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentId = 100;
    private static int courseId = 300;
    private static int enrollmentId = 500;

    public static int nextStudentId() {
        return ++studentId;
    }

    public static int getStudentId() {
        return studentId;
    }

    public static int nextCourseId() {
        return ++courseId;
    }

    public static int getCourseId() {
        return courseId;
    }

    public static int nextEnrollmentId() {
        return ++enrollmentId;
    }  
    
    
}
