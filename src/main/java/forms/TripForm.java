package forms;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import domain.Activity;
import domain.Category;

public class TripForm {

	public TripForm(){
		super();
	}
	
	private Integer id;
	private Integer version;
	private Date startingDate;
	private Date endDate;
	private Double cost;
	private Collection<Activity> activities;
	private Boolean checkCulturalCategory;
	private Boolean checkMuseumsCategory;
	private Boolean checkChurchesCategory;
	private Boolean checkRestaurantsCategory;
	
	@NotNull
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Min(0)
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	//Categories
	
	public Collection<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}
	public Boolean getCheckCulturalCategory() {
		return checkCulturalCategory;
	}
	public void setCheckCulturalCategory(Boolean checkCulturalCategory) {
		this.checkCulturalCategory = checkCulturalCategory;
	}
	public Boolean getCheckMuseumsCategory() {
		return checkMuseumsCategory;
	}
	public void setCheckMuseumsCategory(Boolean checkMuseumsCategory) {
		this.checkMuseumsCategory = checkMuseumsCategory;
	}
	public Boolean getCheckChurchesCategory() {
		return checkChurchesCategory;
	}
	public void setCheckChurchesCategory(Boolean checkChurchesCategory) {
		this.checkChurchesCategory = checkChurchesCategory;
	}
	public Boolean getCheckRestaurantsCategory() {
		return checkRestaurantsCategory;
	}
	public void setCheckRestaurantsCategory(Boolean checkRestaurantsCategory) {
		this.checkRestaurantsCategory = checkRestaurantsCategory;
	}
	
	
	
	
}
