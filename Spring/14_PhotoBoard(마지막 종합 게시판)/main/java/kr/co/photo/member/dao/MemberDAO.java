package kr.co.photo.member.dao;

import java.util.List;
import java.util.Map;

import kr.co.photo.member.dto.MemberDTO;

public interface MemberDAO {

	int join(Map<String, String> param);

	String login(String id, String pw);

	List<MemberDTO> memberList();

}
