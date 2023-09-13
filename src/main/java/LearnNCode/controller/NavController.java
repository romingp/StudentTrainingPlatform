package LearnNCode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
/* @SessionAttributes({"username"}) */
@SessionAttributes({ "loggedInUser" })
public class NavController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/register1")
	public String register() {
		return "register1";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/addC")
	public String addC() {
		return "addCourse";
	}
	
	@GetMapping("/newLesson")
	public String newLesson() {
		return "newlesson";
	}
	@GetMapping("/trainerHome")
	public String trainerHome() {
		return "trainerHome";
	}
	@GetMapping("/studentHome")
	public String studentHome() {
		return "studentHome";
	}
}
