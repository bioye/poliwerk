package ng.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ng.nectar.model.Official;
import ng.nectar.model.StateConstituency;
import ng.nectar.repository.StateConstRepository;

@Service("stateConstService")
public class StateConstService {
	
	private StateConstRepository stateConstRepository;
	
	@Autowired
	public StateConstService(StateConstRepository stateConstRepository) {
		this.stateConstRepository = stateConstRepository;
	}
	
	/*public Official getHonourable(Integer id) {
		Query query = entityManager.createQuery(
			    "select p " +
			    "from Person p " +
			    "where p.name like :name" )
			.setParameter( "name", "J%" );
	}*/
	
	public StateConstituency getStateConst(Integer id) {
		return stateConstRepository.getOne(id);
	}

}
