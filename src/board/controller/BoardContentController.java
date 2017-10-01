package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class BoardContentController implements Controller {
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO=boardDAO;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int num=ServletRequestUtils.getIntParameter(arg0, "num");
		BoardDTO dto=boardDAO.getBoard(num,"content");
		ModelAndView mav=new ModelAndView("WEB-INF/board/content.jsp","getBoard",dto);
		return mav;
	}

}
