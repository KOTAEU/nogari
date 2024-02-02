package nogari.system.commcd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nogari.system.commcd.dao.mapper.CommCdMapper;
import nogari.system.commcd.domain.dto.ClsCdDTO;
import nogari.system.commcd.domain.dto.CodeCdDTO;

@Service("commCdService")
@Transactional
public class CommCdServiceImpl implements CommCdService {
	@Resource
	private CommCdMapper mapper;
	
	public List<ClsCdDTO> selectClsCd(ClsCdDTO dto) throws Exception {
		
		return mapper.selectClsCd(dto);
	}
	
	public List<CodeCdDTO> selectCodeCd(CodeCdDTO dto) throws Exception {
		
		return mapper.selectCodeCd(dto);
	}
	
	public String insertClsCd(ClsCdDTO dto) throws Exception {
		if(mapper.selectClsCdChk(dto)!=0) {
			return dto.getClsCd() + " : 중복 코드";
		}else {
			mapper.insertClsCd(dto);
			return "insert 완료";
		}
	}
	
	public String insertCodeCd(List<CodeCdDTO> list) throws Exception {
		String result = "";
		for(CodeCdDTO dto : list)
			if(mapper.selectCodeCdChk(dto)!=0) {
				result += dto.getCodeCd() + " : 중복 코드\n";
			}else {
				mapper.insertCodeCd(dto);
				result += dto.getCodeCd() + " : 저장 완료\n";
			}
		return result;
	}
	
	public String deleteClsCd(ClsCdDTO dto) throws Exception {
		
		mapper.deleteClsCd(dto);
		
		return "delete 완료";
	}
	
	public String deleteCodeCd(CodeCdDTO dto) throws Exception {
		
		mapper.deleteCodeCd(dto);
		
		return "delete 완료";
	}
	
	public String updateClsCd(ClsCdDTO dto) throws Exception {
		
		mapper.updateClsCd(dto);
		
		return "update 완료";
	}
	
	public String updateCodeCd(CodeCdDTO dto) throws Exception {
		
		mapper.updateCodeCd(dto);
		
		return "update 완료";
	}
}
