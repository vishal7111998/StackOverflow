package Client;

import java.util.List;

import Model.Question;
import Model.Tag;
import Model.User;
import StackOverflowSystem.StackOverflow;

public class StackOverflowDemo {
	
	public static void main(String[] args) {
		StackOverflow stackOverflow = StackOverflow.getStackOverflowInstance();
		
		User user1 = new User(1, "abc", "abc@gmail.com", "123");
		User user2 = new User(2, "def", "def@gmail.com", "234");
		
		Tag tag1 = new Tag(1, "java");
		Tag tag2 = new Tag(2, "c++");
		Tag tag3 = new Tag(3, "python");
		Tag tag4 = new Tag(4, "springboot");
		Tag tag5 = new Tag(5, "dsa");
		Tag tag6 = new Tag(6, "desgin pattern");
		
		Question q1 = new Question(1, "Palindrome Number", "How to check whether a number is palindrone or not",
				user1, List.of(tag5, tag1, tag2, tag3));
		
		Question q2 = new Question(2, "Armstrong Number", "How to check whether a number is armstrong or not",
				user2, List.of(tag5));
		
		Question q3 = new Question(3, "Design Patterns", "Different sources to learn about design patterns",
				user1, List.of(tag6));
		
		
		stackOverflow.registerUser(user1);
		stackOverflow.registerUser(user2);
		
		stackOverflow.postQuestion(q1);
		stackOverflow.postQuestion(q2);
		stackOverflow.postQuestion(q3);
		
		for(Question question : stackOverflow.searchQuestionByTag(tag5)) {
			System.out.println(question.getTitle());
		}
	}
	
}
