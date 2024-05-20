package kr.co.gudi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	String login(String id, String pw);

	List<MemberDTO> list();

	MemberDTO detail(String idx);

	void bHit(String idx);

	int del(String idx);

	int write(Map<String, Object> param);

}
