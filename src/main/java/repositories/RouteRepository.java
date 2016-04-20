package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
	
	@Query("select r from Route r where r.customer.id = ?1")
	Collection<Route> findByCustomerId(int customerId);


}