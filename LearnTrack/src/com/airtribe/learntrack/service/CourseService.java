package src.com.airtribe.learntrack.service;

import java.util.ArrayList;

import src.com.airtribe.learntrack.entity.Course;
import src.com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {
    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added with ID: " + courses.getLast().getId());
    }

    public void removeCourse(int courseId) throws EntityNotFoundException {
        Course course = findById(courseId);
        courses.remove(course);
        System.out.println("Course removed with ID: " + courseId);
    }

    public void updateCourse(int courseId, String name, String description, int duration)
            throws EntityNotFoundException {
        Course course = findById(courseId);
        course.setCourseName(name);
        course.setDescription(description);
        course.setDurationInWeeks(duration);
        System.out.println("Course updated with ID: " + courseId);
    }    
    /*public Course captureCourseData()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\tCourse Name: ");
        String cn = scanner.nextLine();
        System.out.print("\tDescription: ");
        String cd = scanner.nextLine();
        int id = IdGenerator.nextCourseId();
        scanner.close();
        return new Course(id, cn, 12, cd);
    }*/
    
    public Course findById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new EntityNotFoundException("Course not found with ID: " + id);
    }

    public void createDefaultCourses()
    {
        addCourse(new Course(courses.size()+1, "Core Java", 12, "Learning Java basics"));
        addCourse(new Course(courses.size()+1, "DSA", 12, "Learning Data Structures and Algorithms"));
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No course available.");
            return;
        }
        for (Course c : courses) {
            c.showDetails();
        }
    }    
}
