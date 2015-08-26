package day3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import day3.dao.CommentDao;
import day3.dto.Comment;
@Service("myService")
public class MyCommentService implements CommentService {
	Logger logger = LoggerFactory.getLogger(MyCommentService.class);
	CommentDao dao;
	
	public MyCommentService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public MyCommentService(CommentDao dao) {
		super();
		this.dao = dao;
	}

	public CommentDao getDao() {
		logger.trace("get dao 호출 " + dao);
		return dao;
	}

	public void setDao(CommentDao dao){
		logger.trace("ds 설정"  + dao);
		this.dao = dao;
	}
	
	
	public Comment fineComment(int commentNo) {
		logger.trace("ds를 통해 db 조회" + commentNo);
		dao.findComment(commentNo);
		return new Comment();
	}

	public void writeComment(Comment comment) {
		logger.trace("ds를 통해 db에 저장" + comment);
		dao.writeComment(comment);
	}

	@Override
	public String toString() {
		return "CommentServiceImpl [dao=" + dao + "]";
	}

	
}
