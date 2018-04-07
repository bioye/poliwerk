package ng.nectar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nectar.model.PollingUnit;


@Repository("puRepository")
public interface PuRepository extends JpaRepository<PollingUnit, Integer> {
	 PollingUnit findByCode(String code);
	 PollingUnit findByPuLocation(String loc_id);
}