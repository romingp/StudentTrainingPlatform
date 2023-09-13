package LearnNCode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LearnNCode.entities.Users;
import LearnNCode.repositories.UsersRepository;

@Service
public class UsersServiceImplementation 
				implements UsersService{
	
	@Autowired 	//Object to be given to it
	UsersRepository repo;
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "user added!";
	}
	@Override
	public Users findUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	@Override
	public boolean checkEmail(String email) {
		return repo.existsByEmail(email);
		 
	}
	@Override
	public String saveUsers(Users user) {
		repo.save(user);
		return "save user";
	}
	
}
