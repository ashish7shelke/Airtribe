package src.com.airtribe.learntrack.constants;

public class MenuOptions {
    // ---------- MENUS ----------
    public static void showMainMenu() {
        System.out.println("\n===== LearnTrack Main Menu =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
    }

    public static void showStudentMenu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");
        System.out.println("0. Back");
    }

    public static void showCourseMenu() {
        System.out.println("\n--- Course Menu ---");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Activate / Deactivate Course");
        System.out.println("0. Back");
    }

    public static void showEnrollmentMenu() {
        System.out.println("\n--- Enrollment Menu ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Enrollments by Student");
        System.out.println("3. Update Enrollment Status");
        System.out.println("0. Back");
    }
}
