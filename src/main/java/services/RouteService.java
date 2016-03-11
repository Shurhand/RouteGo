package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Route;
import repositories.RouteRepository;

@Service
@Transactional
public class RouteService {

	public RouteService() {
		super();
	}

	// ========== Managed Repository =================

	@Autowired
	private RouteRepository routeRepository;

	// ========== Supporting services ================

	// ========== Simple CRUD Methods ================

	public Route create() {

		Route result;

		result = new Route();

		return result;
	}

	public Collection<Route> findAll() {

		Collection<Route> result;

		result = routeRepository.findAll();

		return result;
	}

	public Route findOne(int routeId) {
		Assert.notNull(routeId);

		Route result;

		result = routeRepository.findOne(routeId);

		return result;
	}

	public void save(Route route) {
		Assert.notNull(route);

		routeRepository.save(route);
	}

	public void delete(Route route) {
		Assert.notNull(route);

		routeRepository.delete(route);
	}
	
	// ========== Other Business Methods =============

}
