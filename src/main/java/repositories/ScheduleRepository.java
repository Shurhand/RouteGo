package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query("select a.schedules from Activity a where a.id= ?1")
	Collection<Schedule> findByActivityId(int activityId);

}
