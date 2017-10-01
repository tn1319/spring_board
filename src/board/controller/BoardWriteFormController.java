package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BoardWriteFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView("WEB-INF/board/writeForm.jsp");
	}
	//ModelAndView 클래스의 생성자
	//- 1. ModelAndView() : default생성자, 이동할 곳을 setViewName()메소드로 입력해줘야한다.
	//- 2. ModelAndView(String url) : 이동할 곳을 매개변수로 입력해준다.
	//- 3. ModelAndView(String url, String key, Object value) : 이동할 곳과 넘겨줄 값까지 생성자의 매개변수로 입력해준다.
}
