package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Company;
import repositories.CompanyRepository;

@Component
@Transactional
public class StringToCompanyConverter implements Converter<String, Company> {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company convert(String text) {
		Company res;
		int id;
		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = companyRepository.findOne(id);
			}
		} catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
