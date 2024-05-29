package kr.co.gudi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.NA;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class JsoupService {
	
	Logger logger  = LoggerFactory.getLogger(getClass());

	public ModelAndView getElem(Document doc) {
		ModelAndView mav = new ModelAndView("result");
		
		// 요소를 가져오는 방식은 js 방법과 css 셀렉터 방식이 있다
		// 얘) doc.gatElementById("test");
		//	얘) doc.select("#test");
		// select:Elements -> Element
		// doc : 정보를 가져올 사이트 주소 (div.node-list 요소를 select 한다)
		Elements elems = doc.select("div.node-list");
		logger.info("size : "+elems.size());
		//logger.info("elems : "+elems);
		
		//elems 에서 가져온 값을 elems.get()을 통해 index 0번에 있는 값을 가져온다 
		Element elem = elems.get(0);
		//logger.info("elem : "+elem);
		
		// link, title, description
		//elem에서 ()에 있는 내용을 select 해온다
		Elements cardList = elem.select("div.card");
		logger.info("cardList : "+cardList);
		
		String title = "";
		String link= "";
		String desc = "";
		
		
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> article = null;
		// cardList 에 있는 데이터를 뽑아낸다
		for (Element card : cardList) {
			title = card.select("h5.card-title a").html();
			link = card.select("h5.card-title a").attr("href");
			desc = card.select("p.card-text.crop-text-2").html();
			article = new HashMap<String, String>();
			article.put("title",title);
			article.put("link","https://www.itworld.co.kr"+link);
			article.put("desc",desc.substring(0,50)+"...");
			list.add(article);
			
			logger.info("title = "+title);
			logger.info("link =https://www.itworld.co.kr"+link);
			logger.info("desc = "+desc.substring(0,50)+"...");
		}
		
		
		mav.addObject("elem",list);
		return mav;
	}

}
