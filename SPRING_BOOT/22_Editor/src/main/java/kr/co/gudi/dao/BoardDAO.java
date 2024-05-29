package kr.co.gudi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.BoardDTO;

@Mapper
public interface BoardDAO {

	int write(Map<String, String> param);

	List<BoardDTO> list();

	BoardDTO detail(String idx);

}
