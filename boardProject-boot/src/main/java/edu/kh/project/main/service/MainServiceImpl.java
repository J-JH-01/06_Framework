package edu.kh.project.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.main.mapper.MainMapper;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class MainServiceImpl implements MainService{

	@Autowired	// 의존성 주입(DI)
	private MainMapper mapper;
	
	@Autowired	// bean으로 만들어 놨었음
	private BCryptPasswordEncoder bcrypt;
	
	// 리스트 출력용
	@Override
		public List<Member> viewList() {
			return mapper.viewList();
		}
	
	@Override
	public int resetPass(String memberNo) {
		String bcryptPassword = bcrypt.encode("pass01!");
		
		log.debug(bcryptPassword);
		
		Map<String, Object> params = new HashMap<>();
	    params.put("memberNo", memberNo);
	    params.put("bcryptPassword", bcryptPassword);
	    
	    log.debug(params.toString());
		return mapper.resetPass(params);
	}
	
	@Override
	public int restoration(String memberNo) {
		return mapper.restoration(memberNo);
	}
	
	
	
	
	
	
	
}
