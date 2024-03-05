package chap09.ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableMain {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("김철수", 99);
		map.put("박동빈", 80);
		map.put("박은지", 75);
		map.put("신솔빈", 43);
		map.put("한은정", 52);
		map.put("김민지", 100);
		map.put("김윤경", 80);
		map.put("정철수", 99);
		map.put("한은호", 87);
		map.put("최영일", 75);
		
		//contatinsKey(key) : 특정 키가 존재 하는지
		//get(key) : 해당 키에대한 값을 가져와라
		
		boolean contain =   map.containsKey("박은비");
		System.out.println("박은빈이 있다"+contain);
		
		//containsValue(value) : 특정한 값이 존재 하는지
		contain = map.containsValue(99);
		System.out.println("99점 학생이 있나,?" + contain);
		
		//get을 이용하면 키로써 값을 찾을 수 있지만
		//값으로써 키를 찾는 방법은 없다
		//99점 학생은 누구누구 인가?
		
		//값을 꺼냄 -> 값으로 키를 찾아냄
		/*1.학생에 값을 전부 꺼내야 한다
		 *2.꺼낸 학생의 값이 99점 인지 비교한다
		 *3.99점인 학생을 누구인지 (Hash Map(iterator)) 이용 해서 찾는다
		 *4.비교해서 99점인 학생을 찾는다
		 *5.99점인 학생을 출력한다 
		 * */
		
		//1.
		for (String key : map.keySet()) {//.keySet키의 전체 값을 가져온다
			int val =map.get(key); //엔트리 : 키와 값을 각각 뽑아온다
			if (val == 99) {
				System.out.println(val+"점인 학생 : "+key);
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int val =entry.getValue();
			if (val == 99) {
				System.out.println(val+"점인 학생 :"+key);
			}
		}
		
	}

}
