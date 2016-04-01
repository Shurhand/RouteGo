package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import repositories.ActivityRepository;

@Service
@Transactional
public class ActivityService {

	public ActivityService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private ActivityRepository activityRepository;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Activity create() {

		Activity result;

		result = new Activity();

		return result;
	}

	public Collection<Activity> findAll() {

		Collection<Activity> result;

		result = activityRepository.findAll();

		return result;
	}

	public Activity findOne(int activityId) {
		Assert.notNull(activityId);

		Activity result;

		result = activityRepository.findOne(activityId);

		return result;
	}

	public void save(Activity activity) {
		Assert.notNull(activity);

		activityRepository.save(activity);
	}

	public void delete(Activity activity) {
		Assert.notNull(activity);

		activityRepository.delete(activity);
	}

	// ========== Other Business Methods =============

	public Collection<Activity> findInDateRange(Date startingDate, Date endingDate) {
		Assert.notNull(startingDate);
		Assert.notNull(endingDate);

		Collection<Activity> res;
		Collection<Activity> all;

		res = new ArrayList<>();

		// res = activityRepository.findInDateRange(startingDate, endingDate);
		all = activityRepository.findAll();

		for (Activity a : all) {
			if (a.getStartingDate().before(startingDate) && a.getEndingDate().after(endingDate)) {
				res.add(a);
			}
		}

		return res;
	}

}