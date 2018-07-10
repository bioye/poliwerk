package ng.nectar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nectar.model.StateConstituency;

@Repository("stateConstRepository")
public interface StateConstRepository extends JpaRepository<StateConstituency, Integer> {
	StateConstituency findByCode(String code);
	
}