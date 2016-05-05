package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Customer;
import domain.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
	
	@Query("select c.routes from Customer c where c = ?1")
	Collection<Route> findRoutesByCustomer(Customer customer);
	
	@Query("select r from Route r where r.isRandom=false")
	Collection<Route> findAllCustom();


}