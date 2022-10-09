package record.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import record.model.User;


public interface UserService extends UserDetailsService{
	
	User getById(Integer id);
	List<User> findAll();
	Page<User> findAll(int pageNum);
	User save(User user);
	User delete(Integer id);
	
	Page<User> search(
			@Param("username") String username, 
			@Param("email") String email, 
			 int pageNum);
	
	User findbyUsername(String username);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
