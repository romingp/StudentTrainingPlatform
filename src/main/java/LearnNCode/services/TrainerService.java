package LearnNCode.services;

import java.util.List;

import LearnNCode.entities.Course;
import LearnNCode.entities.Lesson;

public interface TrainerService {
	
	String addCourse(Course course);
	List<Course> fetchAllCourses();
	String addLesson(Lesson lesson);
	String saveCourse(Course course);
}
