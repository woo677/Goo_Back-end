package kr.co.gudi.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling //이러면 스케줄러로 인식한다
@Component //서비스가 아니라서
public class SchedulerUtil {
	
	// 스케쥴러는 프로그램과 생명주기를 함께 한다
	// 켜질때 같이 켜지고, 꺼질때 같이 꺼진다.(도중에 끄는 방법 없음)
	
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/*
	@Scheduled(fixedDelay = 1000) //애를 써서 타임어를 지정 
	public void fixedDelay() {
		logger.info("이전 작업이 끝나고 1초 후 실행"); //이전 작업이 끝나면 거시서 부터 1초
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
//	@Scheduled(fixedRate = 1000) //애를 써서 타임어를 지정 
//	public void fixedRate() {
//		logger.info("1초 마다 실행"); //무조건 1초
//		try {
//			Thread.sleep(500);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//cronntab
	//초 분 시 일 월 요일 년도(일반적으로 생략)
	// 1 0  0  * *  MON-FRI
	//  몇초부터 / 몇초 까지
	@Scheduled(cron = "0/5 * * * * MON-FRI")
	public void cron() {
		logger.info("5초마다 실행");
	}

}
