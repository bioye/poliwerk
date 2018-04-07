package ng.nectar.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ng.nectar.model.PollingUnit;
import ng.nectar.model.State;
import ng.nectar.repository.PuRepository;
import ng.nectar.repository.StateRepository;

@Service("puService")
public class PuService { 
	
	private PuRepository puRepository;
	@Autowired
    private StateRepository stateRepository;
	
	@Autowired
	public PuService(PuRepository puRepository) {
		this.puRepository = puRepository;
	}
	
	public PollingUnit findByCode(String code) {
		//System.out.println("puRepository="+puRepository);
		return puRepository.findByPuLocation(code);
	}
	
	public String puToStoredCode(String puCode) {
		//Split string
		String[] codes = Pattern.compile("/").split(puCode);
		if(codes!=null&&codes.length!=4) return null;
		return getStatePrefixFromCode(codes[0])+codes[1]+codes[2]+codes[3];
	}
	
	public String getStatePrefixFromCode(String codeFromPu) {
		State state = stateRepository.findByCode(codeFromPu);
		if(null==state) return null;
		return state.getPrefix();
	}
	
	public String puToCode(String puCode) {
		//Split string
		String[] codes = Pattern.compile("/").split(puCode);
		if(codes!=null&&codes.length!=4) return null;
		return getStatePrefix(getReplacedStateCode(codes[0]))+codes[1]+codes[2]+codes[3];
	}
	
	private String getReplacedStateCode(String puStateCode) {
		String replacedStateCode=puStateCode;
		if	   (puStateCode.equals("06")) replacedStateCode="08";
		else if(puStateCode.equals("07")) replacedStateCode="06";
		else if(puStateCode.equals("08")) replacedStateCode="07";
		else if(puStateCode.equals("18")) replacedStateCode="19";
		else if(puStateCode.equals("19")) replacedStateCode="21";
		else if(puStateCode.equals("20")) replacedStateCode="22";
		else if(puStateCode.equals("21")) replacedStateCode="18";
		else if(puStateCode.equals("22")) replacedStateCode="20";
		else if(puStateCode.equals("25")) replacedStateCode="26";
		else if(puStateCode.equals("26")) replacedStateCode="25";
		else if(puStateCode.equals("27")) replacedStateCode="28";
		else if(puStateCode.equals("28")) replacedStateCode="27";

		return replacedStateCode;
	}
	
	public String getStatePrefix(String stateCode) {
		State state = stateRepository.findByCode(stateCode);
		//System.out.println("stateCode="+stateCode);
		//System.out.println("state="+state);
		if(null==state) return null;
		return state.getPrefix();
	}
	
	/*public String getStateConstName(StateConstituency stateConst) {
		if(null==stateConst)return "";
		return stateConst.getName();
	}
	
	public String getStateConstName(FedConstituency fedConst) {
		if(null==fedConst)return "";
		return fedConst.getName();
	}
	
	public String getSenateName(SenatorialDistrict senate) {
		if(null==senate)return "";
		return senate.getName();
	}
	
	public String getWardName(Ward ward) {
		if(null==ward)return "";
		return ward.getName();
	}*/
	

}