package kr.co.photo.board.dao;

import java.util.List;
import java.util.Map;

import kr.co.photo.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int write(Map<String, String> param);

	BoardDTO detail(String idx);

	void bHit(String idx);

	int update(Map<String, String> param);

	int del(String idx);

}
