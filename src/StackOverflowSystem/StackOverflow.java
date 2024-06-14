package StackOverflowSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import Model.Answer;
import Model.Comment;
import Model.Question;
import Model.Tag;
import Model.User;

public class StackOverflow {
	private static StackOverflow stackOverflow = null;
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
	
	
	public void postQuestion(Question question) {
		questions.put(question.getId(), question);
		for(Tag tag : question.getTags()) {
			taggedQuestions.computeIfAbsent(tag.getName(), k -> new ArrayList<>()).add(question);
		}
	}
	
	public void postAnswer(Answer answer) {
		Question question = answer.getQuestion();
		question.getAnswers().add(answer);
	}
	
	public void postCommentOnQuestion(Comment comment, int questionId) {
		Question question = questions.get(questionId);
		question.getComments().add(comment);
	}
	
	public void postCommentOnAnswer(Comment comment, int answerId, int questionId) {
		Question question = questions.get(questionId);
		for(Answer answer : question.getAnswers()) {
			if(answer.getId() == answerId) {
				answer.getComments().add(comment);
				break;
			}
		}
	}
	
	public void voteQuestion(Question question, int value) {
		//Question question = questions.get(questionId);
		synchronized(question) {
			question.setVoteCount(question.getVoteCount() + value);
		}
		
		updateAuthorReputation(question.getAuthor(), value);
	}
	
	public void voteAnswer(Answer answer, int value) {
		synchronized(answer) {
			answer.setVoteCount(answer.getVoteCount() + value);
		}
		
		updateAuthorReputation(answer.getAuthor(), value);
	}
	
	public void updateAuthorReputation(User author, int value) {
		synchronized(author) {
			author.setReputation(author.getReputation() + value);
		}
	}
	
	public List<Question> searchQuestion(String keyword){
		List<Question> list = new ArrayList<>();
		for(Question question : questions.values()) {
			if(question.getTitle().contains(keyword) || question.getBody().contains(keyword)) {
				list.add(question);
			}
		}
		
		return list;
	}
	
	public List<Question> searchQuestionByTag(Tag tag){
		return taggedQuestions.getOrDefault(tag.getName(), new ArrayList<>());
	}
	
	public List<Question> searchQuestionByAuthor(User author){
		List<Question> list = new ArrayList<>();
		for(Question question : questions.values()) {
			if(question.getAuthor().equals(author)) {
				list.add(question);
			}
		}
		return list;
	}
	
}
