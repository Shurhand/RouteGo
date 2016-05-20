package forms;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import domain.Category;

public class ActivityForm {

	public ActivityForm() {
		super();
	}

	private String name;
	private String description;
	private Double cost;
	private String postalAddress;
	private URL picture;
	private Double duration;
	private Date startingDate;
	private Date endingDate;
	private Collection<Category> categories;

	private DayOfWeek dayOfWeek1;
	private Date openingDate1;
	private Date closingDate1;

	private DayOfWeek dayOfWeek2;
	private Date openingDate2;
	private Date closingDate2;

	private DayOfWeek dayOfWeek3;
	private Date openingDate3;
	private Date closingDate3;

	private DayOfWeek dayOfWeek4;
	private Date openingDate4;
	private Date closingDate4;

	private DayOfWeek dayOfWeek5;
	private Date openingDate5;
	private Date closingDate5;

	private DayOfWeek dayOfWeek6;
	private Date openingDate6;
	private Date closingDate6;

	private DayOfWeek dayOfWeek7;
	private Date openingDate7;
	private Date closingDate7;

	// Schedules
	public DayOfWeek getDayOfWeek1() {
		return dayOfWeek1;
	}

	public void setDayOfWeek1(DayOfWeek dayOfWeek1) {
		this.dayOfWeek1 = dayOfWeek1;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate1() {
		return openingDate1;
	}

	public void setOpeningDate1(Date openingDate1) {
		this.openingDate1 = openingDate1;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate1() {
		return closingDate1;
	}

	public void setClosingDate1(Date closingDate1) {
		this.closingDate1 = closingDate1;
	}

	public DayOfWeek getDayOfWeek2() {
		return dayOfWeek2;
	}

	public void setDayOfWeek2(DayOfWeek dayOfWeek2) {
		this.dayOfWeek2 = dayOfWeek2;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate2() {
		return openingDate2;
	}

	public void setOpeningDate2(Date openingDate2) {
		this.openingDate2 = openingDate2;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate2() {
		return closingDate2;
	}

	public void setClosingDate2(Date closingDate2) {
		this.closingDate2 = closingDate2;
	}

	public DayOfWeek getDayOfWeek3() {
		return dayOfWeek3;
	}

	public void setDayOfWeek3(DayOfWeek dayOfWeek3) {
		this.dayOfWeek3 = dayOfWeek3;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate3() {
		return openingDate3;
	}

	public void setOpeningDate3(Date openingDate3) {
		this.openingDate3 = openingDate3;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate3() {
		return closingDate3;
	}

	public void setClosingDate3(Date closingDate3) {
		this.closingDate3 = closingDate3;
	}

	public DayOfWeek getDayOfWeek4() {
		return dayOfWeek4;
	}

	public void setDayOfWeek4(DayOfWeek dayOfWeek4) {
		this.dayOfWeek4 = dayOfWeek4;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate4() {
		return openingDate4;
	}

	public void setOpeningDate4(Date openingDate4) {
		this.openingDate4 = openingDate4;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate4() {
		return closingDate4;
	}

	public void setClosingDate4(Date closingDate4) {
		this.closingDate4 = closingDate4;
	}

	public DayOfWeek getDayOfWeek5() {
		return dayOfWeek5;
	}

	public void setDayOfWeek5(DayOfWeek dayOfWeek5) {
		this.dayOfWeek5 = dayOfWeek5;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate5() {
		return openingDate5;
	}

	public void setOpeningDate5(Date openingDate5) {
		this.openingDate5 = openingDate5;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate5() {
		return closingDate5;
	}

	public void setClosingDate5(Date closingDate5) {
		this.closingDate5 = closingDate5;
	}

	public DayOfWeek getDayOfWeek6() {
		return dayOfWeek6;
	}

	public void setDayOfWeek6(DayOfWeek dayOfWeek6) {
		this.dayOfWeek6 = dayOfWeek6;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate6() {
		return openingDate6;
	}

	public void setOpeningDate6(Date openingDate6) {
		this.openingDate6 = openingDate6;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate6() {
		return closingDate6;
	}

	public void setClosingDate6(Date closingDate6) {
		this.closingDate6 = closingDate6;
	}

	public DayOfWeek getDayOfWeek7() {
		return dayOfWeek7;
	}

	public void setDayOfWeek7(DayOfWeek dayOfWeek7) {
		this.dayOfWeek7 = dayOfWeek7;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getOpeningDate7() {
		return openingDate7;
	}

	public void setOpeningDate7(Date openingDate7) {
		this.openingDate7 = openingDate7;
	}

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	public Date getClosingDate7() {
		return closingDate7;
	}

	public void setClosingDate7(Date closingDate7) {
		this.closingDate7 = closingDate7;
	}

	// Otros

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@NotNull
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@NotEmpty
	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public URL getPicture() {
		return picture;
	}

	public void setPicture(URL picture) {
		this.picture = picture;
	}

	@NotNull
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

}
