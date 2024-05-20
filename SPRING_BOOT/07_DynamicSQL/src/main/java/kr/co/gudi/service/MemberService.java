package kr.co.gudi.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gudi.dao.MemberDAO;
import kr.co.gudi.dto.MemberDTO;

@Service
public class MemberService {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired MemberDAO dao;
	
	public ModelAndView join(MemberDTO dto) {
	
		int row = dao.join(dto);
		logger.info("insert row = "+row);
		
		String msg = "회원 가입에 실패 했습니다";
		String page ="joinForm";
		
		if (row>0) {
			msg = "회원 가입에 성공 했습니다";
			page = "result";
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg); //데이터를 전달 
		mav.setViewName(page); //페이지를 전달
		
		return mav;
	}

	public ModelAndView list(Map<String, String> params) {
		
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = dao.list(params);

		String msg = params.get("keyword")+"에 대한 검색 결과가";
		
		if (list != null || list.size()>0) {
			logger.info("size : ",list.size());
			msg +=list.size()+"건 습니다";
		}else {
			msg +="없습니다";
		}
		
		logger.info(msg);
		
		mav.addObject("msg",msg);
		mav.addObject("list",list);
		mav.setViewName("list");
		
		return mav;
	}

	public ModelAndView multi(List<String> name) {
		ModelAndView mav = new ModelAndView("list"); //바로 리스트 페이지로 보낼수 있다
		List<MemberDTO> list = dao.multi(name);
		mav.addObject("list",list);
		return mav;
	}

	public ModelAndView update(Map<String, Object> param) {
		ModelAndView mav = new ModelAndView("result");
		int row = 0;
		row = dao.update(param);
		
		String msg = param.get("id")+"에 대한 정보를 수정 했습니다";
		if (row<1) {
			msg = param.get("id")+"에 대한 정보를 실패 했습니다";
		}
		 mav.addObject("msg"+msg);
		return mav;
	}

}
