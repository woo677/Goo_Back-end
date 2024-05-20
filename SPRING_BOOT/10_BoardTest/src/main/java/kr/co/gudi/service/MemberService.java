package kr.co.gudi.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MemberDAO dao;

	public String login(String id, String pw) {
		String re = "";
		String row = "";
		row = dao.login(id,pw);
		if (!row.equals(null)) {
			re = row; 
		}
		logger.info(row);
		
		
		return re;
	}

	public List<MemberDTO> list() {
		
		return dao.list();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public MemberDTO detail(String idx) {
		dao.bHit(idx);
		return dao.detail(idx);
	}

	public int del(String idx) {
		return dao.del(idx);
	}

	public ModelAndView write(Map<String, Object> param) {
		ModelAndView mav = new ModelAndView();
		int row = 0;
		row = dao.write(param);
		logger.info("row"+row);
		mav.setViewName("redirect:/list");
		
		
		return mav;
	}


}
