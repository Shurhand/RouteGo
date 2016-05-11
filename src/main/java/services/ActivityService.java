package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.dialect.Cache71Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Category;
import domain.Company;
import domain.Schedule;
import forms.ActivityForm;
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

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ScheduleService scheduleService;

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

		DateUtils.addSeconds(activity.getStartingDate(), 1);
		DateUtils.addSeconds(activity.getEndingDate(), 1);

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

		if (activity.getCompany() != null) {
			Assert.isTrue(activity.getCompany().equals(companyService.findByPrincipal()));
		}

		// Desasignamos la actividad de todas las categorias existentes.
		for (Category c : activity.getCategories()) {
			if (c.getActivities().contains(activity)) {
				c.getActivities().remove(activity);
				categoryService.save(c);
			}
		}

		// Borramos los schedules de la actividad.
		for (Schedule s : activity.getSchedules()) {
			scheduleService.delete(s);
		}
		activity.setCategories(null);

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

	public void assignCompany(Activity activity, Company company) {
		Collection<Activity> companyActivities;

		companyActivities = company.getActivities();

		companyActivities.add(activity);
		company.setActivities(companyActivities);
		companyService.save(company);
	}

	public Activity reconstruct(ActivityForm activityForm) {

		Activity res = new Activity();
		Collection<Schedule> schedules = new ArrayList<>();
		Schedule schedule1 = scheduleService.create();
		Schedule schedule2 = scheduleService.create();
		Schedule schedule3 = scheduleService.create();
		Schedule schedule4 = scheduleService.create();
		Schedule schedule5 = scheduleService.create();
		Schedule schedule6 = scheduleService.create();
		Schedule schedule7 = scheduleService.create();

		if (activityForm.getDayOfWeek1() != null && activityForm.getClosingDate1() != null
				&& activityForm.getOpeningDate1() != null) {
			schedule1.setDayOfWeek(activityForm.getDayOfWeek1());
			schedule1.setOpeningDate(activityForm.getOpeningDate1());
			schedule1.setClosingDate(activityForm.getClosingDate1());
			schedules.add(schedule1);
			schedule1.setActivity(res);

		}

		if (activityForm.getDayOfWeek2() != null && activityForm.getClosingDate2() != null
				&& activityForm.getOpeningDate2() != null) {
			schedule2.setDayOfWeek(activityForm.getDayOfWeek2());
			schedule2.setOpeningDate(activityForm.getOpeningDate2());
			schedule2.setClosingDate(activityForm.getClosingDate2());
			schedules.add(schedule2);
			schedule2.setActivity(res);
		}

		if (activityForm.getDayOfWeek3() != null && activityForm.getClosingDate3() != null
				&& activityForm.getOpeningDate3() != null) {
			schedule3.setDayOfWeek(activityForm.getDayOfWeek3());
			schedule3.setOpeningDate(activityForm.getOpeningDate3());
			schedule3.setClosingDate(activityForm.getClosingDate3());
			schedules.add(schedule3);
			schedule3.setActivity(res);
		}

		if (activityForm.getDayOfWeek4() != null && activityForm.getClosingDate4() != null
				&& activityForm.getOpeningDate4() != null) {
			schedule4.setDayOfWeek(activityForm.getDayOfWeek4());
			schedule4.setOpeningDate(activityForm.getOpeningDate4());
			schedule4.setClosingDate(activityForm.getClosingDate4());
			schedules.add(schedule4);
			schedule4.setActivity(res);
		}

		if (activityForm.getDayOfWeek5() != null && activityForm.getClosingDate5() != null
				&& activityForm.getOpeningDate5() != null) {
			schedule5.setDayOfWeek(activityForm.getDayOfWeek5());
			schedule5.setOpeningDate(activityForm.getOpeningDate5());
			schedule5.setClosingDate(activityForm.getClosingDate5());
			schedules.add(schedule5);
			schedule5.setActivity(res);
		}

		if (activityForm.getDayOfWeek6() != null && activityForm.getClosingDate6() != null
				&& activityForm.getOpeningDate6() != null) {
			schedule6.setDayOfWeek(activityForm.getDayOfWeek6());
			schedule6.setOpeningDate(activityForm.getOpeningDate6());
			schedule6.setClosingDate(activityForm.getClosingDate6());
			schedules.add(schedule6);
			schedule6.setActivity(res);
		}

		if (activityForm.getDayOfWeek7() != null && activityForm.getClosingDate7() != null
				&& activityForm.getOpeningDate7() != null) {
			schedule7.setDayOfWeek(activityForm.getDayOfWeek7());
			schedule7.setOpeningDate(activityForm.getOpeningDate7());
			schedule7.setClosingDate(activityForm.getClosingDate7());
			schedules.add(schedule7);
			schedule7.setActivity(res);
		}

		res.setId(0);
		res.setVersion(0);
		res.setSchedules(schedules);
		res.setCategories(activityForm.getCategories());
		res.setName(activityForm.getName());
		res.setDescription(activityForm.getDescription());
		res.setCost(activityForm.getCost());
		res.setPostalAddress(activityForm.getPostalAddress());
		res.setDuration(activityForm.getDuration());
		res.setLongitude(activityForm.getLongitude());
		res.setLatitude(activityForm.getLatitude());
		res.setPicture(activityForm.getPicture());
		res.setStartingDate(activityForm.getStartingDate());
		res.setEndingDate(activityForm.getEndingDate());

		if (companyService.findByPrincipal() != null) {
			res.setCompany(companyService.findByPrincipal());
		}

		return res;
	}

}