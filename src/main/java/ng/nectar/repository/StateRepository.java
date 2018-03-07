package ng.nectar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ng.nectar.model.State;

@Repository("stateRepository")
public interface StateRepository extends JpaRepository<State, Integer> {
	State findByCode(String code);
}