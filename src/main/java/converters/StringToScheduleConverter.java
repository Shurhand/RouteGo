package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Schedule;
import repositories.ScheduleRepository;

@Component
@Transactional
public class StringToScheduleConverter implements Converter<String, Schedule> {

	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public Schedule convert(String text) {
		Schedule res;
		int id;
		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = scheduleRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
