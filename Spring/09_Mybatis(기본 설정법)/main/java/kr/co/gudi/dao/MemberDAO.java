package kr.co.gudi.dao;

import java.util.List;
import java.util.Map;

import kr.co.gudi.dto.MemberDTO;

public interface MemberDAO {

	int join(Map<String, String> param);

	String login(String id, String pw);

	// 만약 결과 값이 한개라면 List를 사용하지 않으면 된
	List<MemberDTO> list();

	MemberDTO detali(String id);

	int del(String id);

	
}
