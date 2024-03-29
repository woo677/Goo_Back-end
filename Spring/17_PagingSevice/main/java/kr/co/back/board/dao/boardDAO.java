package kr.co.back.board.dao;

import java.util.List;

import kr.co.back.board.dto.BoardDTO;

public interface boardDAO {

	List<BoardDTO> list(int pageParCnt, int start);

	List<String> getFilse(String idx);

	int del(String idx);

	int allCount(int pageParCnt);


}
