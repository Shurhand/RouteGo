package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Schedule;

@Component
@Transactional
public class ScheduleToStringConverter implements Converter<Schedule, String>{
	
	@Override
	public String convert(Schedule schedule) {
		String res;

		if (schedule == null)
			res = null;
		else
			res = String.valueOf(schedule.getId());

		return res;

	}

}
