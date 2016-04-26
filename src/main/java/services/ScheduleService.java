package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Schedule;
import repositories.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {

	public ScheduleService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private ScheduleRepository scheduleRepository;

	// ========== Supporting services ================

	@Autowired
	private ActivityService activityService;

	// ========== Simple CRUD Methods ================

	public Schedule create() {

		Schedule result;

		result = new Schedule();

		return result;
	}

	public Collection<Schedule> findAll() {

		Collection<Schedule> result;

		result = scheduleRepository.findAll();

		return result;
	}

	public Schedule findOne(int scheduleId) {
		Assert.notNull(scheduleId);

		Schedule result;

		result = scheduleRepository.findOne(scheduleId);

		return result;
	}

	public void save(Schedule schedule) {
		Assert.notNull(schedule);

		scheduleRepository.save(schedule);

		Activity activity;
		Collection<Schedule> schedules;

		activity = schedule.getActivity();
		schedules = activity.getSchedules();
		schedules.add(schedule);

		activityService.save(activity);
	}

	public void delete(Schedule schedule) {
		Assert.notNull(schedule);

		scheduleRepository.delete(schedule);
	}

	// ========== Other Business Methods =============

	public Collection<Schedule> findByActivityId(int activityId) {

		Collection<Schedule> res;

		res = scheduleRepository.findByActivityId(activityId);

		return res;
	}

}
