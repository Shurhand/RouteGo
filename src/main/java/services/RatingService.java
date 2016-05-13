package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Rating;
import repositories.RatingRepository;

@Service
@Transactional
public class RatingService {

	public RatingService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private RatingRepository ratingRepository;

	// ========== Supporting services ================

	@Autowired
	private CustomerService customerService;

	// ========== Simple CRUD Methods ================

	public Rating create() {

		Rating result;

		result = new Rating();

		return result;
	}

	public Collection<Rating> findAll() {

		Collection<Rating> result;

		result = ratingRepository.findAll();

		return result;
	}

	public Rating findOne(int ratingId) {
		Assert.notNull(ratingId);

		Rating result;

		result = ratingRepository.findOne(ratingId);

		return result;
	}

	public void save(Rating rating) {
		Assert.notNull(rating);

		rating.setCustomer(customerService.findByPrincipal());
		ratingRepository.save(rating);
	}

	public void delete(Rating rating) {
		Assert.notNull(rating);

		ratingRepository.delete(rating);
	}

	// ========== Other Business Methods =============

	public int sumRatings(int routeId) {
		int res;

		res = ratingRepository.sumRatings(routeId);

		return res;
	}

}
