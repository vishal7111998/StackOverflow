package Model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private int id;
	private String title;
	private String body;
	private User author;
	private List<Answer> answers;
	private List<Comment> comments;
	private List<Tag> tags;
	private int voteCount;
	
	public Question(int id, String title, String body, User author, List<Tag> tags) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
		this.tags = tags;
		answers = new ArrayList<>();
		comments = new ArrayList<>();
		voteCount = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	

}
