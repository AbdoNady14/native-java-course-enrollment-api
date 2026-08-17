import com.coursemanagement.HttpServerManager;
import com.coursemanagement.repository.InMemoryCourseRepository;
import com.coursemanagement.repository.InMemoryStudentRepository;
import com.coursemanagement.service.CourseService;
import com.coursemanagement.service.StudentService;
import java.io.IOException;

public class Application {
public static void main(String[] args) {
        try {
            // 1. إنشاء الـ Repositories
            InMemoryStudentRepository studentRepository = new InMemoryStudentRepository();
            InMemoryCourseRepository courseRepository = new InMemoryCourseRepository();

            // 2. إنشاء الـ Services
            StudentService studentService = new StudentService(studentRepository);
            CourseService courseService = new CourseService(courseRepository);

            // 3. إنشاء السيرفر وتشغيله
            HttpServerManager serverManager = new HttpServerManager(studentService, courseService);
            serverManager.start();

        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}

