/**
 * 
 */
package day3.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import day3.dto.Comment;

/**
 * @author Administrator
 *
 */
@Repository
public class CommentDaoImpl implements CommentDao {
	DataSource ds;
	Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class); 
	public CommentDaoImpl() {
		logger.trace("default constructor");
	}
	public CommentDaoImpl(DataSource ds) {
		super();
		logger.trace("ds 설정 : " + ds);
	}
	/* (non-Javadoc)
	 * @see dao.CommentDao#findComment(int)
	 */
	public Comment findComment(int commentNo) {
		logger.trace("findComment : " + commentNo);
		return new Comment();
	}
	public void writeComment(Comment comment){
		logger.trace("writeComment : " + comment);
	}
	
	public DataSource getDs(){
		return ds;
	}
	@Autowired
	public void setDs(@Qualifier("dataSource") DataSource ds){
		logger.trace("ds 설정 : " + ds);
		this.ds = ds;
	}
	public void afterGeneration() {
		// TODO Auto-generated method stub
		logger.trace("injection 완료");
		
	}
	
	public void beforeDestory(){
		logger.trace("cache 정리");
		
	}
}
