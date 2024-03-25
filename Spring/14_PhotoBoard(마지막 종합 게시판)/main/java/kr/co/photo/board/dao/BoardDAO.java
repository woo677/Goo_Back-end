package kr.co.photo.board.dao;

import java.util.List;

import kr.co.photo.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int write(BoardDTO dto);

	void writePhoto(int idx, String oriFileName, String newFileName);

}
