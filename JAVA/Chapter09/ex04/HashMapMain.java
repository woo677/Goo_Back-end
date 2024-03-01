package chap09.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		//HashMap 은 Map 인터페이스를 구현받기 때문에 Map 에 들어갈 수 있다.(다형성)
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 데이터 추가 : add() 가 아닌 put()
		map.put("kim", 23);
		map.put("lee", 26);
		map.put("park", 26);//값의 중복은 상관 없음
		map.put("kim", 30);//키의 중복은 기존것을 덮어 쓰게 된다.
		
		System.out.println(map);
		
		// 크기 알아보기
		System.out.println("map 의 크기 : "+map.size());
		
		// 단일 값 호출
		System.out.println("lee 의 값 : "+map.get("lee"));
		
		// 삭제(삭제 후 삭제한 값을 보여준다.)
		System.out.println("lee 지워 보기 : "+map.remove("lee"));
		
		// map 의 값을 하나씩 빼기 1
		// map 에서 key 만 set 덩어리로 가져온다. -> 하나씩 꺼낼수 있도록 iterator 화 한다. -> 하나씩 가져온 키에 맞는 값을 찾는다.
		Set<String> keySet = map.keySet();
		Iterator<String> iter =keySet.iterator();
		
		while(iter.hasNext()) {// 값이 있니?
			String key = iter.next();// 키
			System.out.println(key+" : "+map.get(key)); // 키에 맞는 값 찾아오기
		}
		
		/* map 의 값을 하나씩 빼기 2
		// 향상된 for 를 이용해 set 의 내용을 하나씩 뽑는다. -> 키를 이용해 값을 찾는다.
		for (String key : map.keySet()) {
			System.out.println(key+" : "+map.get(key)); // 키에 맞는 값 찾아오기
		}
		*/
		// map 의 값을 하나씩 빼기 3
		//Entry(key:value) 형태로 Set 을 만든다. -> iterator 화 한다. -> 꺼내온 Entry 로 부터 키와 값을 꺼낸다.
		Set<Entry<String, Integer>> entrySet = map.entrySet();		// 엔트리 형태로 Set 을 만든다.
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();	// 자르기 좋게 Iterator 화 시킨다.
		
		while(iterator.hasNext()) { // 있나?
			Entry<String, Integer> entry = iterator.next(); // 엔트리를 뽑아냄
			System.out.println(entry.getKey()+" : "+entry.getValue()); // 엔트리에서 키와 값으로 분리
		}
		
		
		
		
		
		
		
		
		
		
	}

}
