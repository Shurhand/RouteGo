package converters;

import java.time.DayOfWeek;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DayOfWeekToStringConverter implements Converter<DayOfWeek, String> {

	@Override
	public String convert(DayOfWeek source) {
		return source.name();
	}

}
