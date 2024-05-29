package kr.co.gudi.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Element;

@Service
public class MainService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	//selenium 사용 하기전 설정
	String dricer_id = "webdriver.chrome.driver"; //DB 접속할때 dricer-class 랑 같다
	String dricer_path = "C:/chromedriver.exe";// selenium 가 설지 된 곳 지정
	
	WebDriver driver = null; //커넥션이고 비슷한 놈이다
	ChromeOptions options = null; //크로에 설정을 건드릴수 있다
	
	
	//MainService 가 호출되는 시점에 selenium 가 자동으로 싫행 하게 한다
	// setProperty : 프로그램 시스템에 속성을 지정할때 쓴다
	public MainService() {
		logger.info("등록");
		System.setProperty(dricer_id, dricer_path);
		options = new ChromeOptions();
		//다른 사이트 접근 이 가능하도록 설정 추가(원격,허용(도메인이 다르더라도..))
		options.addArguments("--remote-allow-origins=*");
	}

	
	
	public ModelAndView connect() {
			
		//드라이버 생성
		driver = new ChromeDriver(options);
		//url을 호출
		driver.get("https://www.naver.com");
		//페이지를 가져온다.
		String result = driver.getPageSource();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("elem",result);
		//driver.close(); //브라우저 닫기
		
		return mav;
	}



	public ModelAndView getElem() 
			throws InterruptedException {		
		// 1. 드라이버 생성
		driver = new ChromeDriver(options);
		// 2. url 호출
		driver.get("https://softeer.ai/careers/jobopening?_closed=true&page=1");
		driver.manage().window().maximize();	// 창 최대크기로 맞춰 놓기(반응형 웹의 경우 창에 크기에 따라 사이트의 구조가 달라지므로...)	
		// 셀레니움은 실제 브라우져를 켜서 작업하기 때문에 중간중간 딜레이 시간을 줘야 한다.
		Thread.sleep(500);
		
		// 원하는 내용 가져오기
		// By.cssSelector("#test")		
		// findElement : 웹사이트에 특정 요소를 사용 할 때 사용한다
		// WebElement : 웹 패이지에 있는 여러가지 요소들과 상호작용 할 수 있다
		List<WebElement> list = driver.findElements(By.cssSelector("div.item-list"));
		
		for (WebElement elem : list) {
			//logger.info("elem : {}",elem);
			WebElement aTag = elem.findElement(By.cssSelector("a"));
			String link = aTag.getAttribute("href");
			String title = aTag.findElement(By.cssSelector("p.item-tit")).getText();
			String company = aTag.findElement(By.cssSelector("div.item-status i")).getText();
			
			List<WebElement> dl = aTag.findElements(By.cssSelector("div.item-info dl.item__data"));
			String status = dl.get(0).findElement(By.cssSelector("dt")).getText();		
			
			logger.info("link="+link);
			logger.info("title="+title);
			logger.info("company="+company);
			logger.info("status="+status);
			
			for(int i=1; i<dl.size();i++) {
				String key = dl.get(i).findElement(By.cssSelector("dt")).getText();	
				String val = dl.get(i).findElement(By.cssSelector("dd")).getText();	
				logger.info(key+"="+val);
			}			
			
			logger.info("*************************************************");
		}
			
		String result = "";		
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("elem", result);
		return mav;
	}



	public void event() throws InterruptedException {
		
		driver = new ChromeDriver(options);
		driver.get("https://gdlms.cafe24.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(500);
		
		List<WebElement> list = driver.findElements(By.cssSelector("table tr.bg-white td"));
		list.get(2).click();
		
		driver.findElement(By.name("strUid")).sendKeys("아이디");
		driver.findElement(By.name("strPassword")).sendKeys("비밀번호");
		driver.findElement(By.name("mode")).click(); // click() 을 해도 상관 없음
		
		//javascript 구문 넣기(스크립트 해킹용도)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('강제 로그인 성공!!');");
		
	}

}
