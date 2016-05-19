package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Route extends DomainEntity {

	public Route() {
		super();
	}

	public Route(Route r) {
		this.name = r.getName();
		this.description = r.getDescription();
		this.startingDate = r.getStartingDate();
		this.endDate = r.getEndDate();
		this.isRandom = r.getIsRandom();
		this.price = r.getPrice();
		this.rating = r.getRating();
		this.categories = r.getCategories();
		this.activities = r.getActivities();
		this.comments = r.getComments();
		this.customers = r.getCustomers();

	}

	private String name;
	private Date startingDate;
	private Date endDate;
	private String description;
	private Double rating;
	private boolean isRandom;
	private Double price;
	private String details;

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Range(min = 0, max = 5)
	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	@NotNull
	public boolean getIsRandom() {
		return isRandom;
	}

	public void setIsRandom(boolean isRandom) {
		this.isRandom = isRandom;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	// ========================= Relationships ======================

	private Collection<Category> categories;
	private Collection<Customer> customers;
	private Collection<Comment> comments;
	private Collection<Activity> activities;
	private Collection<Rating> ratings;
	private Customer owner;

	@NotNull
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}

	@NotNull
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}

	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Collection<Rating> ratings) {
		this.ratings = ratings;
	}

	@Valid
	@ManyToOne(optional = true)
	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

}
