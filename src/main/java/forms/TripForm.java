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
	
	private Date startingDate;
	private Date endDate;
	private Double cost;
	private Collection<Activity> activities;
	private Boolean checkCulturalCategory;
	private Boolean checkMuseumsCategory;
	private Boolean checkChurchesCategory;
	private Boolean checkRestaurantsCategory;
	private Boolean checkDrinksCategory;
	private Boolean checkPaintingsCategory;
	private Boolean checkMusicCategory;
	private Boolean checkMonumentsCategory;
	
	
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
	public Boolean getCheckDrinksCategory() {
		return checkDrinksCategory;
	}
	public void setCheckDrinksCategory(Boolean checkDrinksCategory) {
		this.checkDrinksCategory = checkDrinksCategory;
	}
	public Boolean getCheckPaintingsCategory() {
		return checkPaintingsCategory;
	}
	public void setCheckPaintingsCategory(Boolean checkPaintingsCategory) {
		this.checkPaintingsCategory = checkPaintingsCategory;
	}
	public Boolean getCheckMusicCategory() {
		return checkMusicCategory;
	}
	public void setCheckMusicCategory(Boolean checkMusicCategory) {
		this.checkMusicCategory = checkMusicCategory;
	}
	public Boolean getCheckMonumentsCategory() {
		return checkMonumentsCategory;
	}
	public void setCheckMonumentsCategory(Boolean checkMonumentsCategory) {
		this.checkMonumentsCategory = checkMonumentsCategory;
	}
	
	
	
	
}
