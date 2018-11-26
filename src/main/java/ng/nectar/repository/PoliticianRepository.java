package ng.nectar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nectar.model.Politician;

@Repository("politicianRepository")
public interface PoliticianRepository extends JpaRepository<Politician, Integer> {
	Politician findById(String id);
}