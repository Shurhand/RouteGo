package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class Company extends Actor{

	private String CIF;

	@NotEmpty
	@Column(unique = true)
	@Pattern(regexp = "([a-z]|[A-Z]){1}\\d{7}\\w{1}")
	public String getCIF() {
		return CIF;
	}
	
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	
	//============ Relaciones ===================

	private Collection<Activity> activities;
	
	@OneToMany(mappedBy = "company")
	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}
	
}
