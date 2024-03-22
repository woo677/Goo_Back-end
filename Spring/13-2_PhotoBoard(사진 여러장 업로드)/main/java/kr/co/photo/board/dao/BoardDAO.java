package kr.co.photo.board.dao;

import java.util.List;
import java.util.Map;

import kr.co.photo.board.dto.BoardDTO;
import kr.co.photo.board.dto.PhotoDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int write(BoardDTO dto);

	BoardDTO detail(String idx);

	void bHit(String idx);

	int update(Map<String, String> param);

	int del(String idx);

	void fileWrite(String fileName, String newFileName, int idx);

	List<PhotoDTO> photos(String idx);

}
