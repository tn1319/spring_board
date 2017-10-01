package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardListController implements Controller{
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		List<BoardDTO> list=boardDAO.boardList();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("WEB-INF/board/list.jsp");//다음페이지로 이동할 곳을 적어준다
		mav.addObject("boardList",list);//request 창고에 저장을 시켜준다
		return mav;
		//return new ModelAndView("WEB-INF/board/list.jsp","boardList",list);
	}

}
