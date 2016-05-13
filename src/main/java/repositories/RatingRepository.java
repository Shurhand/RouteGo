package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	@Query("select sum(rat.rating) from Route r join r.ratings rat where r.id = ?1")
	int sumRatings(int routeId);

}
