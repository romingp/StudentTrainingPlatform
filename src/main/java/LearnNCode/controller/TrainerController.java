package LearnNCode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import LearnNCode.entities.Course;
import LearnNCode.entities.Lesson;
import LearnNCode.services.TrainerService;

@Controller
@SessionAttributes({ "loggedInUser" })
public class TrainerController {
	@Autowired
	TrainerService tservice;
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute Course course) {
		tservice.addCourse(course);
		return "trainerHome";
	}
	
	@GetMapping("/viewCourses")
	public String viewCourses(Model model) {
		List<Course> courseList=tservice.fetchAllCourses();
		model.addAttribute("courseList", courseList);
		return "courses";
	}
	
	@PostMapping("/addLesson")
	public String addLesson(@ModelAttribute Lesson lesson) {
		tservice.addLesson(lesson);
		Course course=lesson.getCourse();
		course.getLessonList().add(lesson);
		tservice.saveCourse(course);
		return "trainerHome";
	}
}
