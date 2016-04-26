package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Schedule;
import services.ActivityService;
import services.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController extends AbstractController {

	// =============== Services ===================

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private ActivityService activityService;
	
	// Listing ---------------------------------------------------------

		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list(@RequestParam int activityId) {

			ModelAndView result;
			Collection<Schedule> schedules;

			schedules = scheduleService.findByActivityId(activityId);

			result = new ModelAndView("schedule/list");
			result.addObject("schedules", schedules);
			result.addObject("requestURI", "schedules/list.do");

			return result;

		}

	// =============== Creation ===================

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;

		Schedule schedule = scheduleService.create();

		res = createEditModelAndView(schedule);
		return res;
	}

	// =============== Edition ====================

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int scheduleId) {

		ModelAndView result;
		Schedule schedule;

		schedule = scheduleService.findOne(scheduleId);
		Assert.notNull(schedule);
		result = createEditModelAndView(schedule);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute Schedule schedule, BindingResult binding) {

		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(schedule, binding.toString());
		} else {
			try {
				scheduleService.save(schedule);
				result = new ModelAndView("redirect:/");
			} catch (Throwable oops) {
				result = createEditModelAndView(schedule, "schedule.commit.error");
			}
		}
		return result;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Schedule schedule, BindingResult binding) {

		ModelAndView result;

		try {
			scheduleService.delete(schedule);
			result = new ModelAndView("redirect:list.do");
		} catch (Throwable oops) {
			result = createEditModelAndView(schedule, "schedule.commit.error");
		}
		return result;

	}

	// =============== Ancillary Methods ==========

	protected ModelAndView createEditModelAndView(Schedule schedule) {
		ModelAndView res;

		res = createEditModelAndView(schedule, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(Schedule schedule, String message) {
		ModelAndView res;

		Collection<Activity> activities;

		activities = activityService.findAll();
		res = new ModelAndView("schedule/edit");
		res.addObject("schedule", schedule);
		res.addObject("activities", activities);
		res.addObject("message", message);

		return res;
	}

}