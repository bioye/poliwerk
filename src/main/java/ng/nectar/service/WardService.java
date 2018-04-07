package ng.nectar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ng.nectar.model.Ward;
import ng.nectar.repository.WardRepository;

@Service("wardService")
public class WardService {
	
	private WardRepository wardRepository;
	
	@Autowired
	public WardService(WardRepository wardRepository) {
		this.wardRepository = wardRepository;
	}
	
	public Ward getWard(Integer id) {
		return wardRepository.getOne(id);
	}

}
