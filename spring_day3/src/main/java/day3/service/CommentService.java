package day3.service;

import day3.dao.CommentDao;
import day3.dto.Comment;

public interface CommentService {
	public CommentDao getDao();
	public Comment fineComment(int commentNo);
	public void writeComment(Comment comment);
	
}
