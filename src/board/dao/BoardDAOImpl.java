package board.dao;

import java.util.List;


import board.dto.BoardDTO;
import board.mybatis.BoardMapper;

public class BoardDAOImpl implements BoardDAO {
	
	@Override
	public List<BoardDTO> boardList() {
		return BoardMapper.listBoard();
	}
	
	public void plusReadCount(int num) {
		BoardMapper.plusReadcount(num);
	}
	
	@Override
	public BoardDTO getBoard(int num, String mode) {
		if(mode.equals("content")) {
			plusReadCount(num);
		}
		return BoardMapper.getBoard(num);
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		String sql=null;
		if(dto.getNum()==0) {
			sql="update spring_board set re_step=re_step+1";
		}else {
			sql="update spring_board set re_step=re_step+1 where re_step>"+dto.getRe_step();
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_level(dto.getRe_level()+1);
		}
		BoardMapper.plusRe_step(sql);
		return BoardMapper.insertBoard(dto);
	}
	
	protected boolean isPassword(int num,String passwd){
		BoardDTO dto=BoardMapper.getBoard(num);
		if(dto.getPasswd().equals(passwd)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int deleteBoard(int num, String passwd) {
		if(isPassword(num,passwd)) {
			return BoardMapper.deleteBoard(num);
			//return SimpleExample.deleteBoard(num);
		}else {
			return -1;
		}
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		if(isPassword(dto.getNum(),dto.getPasswd())) {
			return BoardMapper.updateBoard(dto);
			//return SimpleExample.updateBoard(dto);
		}else {
			return -1;
		}
	}

}
