package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Company;

@Component
@Transactional
public class CompanyToStringConverter implements Converter<Company, String> {

	@Override
	public String convert(Company company) {
		String res;

		if (company == null)
			res = null;
		else
			res = String.valueOf(company.getId());

		return res;

	}

}
