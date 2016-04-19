package domain;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Schedule extends DomainEntity {

	public Schedule() {
		super();
	}

	private DayOfWeek dayOfWeek;
	private Date openingDate;
	private Date closingDate;

	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	
	@NotNull
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	// ========================= Relationships ======================

	private Activity activity;

	@ManyToOne(optional = false)
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
