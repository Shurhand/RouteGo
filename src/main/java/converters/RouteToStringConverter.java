package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Route;

@Component
@Transactional
public class RouteToStringConverter implements Converter<Route, String> {

	@Override
	public String convert(Route route) {
		String res;

		if (route == null)
			res = null;
		else
			res = String.valueOf(route.getId());

		return res;

	}

}
