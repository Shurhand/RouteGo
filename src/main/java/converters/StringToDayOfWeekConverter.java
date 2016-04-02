package converters;

import java.time.DayOfWeek;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StringToDayOfWeekConverter implements Converter<String, DayOfWeek> {

	@Override
	public DayOfWeek convert(String source) {
		return DayOfWeek.valueOf(source);
	}
}
