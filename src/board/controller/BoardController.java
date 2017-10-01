package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@RequestMapping(value="/board_list.do")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<BoardDTO> list = boardDAO.boardList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/board/list.jsp");
		mav.addObject("boardList", list);
		return mav;
	}
	
	@RequestMapping(value="/board_writeForm.do", method=RequestMethod.GET)
	public String writeForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "WEB-INF/board/writeForm.jsp";
	}
	
	@RequestMapping(value="/board_writeForm.do", method=RequestMethod.POST)
	public ModelAndView writePro(HttpServletRequest req, @ModelAttribute BoardDTO dto) throws Exception {
		//BoardDTO dto = getBoardDTO(req);
		dto.setIp(req.getRemoteAddr());
		int res = boardDAO.insertBoard(dto);
		return new ModelAndView("redirect:/board_list.do");
	}
	
	@RequestMapping(value="/content.do")
	public ModelAndView content(@RequestParam int num) throws Exception{
		//int num=ServletRequestUtils.getIntParameter(req, "num");
		BoardDTO dto=boardDAO.getBoard(num,"content");
		ModelAndView mav=new ModelAndView("WEB-INF/board/content.jsp","getBoard",dto);
		return mav;
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "WEB-INF/board/deleteForm.jsp";
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public ModelAndView deletePro(@RequestParam int num,@RequestParam String passwd) throws Exception {
		int res=boardDAO.deleteBoard(num, passwd);
		ModelAndView mav=new ModelAndView("redirect:/board_list.do");
		return mav;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam int num) throws Exception {
		BoardDTO dto = boardDAO.getBoard(num, "update");
		ModelAndView mav = new ModelAndView();
		mav.addObject("getBoard", dto);
		mav.setViewName("WEB-INF/board/updateForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView updatePro(@ModelAttribute BoardDTO dto, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			dto.setNum(0);
			dto.setRe_step(0);
			dto.setRe_level(0);
		}
		int res=boardDAO.updateBoard(dto);
		ModelAndView mav=new ModelAndView("redirect:/board_list.do");
		return mav;
	}
	
	/*protected BoardDTO getBoardDTO(HttpServletRequest req) {
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setWriter(req.getParameter("writer"));
		dto.setEmail(req.getParameter("email"));
		dto.setSubject(req.getParameter("subject"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setContent(req.getParameter("content"));
		dto.setRe_step(Integer.parseInt(req.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		return dto;
	}*/
}











