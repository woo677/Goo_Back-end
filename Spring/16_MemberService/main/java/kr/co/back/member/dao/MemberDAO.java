package kr.co.back.member.dao;

import java.util.Map;

public interface MemberDAO {

	String login(String id, String pw);

	int overlay(String id);

	int joinForm(Map<String, String> param);


}
