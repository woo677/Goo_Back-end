package chap09.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		//HashMap은 Map 인터페이스를 구현받기 때문에 Map에 들어갈 수 있다.(다형성 더 큰 형태로 들어갈 수 있는 것-> 필드 변수에 해당 )
		Map<String, Integer> map = new HashMap<String, Integer>();//key는 무조건 string v
			//데이터 추가 : add() 가 아닌 put()
				map.put("kim", 23);
				map.put("lee", 26);
				map.put("park",26);// 값의 중복은 상관 없음
				map.put("kim", 30); //key의 중복은 기존것을 덮어 쓰게 된다. set은 중복 안받음 
				
				System.out.println(map);
				
				//크기 알아보기
				System.out.println("map의 크기 :"+map.size());
				
				//단일 값 호출
				System.out.println("lee의 값:"+map.get("lee"));
				
				//삭제(삭제 후 삭제한 값을 보여준다.)
				System.out.println("lee 지워 보기:"+ map.remove("lee"));
				
				//map 의 값을 하나씩 빼기 1 (2.2 코드리뷰 주제)
				//map 에서 key만 set 덩어리로 가져온다. -> 하나씩 꺼낼 수 있도록 iterator 화 한다. -> 하나씩 가져온 키에 맞는 값을 찾는다. 
				
				Set<String> keySet = map.keySet();////보라색 자바 유틸 Set 
				Iterator<String> iter = keySet.iterator();//보라색 자바 유틸 Iterator 키셋을 이터레이터로쪼갬 
				
				while(iter.hasNext()) {// 값이 있니?  hasnext 메소드를 사용 
					String key = iter.next();//키 스트링키 변수 넣어주고 이터넥스트를 선언해서 
					System.out.println(key+":"+map.get(key)); //키에 맞는(대응하는) 값 찾아오기 
				}
				
				//셋형태로 키만 뽑아주겟다  셋도 자바 유틸 키는 스트링으로 잡아놈 스트링형태->키셋
				//이런 매개변수가 들어간다 반환하는구나를  자바 잘 할려면 메소드api를 잘 봐야함 
				
				/*
				//map 의 값을 하나씩 빼기 2
				//향상된 for 를 이용해 set의 내용을 하나씩 뽑는다. -> 키를 이용해 값을 찾는다. 
				for (String key : map.keySet()) {
					System.out.println(key+ " : "+map.get(key));// 키에 맞는 값 찾아오기 (1or3번 코드리뷰 뭐가나올지모름)
					//향상된 for문을 하나씩 뽑아내는것 키 값만 가져오면됨 
				}
				
				
				*/
				//map 의 값을 하나씩 빼기 3 ,키 , 밸류 한 쌍을 Entry 라고 부른다.  K:V -> entry 3번째문제는 가로로 자르겠다는 의미 	
				//Entry(key:value) 형태로 Set을 만든다. -> iterator 화 한다. -> 꺼내온 Entry 로 부터 키와 값을 꺼낸다. 
				Set<Entry<String, Integer>> entrySet = map.entrySet(); //엔트리 형태로 Set을 만든다. 
				Iterator<Entry<String, Integer>> iterator = entrySet.iterator(); //자르기 좋게 Iterator 화 시킨다. 
				
				while(iterator.hasNext()) { // 있나?
					Entry<String, Integer> entry = iterator.next(); //엔트리를 뽑아냄
					System.out.println(entry.getKey()+" : "+entry.getValue()); //엔트리에서 키와 값으로 분리 
				}
				
				
				
				
				
				
				}
				
	}


