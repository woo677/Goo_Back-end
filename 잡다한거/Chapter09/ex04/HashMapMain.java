package chap09.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class HashMapMain {

	public static void main(String[] args) {
		//예는 기존에 애들과는 떨어져 있다
		//HashMap 은 Map 인터페이스를 구현 받기 때문에 Map 에 들어갈 수 있다(다향성)
		//Map<K, V>K: 키 v:벨류의 약자
		Map<String, Integer> map = new HashMap<String, Integer>();
		//데이터 추가: add()가 아닌 put()
		map.put("kim", 23);
		map.put("lee", 26);
		map.put("park", 26);//값의 중복은 상관이 없다
		map.put("kim", 30);//키의 중복은 기존것을 덮어 쓰게 된다
		
		System.out.println(map);//공식적인 방법은 아님 개발자들이 개발 할때만 쓴다
		
		
		//크기 알아보기
		System.out.println("map 의 크기 : "+map.size());
		//단일 값 호출
		System.out.println("lee 의 값 : "+map.get("lee"));
		//삭제(삭제 후 삭제한 값을 보여 준다)
		System.out.println("lee 지워진 값 보기 : "+ map.remove("lee"));
		
		//코드리뷰
		//중요 꼭 알아야 함
		
		//map 의 값을 하나씩 빼기 1 (코드리뷰O)
		//map 에서 Key 만 set 덩어리러 가져온다 -> 하나씩 꺼낼수 있도록 iterator화 한다-> 하나씩 가져온 키에 맞는 값을 찾는다
		
		Set<String> keySet = map.keySet();//키의 값을 반환한다 (값이 있니?)
		Iterator<String> iter = keySet.iterator(); //키의 값을 하나씩 쪼겔때 쓰 인다(키)
		while (iter.hasNext()) {//키에 값 하나를 가져온 다음 키에 맞는 값을 찾아온다 
			String key = iter.next();
			System.out.println(key+" : "+map.get(key));
		}
		
		//하나 키의 값을 가져 온 다음   

//-------------------------------------------------------------------------------------------------------------------------
		
		
		//map 의 값을 하나씩 빼기 2 (얘를 가장 많이 쓴다) (코드리뷰X)
		//향상된 for를 이용해 set 의 내용을 하나씩 뽑는다 -> 키를 이용해 값을 찾는다
		for (String key : map.keySet()) {//위에 있는 3줄 불량
			System.out.println(key+" : "+map.get(key));
		}
		
//-------------------------------------------------------------------------------------------------------------------------		
		
		//map 의 값을 하나씩 빼기 3 (코드리뷰O)
		//Entry 키와 벨류 한 쌍을 엔트리라고 한다
		//Entry(key:value) 형태로 Set을 만든다 -> iterator화 한다 -> 꺼내온 Entry 로 부터 키와 값을 꺼낸다
		Set<Entry<String, Integer>> entrySet = map.entrySet();//엔트리 형태로 Set을 만든다
		Iterator<Entry<String, Integer>> iter1 = entrySet.iterator();//자르기 좋게 Iterator화 시킨다
		
		while (iter1.hasNext()) {//있나?
			Entry<String, Integer> entry = iter1.next();//인드리를 뽑아냄
			System.out.println(entry.getKey()+" : "+entry.getValue());//엔트리에서 키와 값으로 분리
		}
	}

}
