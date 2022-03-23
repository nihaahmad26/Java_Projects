package com.niha.login.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niha.login.models.Task;
import com.niha.login.models.User;
import com.niha.login.repositories.TaskRepository;
import com.niha.login.repositories.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private TaskRepository tRepo;
	
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> getAllUsers(){
    	return this.userRepository.findAll();
    }
    
    public List<Task> getAllTasks(){
    	return this.tRepo.findAll();
    }
    
    public Task getOneTask(Long id) {
    	return this.tRepo.findById(id).orElse(null);
    }
    
    public Task createTask(Task task) {
    	return this.tRepo.save(task);
    }
    
    public Task editTask(Task task) {
    	return this.tRepo.save(task);
    }
    
    public String deleteTask(Long id) {
    	this.tRepo.deleteById(id);
    	return "Task has been deleted";
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
