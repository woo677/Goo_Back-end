package kr.co.gudi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.teamDTO;

@Mapper
public interface MainDAO {

	List<teamDTO> getTeamList();

	void update(Map<String, String> param);

//	void update(String col, String val, String pk);
	






}
