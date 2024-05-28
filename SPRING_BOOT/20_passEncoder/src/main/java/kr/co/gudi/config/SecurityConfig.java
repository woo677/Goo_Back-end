package kr.co.gudi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//암호와 부분 빈 등록
	@Bean
	public PasswordEncoder getPasswordEncoder() { //PasswordEncoder : 이름으로 불러서 씀
		return new BCryptPasswordEncoder();
	}
	
	// 스프링 시큐리티에는 로그인 기능등 많은 기능들이 있지만
	// 우리는 암호화만 사용할 것 이므로, 기본적인 다른 기능들은 모두 비활성화(disable) 한다
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//csrf 토큰(csrf 공격을 막기 위한 방법) : 특정 사이트에서 보낸 사이트 요청이 맞아?
		// Cross Site Request Forgery : 다른 사이트에서 내가 요청하지 않은 내용을 요청하게 하는 해킹 방법
		// 이를 막기 위해 csrf 토클을 발행하여 내 서버에 해당하는 페이지의 요청인지 확인한다.(본인확인 비슷한것)
		// 그래서 jsp 에서 요청을 보낼때 시큐리티에서 토큰을 요청하고, jsp 에서 주지 못하므로 403(권한 없음) 에러를 보내게 된다
		http.httpBasic().disable().csrf().disable();
		return http.build();
	}
	
}
