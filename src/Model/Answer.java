package Model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	private int id;
	private String body;
	private User author;
	private List<Comment> comments;
	private Question question;
	private int voteCount;
	
	public Answer(int id, String body, User author, Question question) {
		this.id = id;
		this.author = author;
		this.body = body;
		this.question = question;
		voteCount = 0;
		comments = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	

}
