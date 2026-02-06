package com.airtribe.learntrack.ui;

import java.util.Scanner;

import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean running = true;

        while (running) {
            MenuOptions.showMainMenu();
            int mainChoice = readInt(scanner);

            switch (mainChoice) {

                // ---------- STUDENT MANAGEMENT ----------
                case 1:
                    boolean studentMenu = true;
                    while (studentMenu) {
                        MenuOptions.showStudentMenu();
                        int studentChoice = readInt(scanner);

                        try {
                            switch (studentChoice) {
                                case 1:
                                    System.out.print("First Name: ");
                                    String fn = scanner.nextLine();
                                    System.out.print("Last Name: ");
                                    String ln = scanner.nextLine();

                                    studentService.addStudent(
                                            new Student(
                                                    IdGenerator.nextStudentId(), fn, ln
                                            )
                                    );
                                    break;

                                case 2:
                                    studentService.listStudents();
                                    break;

                                case 3:
                                    System.out.print("Student ID: ");
                                    int sid = readInt(scanner);
                                    Student s = studentService.findById(sid);
                                    System.out.println(s.getDisplayName());
                                    break;

                                case 4:
                                    System.out.print("Student ID to deactivate: ");
                                    int did = readInt(scanner);
                                    Student ds = studentService.findById(did);
                                    ds.deactivate();
                                    System.out.println("Student deactivated.");
                                    break;

                                case 0:
                                    studentMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                            }
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                // ---------- COURSE MANAGEMENT ----------
                case 2:
                    boolean courseMenu = true;
                    while (courseMenu) {
                        MenuOptions.showCourseMenu();
                        int courseChoice = readInt(scanner);

                        try {
                            switch (courseChoice) {
                                case 1:
                                    System.out.print("Course Name: ");
                                    String cname = scanner.nextLine();
                                    System.out.print("Description: ");
                                    String desc = scanner.nextLine();
                                    System.out.print("Duration (weeks): ");
                                    int dur = readInt(scanner);

                                    courseService.addCourse(
                                            new Course(
                                                    IdGenerator.nextCourseId(),
                                                    cname,
                                                    dur,
                                                    desc
                                            )
                                    );
                                    break;

                                case 2:
                                    courseService.listCourses();
                                    break;

                                case 3:
                                    System.out.print("Course ID: ");
                                    int cid = readInt(scanner);
                                    Course c = courseService.findById(cid);
                                    c.toggleActive();
                                    System.out.println("Course status updated.");
                                    break;

                                case 0:
                                    courseMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                            }
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                // ---------- ENROLLMENT MANAGEMENT ----------
                case 3:
                    boolean enrollMenu = true;
                    while (enrollMenu) {
                        MenuOptions.showEnrollmentMenu();
                        int enrollChoice = readInt(scanner);

                        try {
                            switch (enrollChoice) {
                                case 1:
                                    System.out.print("Student ID: ");
                                    int sid = readInt(scanner);
                                    System.out.print("Course ID: ");
                                    int cid = readInt(scanner);

                                    enrollmentService.addEnrollment(
                                            new Enrollment(
                                                    IdGenerator.nextEnrollmentId(),
                                                    sid,
                                                    cid
                                            )
                                    );
                                    break;

                                case 2:
                                    System.out.print("Student ID: ");
                                    int esid = readInt(scanner);
                                    enrollmentService.listEnrollmentsByStudent(esid);
                                    break;

                                case 3:
                                    System.out.print("Enrollment ID: ");
                                    int eid = readInt(scanner);
                                    System.out.print("Select Status by number: COM(1) / CAN(2)): ");
                                    int select = scanner.nextInt();
                                    EnrollmentStatus status;
                                    if(select == 1)
                                        status = EnrollmentStatus.COMPLETED;
                                    else
                                        status = EnrollmentStatus.CANCELLED;

                                    enrollmentService.updateEnrollmentStatus(eid, status);
                                    break;

                                case 0:
                                    enrollMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid option.");
                            }
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
        System.out.println("Exiting LearnTrack. Bye!");
    }

    // ---------- SAFE INPUT ----------
    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}