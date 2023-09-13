package LearnNCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import LearnNCode.entities.Users;
import LearnNCode.services.UsersService;
import jakarta.servlet.http.HttpSession;

@Controller

@SessionAttributes({ "loggedInUser" })
public class UsersController {
	// Registration
	@Autowired
	UsersService uservice;

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user) {
		String email = user.getEmail();
		boolean isPresent = uservice.checkEmail(email);
		if (isPresent == false) {
			uservice.addUser(user);
		} else {
			System.out.println("Email already present");
		}
		return "login";
	}

	// login validation
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, Model model, ModelMap map) {

		Users user = uservice.findUserByEmail(email);
		String dbPassword = user.getPassword();
		String role = user.getRole();
		if (password.equals(dbPassword)) {
			session.setAttribute("loggedInUser", user);
			model.addAttribute("loggedInUser", user);
			if (role.equals("trainer")) {
				map.put("loggedInUser", user);
				return "trainerHome";
			}

			else {
				map.put("loggedInUser", user);
				return "studentHome";
			}

		} else {
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session ) {
		
		map.put("loggedInUser", null);
		//session.removeAttribute("email");
		
		session.invalidate();
		return "redirect:/home";

	}
	@GetMapping("/studenthome")
	public String validateuser(@RequestParam(name="email", required=false) String email, @RequestParam(name="password", required=false) String password,
			HttpSession session, Model model, ModelMap map){
		return "studentHome";
		
	}
	@GetMapping("/trainerhome")
	public String validateuser1(@RequestParam(name="email", required=false) String email, @RequestParam(name="password", required=false) String password,
			HttpSession session, Model model, ModelMap map){
		return "trainerHome";
		
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "login";
	}
	
}
