package kr.co.gudi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.gudi.util.LoginChecker;

@Configuration //(콘피크레이션)이 어노테이션이 있어야 설정 클래스로 인식 된다
public class InterCeptorConfig implements WebMvcConfigurer {

	//인터셉터에 등록할 클래스를 가져온다
	@Autowired LoginChecker checker;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		WebMvcConfigurer.super.addInterceptors(registry);

	List<String> excludeList = new ArrayList<String>();
	excludeList.add("/");
	excludeList.add("/join*"); //join 뒤에 뭐가 오든지
	excludeList.add("/login.*");//login. 뒤에 뭐가 오든지
	excludeList.add("/resources/**"); // resources/뒤에 뭐가 오든지  (img, css, js)
	
	// 1. 인터셉터에 등록할 로직 추가
	// 2. 인터셉터에 가로챌 url 패턴 추가
	// 1. 인터셉터에 예외로 둘 url 패턴 추가
	registry.addInterceptor(checker)
		.addPathPatterns("/**")
		.excludePathPatterns(excludeList);
	
	}
	
	
}
