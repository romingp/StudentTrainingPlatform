package LearnNCode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import LearnNCode.entities.Lesson;

public interface LessonRepository 
				extends JpaRepository<Lesson, String>{
	
	//modification
		Lesson findByLessonId(int lessonId);

}
