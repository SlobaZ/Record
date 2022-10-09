package record.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import record.dto.UserDTO;
import record.model.User;
import record.service.UserService;


@Component
public class UserDTOToUser implements Converter<UserDTO, User> {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User convert(UserDTO dto) {
		User user = null;
		
		if(dto.getId()!=null){
			user = userService.getById(dto.getId());
			
			if(user == null){
				throw new IllegalStateException("Tried to modify a non-existant User");
			}
		}
		else {
			user = new User();
		}
		
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		
		return user;
	}
	
	public List<User> convert (List<UserDTO> dtoUsers){
		List<User> users = new ArrayList<>();
		
		for(UserDTO dto : dtoUsers){
			users.add(convert(dto));
		}
		
		return users;
	}
}
