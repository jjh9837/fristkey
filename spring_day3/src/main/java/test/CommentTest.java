package test;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day3.dao.CommentDao;
import day3.service.CommentService;

public class CommentTest {

	private static Logger logger = LoggerFactory.getLogger(CommentTest.class);
	ApplicationContext ctx;
	public static void main(String[] args) {
		logger.trace("hello");
		CommentTest ct = new CommentTest();
		ct.applicationCreateTest("comment_system.xml");
		ct.useBean();
	}
	void applicationCreateTest(String file){
		ctx = new ClassPathXmlApplicationContext(file,CommentTest.class);
	}
	void useBean(){
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		logger.trace("ds 조회 : " + ds);
		CommentService cs = (CommentService) ctx.getBean("commentService");
		logger.trace("comment service" + cs);
		
		CommentService cs2 = ctx.getBean("commentService", CommentService.class);
		logger.trace("comment service" + cs2);
		
		CommentDao dao = ctx.getBean(CommentDao.class);
		CommentDao dao2 = ctx.getBean(CommentDao.class);
		logger.trace("same? {}", dao==dao2);
		logger.trace("same? {}", cs==cs2);
	}
}
