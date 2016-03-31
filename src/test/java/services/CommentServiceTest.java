package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Comment;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
@TransactionalConfiguration(defaultRollback = false)

public class CommentServiceTest extends AbstractTest{

	//Service under test-------------
	@Autowired
	private CommentService commentService;
				
	/** Vamos a implementar los metodos de Test */
	/** TODO: Verificar que es correcto */
	@Test
	public void createTest() {

		commentService = new CommentService();
	}

	@Test
	public void findAllTest() {

		Collection<Comment> result;
		result = commentService.findAll();

		for(Comment comment : result){
			System.out.println(comment.getUser());
		}
	}

	@Test
	public void findOne() {

		int commentId = 2;
		Assert.notNull(commentId);
		commentService.findOne(commentId);
	}

	@Test
	public void saveTest() {

		Comment comment = new Comment();
		Assert.notNull(comment);
		commentService.save(comment);
	}

	@Test
	public void deleteTest() {

		Comment comment = new Comment();
		Assert.notNull(comment);
		commentService.delete(comment);
	}
}
