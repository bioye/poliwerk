package ng.nectar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ng.nectar.model.Politician;
import ng.nectar.repository.PoliticianRepository;

@Service("politicianService")
public class PoliticianService {
	
	public List<Politician> getAll(){
		return politicianRepository.findAll();
	}

	private PoliticianRepository politicianRepository;
	
	@Autowired
	public PoliticianService(PoliticianRepository politicianRepository) {
		this.politicianRepository = politicianRepository;
	}
	
	public Politician getPolitician(Integer id) {
		return politicianRepository.getOne(id);
	}
	
}
