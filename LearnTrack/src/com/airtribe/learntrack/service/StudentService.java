package src.com.airtribe.learntrack.service;

import src.com.airtribe.learntrack.entity.Student;
import src.com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added with ID: " + students.getLast().getId());
    }

    public void removeStudent(int studentId) throws EntityNotFoundException {
        Student student = findById(studentId);
        students.remove(student);
        System.out.println("Student removed with ID: " + studentId);
    }

    public void updateStudent(int studentId, String firstName, String lastName)
            throws EntityNotFoundException {
        Student student = findById(studentId);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        System.out.println("Student updated with ID: " + studentId);
    }   
    /*public Student captureStudentData()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\tFirst Name: ");
        String fn = scanner.nextLine();
        System.out.print("\tLast Name: ");
        String ln = scanner.nextLine();
        int id = IdGenerator.nextStudentId();
        scanner.close();
        return new Student(id, fn, ln);
    }*/

    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student not found with ID: " + id);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("\tNo students available.");
            return;
        }
        for (Student s : students) {
            System.out.println("\t" + s.getDisplayName());
        }
    }
}
