package kr.co.gudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// servlet context 에서 해 줬던 설정들을 이 녀석이 해 준다.
// 기본적으로 사용하는 Bean 을 자동 등록 해 준다
// @Component, @Configuration, @Repository, @Controller 등...
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
