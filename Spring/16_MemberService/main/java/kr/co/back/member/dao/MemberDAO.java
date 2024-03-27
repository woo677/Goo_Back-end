package kr.co.back.member.dao;

public interface MemberDAO {

	String login(String id, String pw);

	int overlay(String id);


}
