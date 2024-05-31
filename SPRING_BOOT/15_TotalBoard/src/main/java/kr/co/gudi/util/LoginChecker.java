package kr.co.gudi.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// autowired 는 헤야계는데 Service 는 아니므로...
@Component
public class LoginChecker implements HandlerInterceptor{ // HandlerInterceptor : 메서드를 오버라이드 받기 위해서
	
	Logger logger = LoggerFactory.getLogger(getClass());

	
	// 컨트롤러를 거치기전에 이곳을 들른다
	// 반환값이 false 면 컨트롤러에 접근 할 수 없다.(하얀화면을 보여줌)
	// 그래서 false 로 컨트롤러에 가지 못하게 한 다음 response 를 이용해서 다른곳으로 보내는게 일반적이다
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		boolean pass = true;
		logger.info("=== PRE HANDLER ===");
		
		HttpSession session = req.getSession();
		
		if (session.getAttribute("loginId")==null) {
			pass = false;
			resp.sendRedirect("/"); //context 결로가 있다면 같이 넣어줘야 한다. /15_TotalBoard
		}
		
		
		return pass;
	}

	
	// 컨트롤러에 접근 할 후 뷰에 보내지기전 들른다.
	// 뷰에 보내고 싶은 내용이 있다면 ModelAndView 에 넣어준면 된다.
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler,
			ModelAndView mav) throws Exception {
		logger.info("=== POST HANDLER ===");
		
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");
		mav.addObject("loginid",loginId);
		
	}
	
	
	
	

}
