package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Category;
import domain.Schedule;
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

	@Autowired
	private CategoryService categoryService;

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

		Collection<Category> categories;

		categories = activity.getCategories();

		for (Category c : categories) {
			c.getActivities().add(activity);
			categoryService.save(c);
		}
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
		Collection<Activity> r1;
		Collection<Activity> all;

		r1 = new ArrayList<>();
		res = new ArrayList<>();

		// res = activityRepository.findInDateRange(startingDate, endingDate);
		all = activityRepository.findAll();

		Calendar c = Calendar.getInstance();
		c.setTime(startingDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		System.out.println(dayOfWeek);

		// Primero filtra por fecha.
		for (Activity a : all) {
			if (a.getStartingDate().before(startingDate) && a.getEndingDate().after(endingDate)) {
				r1.add(a);
			}
		}

		// Luego comprueba el dia de la semana.
		for (Activity ac : r1) {
			Collection<Schedule> schedules = ac.getSchedules();
			for (Schedule s : schedules) {
				if ((s.getDayOfWeek().getValue() + 1) == dayOfWeek) {
					res.add(ac);
				}
			}
		}

		return res;
	}

	public Collection<Activity> findByCompanyId(int companyId) {

		Collection<Activity> res;

		res = activityRepository.findByCompanyId(companyId);

		return res;
	}

}