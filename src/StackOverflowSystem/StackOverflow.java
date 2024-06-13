package StackOverflowSystem;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Model.Question;
import Model.User;

public class StackOverflow {
	private static StackOverflow stackOverflow;
	private Map<Integer, User> users;
	private Map<Integer, Question> questions;
	private Map<String, List<Question>> taggedQuestions;
	
	private StackOverflow() {
		users = new ConcurrentHashMap<>();
		questions = new ConcurrentHashMap<>();
		taggedQuestions = new ConcurrentHashMap<>();
	}
	
	public static StackOverflow getStackOverflowInstance() {
		if(stackOverflow == null) {
			synchronized(StackOverflow.class) {
				if(stackOverflow == null) {
					stackOverflow = new StackOverflow();
				}
			}
		}
		return stackOverflow;
	}
	
	public String registerUser(User user) {
		if(users.get(user.getId()) != null) {
			return "User is already registered";
		}
		
		users.put(user.getId(), user);
		return "user " + user.getName() + " is registered successfully";
	}
	
	public String loginUser(String email, String password) {
		for(User user : users.values()) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "User " + user.getName() + " is logged in";
			}
		}
		return "Please enter valid username and password";
	}
	
	
	
}
