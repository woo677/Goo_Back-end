package kr.co.gudi.board.dao;

import java.util.List;

import kr.co.gudi.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int del(String idx);

}
