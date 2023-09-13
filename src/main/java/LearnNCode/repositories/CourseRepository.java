package LearnNCode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import LearnNCode.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	Course findByCourseId(int courseId);
}
