package LearnNCode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import LearnNCode.entities.Users;

public interface UsersRepository 
		extends JpaRepository<Users,Integer> {
	
		Users findByEmail(String email);
		
		boolean existsByEmail(String email);
	
}
