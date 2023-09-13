package LearnNCode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import LearnNCode.entities.Course;
import LearnNCode.entities.Lesson;

import LearnNCode.repositories.CourseRepository;
import LearnNCode.repositories.LessonRepository;

@Service
public class StudentServiceImplementation 
					implements StudentService{

	@Autowired
	CourseRepository repo;
	
	@Autowired
	LessonRepository lrepo;
	

	
	@Override
	public List<Course> fetchCourseList() {
		return repo.findAll();
	}
	@Override
	public Course fetchCourse(int courseId) {
		
		return repo.findByCourseId(courseId);
	}
	@Override
	public Lesson getLesson(int lessonId) {
		return lrepo.findByLessonId(lessonId);
	}

	
}
