package ng.nectar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nectar.model.Ward;


@Repository("wardRepository")
public interface WardRepository extends JpaRepository<Ward, Integer> {
	Ward findByCode(String code);
}