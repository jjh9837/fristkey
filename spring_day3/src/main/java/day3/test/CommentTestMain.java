package day3.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day3.dao.CommentDao;
import day3.dao.CommentDaoImpl;
import day3.dao.MyProductDaoImpl;
import day3.service.CommentService;

public class CommentTestMain {
	ApplicationContext ctx = null;
	private static Logger logger = LoggerFactory.getLogger(CommentTestMain.class);
	public static void main(String args[]){
		CommentTestMain ctm = new CommentTestMain();
		ctm.setupCtx();
		ctm.getDaoBeanTest();
	}
	private void setupCtx(){
		ctx = new ClassPathXmlApplicationContext("/day3/config/coment.xml");
		logger.trace("context 초기화: {}", ctx);
	}
	
	private void getDaoBeanTest(){
		CommentDaoImpl dao = ctx.getBean(CommentDaoImpl.class);
		logger.trace("comment dao bean : {}", dao);
	//	dao = (CommentDaoImpl) ctx.getBean("commentDaoImpl");
	//	logger.trace("comment dao bean by name: {}", dao);

		CommentService service = ctx.getBean(CommentService.class);
		logger.trace("comment service by tyep : {}", service);
		CommentService service2 = (CommentService) ctx.getBean("myService");
		logger.trace("same service? : {}", service==service2);
		
		MyProductDaoImpl mpd = ctx.getBean("productDaoByAnnotation",MyProductDaoImpl.class);
		logger.trace("myproductdaoimpl : {]", mpd);
		
	}
}
