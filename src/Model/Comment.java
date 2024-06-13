package Model;

public class Comment {
	private int id;
	private String body;
	private User author;
	private CommentType commentType;
	
	public Comment(int id, String body, User author, CommentType commentType) {
		this.id = id;
		this.body = body;
		this.author = author;
		this.commentType = commentType;
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

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}
	
	
}
