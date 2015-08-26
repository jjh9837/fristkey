package day3.dao;

import day3.dto.Comment;

public interface CommentDao {
	public Comment findComment(int commentNo);
	public void writeComment(Comment comment);
	public void afterGeneration();
}
