package board.dao;

import java.util.List;

import board.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> boardList();
	public BoardDTO getBoard(int num, String mode);
	public int insertBoard(BoardDTO dto);
	public int deleteBoard(int num, String passwd);
	public int updateBoard(BoardDTO dto);	
}
