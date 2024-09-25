import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseId + ": " + courseName;
    }
}

class Student {
    private String studentId;
    private String studentName;
    private ArrayList<Course> registeredCourses;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course " + course.getCourseName() + " registered successfully.");
    }

    public void viewRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered yet.");
        } else {
            System.out.println("Registered Courses:");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}

class CourseRegistrationSystem {
    private HashMap<String, Student> students;
    private HashMap<String, Course> courses;

    public CourseRegistrationSystem() {
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
        System.out.println("Student " + student.getStudentName() + " added successfully.");
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
        System.out.println("Course " + course.getCourseName() + " added successfully.");
    }

    public void registerStudentForCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        if (student != null && course != null) {
            student.registerCourse(course);
        } else {
            System.out.println("Invalid student or course ID.");
        }
    }

    public void viewStudentCourses(String studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            System.out.println("Courses for student " + student.getStudentName() + ":");
            student.viewRegisteredCourses();
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Sample courses
        system.addCourse(new Course("C101", "Data Structures"));
        system.addCourse(new Course("C102", "Algorithms"));
        system.addCourse(new Course("C103", "Database Systems"));

        // Menu system
        do {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Add Student");
            System.out.println("2. Register Student for Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    system.addStudent(new Student(studentId, studentName));
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    String sid = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String cid = scanner.nextLine();
                    system.registerStudentForCourse(sid, cid);
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String sidView = scanner.nextLine();
                    system.viewStudentCourses(sidView);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}