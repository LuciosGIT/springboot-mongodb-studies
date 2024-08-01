package com.joselucio.mongodbcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselucio.mongodbcourse.domain.User;
import com.joselucio.mongodbcourse.dto.UserDTO;
import com.joselucio.mongodbcourse.repository.UserRepository;
import com.joselucio.mongodbcourse.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
   }	
	
	public User insert(User obj) { 
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
		
	}
	
	public User update(User obj) {
		Optional<User> newObj = userRepository.findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj.get());
	}
	
	private void updateData(Optional<User> newObj, User obj) {
		newObj.get().setName(obj.getName());
		newObj.get().setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
