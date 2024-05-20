package kr.co.gudi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.BoardDAO;
import kr.co.gudi.dto.BoardDTO;


@Service
public class BoardService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired BoardDAO dao;

	public ModelAndView getBBSList() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = dao.getBBSList();		
		
		
		if(list != null || list.size() > 0) {
			logger.info("size: "+list.size());
			mav.addObject("list",list);
		}else {
			mav.addObject("msg","게스트 리스트가 없습니다.");			
		}
		mav.setViewName("list");
		
		return mav;
	}

	//트랜잭션이 필요한 독에 어노테이션을 추가하면 된다.
//	@Transactional : 모든 잌셉션을 처리한다 
//	특정 예외에 대해서만 크랜잭션 처리 해라
//	기본 : Exception.class
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView detail(String idx) {
//		try-catch 를 사용하면 롤백되지 않는다.
//		그래서 예외처리를 하기 위한 다른 방법을 사용 한다 (EX : 스프린 : 500,400에러가 떨어지면 특정 페이지로 이동)
//		스프링의 경우는 web.xml 을 통해서 특정 예외나 500 에러가 떨어지면 특정 페이지나 컨트롤러를 호출한다
//		하지만 부트는 web.xml 이 없다(그래서 부트는 다른 방식을 사용한다)
		ModelAndView mav = new ModelAndView("detail");
		dao.bHit(idx);
		BoardDTO dto = dao.detail(idx);
		mav.addObject("bbs",dto);
		return mav;
	}
}
