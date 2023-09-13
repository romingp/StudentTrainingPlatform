package LearnNCode.services;

import java.util.List;

import LearnNCode.entities.Course;
import LearnNCode.entities.Lesson;

public interface StudentService {

	List<Course> fetchCourseList();
	
	Course fetchCourse(int courseId);
	
	//modification
		Lesson getLesson(int lessonId);
		
}
