package repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	@Query("select a.name from Activity a where a.startingDate < ?1 and a.endingDate > ?2")
	Collection<Activity> findInDateRange(Date startingDate, Date endingDate);
}
