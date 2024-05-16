package kr.co.gudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.BoardDTO;

//<!--mybatis 를 자동으로 연결해 주는 설정 -->	
//<mybatis-spring:scan base-package="kr.co.photo.**.dao"/>
// 얘 대신임

// 자동으로 마이바티스를 사용하는 설정이 된다
@Mapper
public interface MainDAO {

	List<BoardDTO> list();

}
