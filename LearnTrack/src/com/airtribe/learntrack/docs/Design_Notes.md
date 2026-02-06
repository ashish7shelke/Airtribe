1) Why you used ArrayList instead of array?
    In LearnTrack, ArrayList is used to store Students, Courses, and Enrollments inside service classes such as:
        StudentService
        CourseService
        EnrollmentService

    Reasons for choosing ArrayList:
    Dynamic size
    The number of students, courses, and enrollments is not known in advance.
    Arrays require a fixed size at creation, which is not practical for a management system.ArrayList automatically grows and shrinks as elements are added or removed.
    Ease of operations
    Methods like add(), remove(), and get() make code simpler and more readable.
    Removing an object (e.g., a student or enrollment) is straightforward without manual shifting.Better readability and maintainability
    Using ArrayList keeps the focus on business logic, not low-level memory management.
    This aligns with clean code principles taught in Core Java.
    Because LearnTrack is an in-memory, dynamic system, ArrayList is a better choice than arrays.

2) Where you used static members and why?
    Static members are used where shared, application-wide behavior is required.
    IDs must be unique across the entire application.
    Static variables ensure there is only one counter shared by all services.
    ID generation is a utility behavior, not tied to any specific object.
    Calling IdGenerator.nextStudentId() is cleaner than creating an instance.

3) Where you used inheritance and what you gained from it?

Person
 ├── Student
 └── Trainer

    Common fields:
        id
        firstName
        lastName
        email
    Common behavior:
        getDisplayName()
        getRole()
    Student and Trainer (Child Classes)
    Student adds:
        batch
        active status
        deactivate() behavior
    Trainer adds:
        expertise
        experienceInYears

Code reuse
    Shared fields and methods are written once in Person.
    Avoids duplication in Student and Trainer.
    All people in the system are treated as Person.
    Future extensibility: New roles (e.g., Admin, Mentor) can be added without changing existing logic.

