package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	public Comment() {
		super();
	}

	private Date moment;
	private String text;
	private String user;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@NotEmpty
	@Max(200)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@NotEmpty
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	// // =============== Relaciones ==============

	private Route route;

	@NotNull
	@ManyToOne(optional = false)
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}
