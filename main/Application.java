import com.coursemanagement.model.Student;
import com.coursemanagement.model.Role;
import com.coursemanagement.repository.InMemoryStudentRepository;

public class Application {
    public static void main(String[] args) {
        System.out.println("Course Enrollment Management System");
        System.out.println("Application started successfully");

        Student student1 = new Student("John Doe", "john.doe@example.com", "password123", Role.STUDENT, true);
        InMemoryStudentRepository.save(student1);
        Student foundStudent = InMemoryStudentRepository.findById(student1.getId());
        System.out.println("Found Student: " + foundStudent);
    }
}
