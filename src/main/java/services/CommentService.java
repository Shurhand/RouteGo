package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Comment;
import repositories.CommentRepository;

@Service
@Transactional
public class CommentService {

	public CommentService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private CommentRepository commentRepository;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Comment create() {

		Comment result;

		result = new Comment();

		return result;
	}

	public Collection<Comment> findAll() {

		Collection<Comment> result;

		result = commentRepository.findAll();

		return result;
	}

	public Comment findOne(int commentId) {
		Assert.notNull(commentId);

		Comment result;

		result = commentRepository.findOne(commentId);

		return result;
	}

	public void save(Comment comment) {
		Assert.notNull(comment);

		commentRepository.save(comment);
	}

	public void delete(Comment comment) {
		Assert.notNull(comment);

		commentRepository.delete(comment);
	}

	// ========== Other Business Methods =============

}
