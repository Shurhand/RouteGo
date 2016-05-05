package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor {
	// ==============Constructor=============
	public Customer() {
		super();
	}

	// ==============Atributos==============
	private CreditCard creditCard;

	
	@Valid
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	// =============== Relaciones ==============

	private Collection<Route> routes;

	@ManyToMany(mappedBy = "customers")
	public Collection<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(Collection<Route> routes) {
		this.routes = routes;
	}

}
