package src.main.java.com.university.dao;

public interface CourseDAO {
    List<Course> getAllCourses();
    boolean registerStudent(int courseId, int studentId);
}

