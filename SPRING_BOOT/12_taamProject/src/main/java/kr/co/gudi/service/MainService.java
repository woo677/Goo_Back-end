package kr.co.gudi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.gudi.dao.MainDAO;
import kr.co.gudi.dto.teamDTO;

@Service
public class MainService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired MainDAO dao;

	public  Map<String, Object> getTeamList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<teamDTO> list = dao.getTeamList();		
		
		map.put("list", list);
		
		return map;

	}

	public void update(Map<String, String> param) {
		logger.info("update 요청 : "+param);
		String col = param.get("col");
		String val = param.get("val");
		String pk = param.get("pk");
		logger.info("update 요청 : "+col);
		logger.info("update 요청 : "+val);
		logger.info("update 요청 : "+pk);
//		dao.update(col,val,pk);
		dao.update(param);
		
		
	}





}
