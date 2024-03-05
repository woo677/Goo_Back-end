package chap09.ex02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BenchMark {

	public static void main(String[] args) {
		//밴치마크 쓸대없는걸 반복을 한다 (성능테스트)
		//선수 입장
		List<String> arr = new ArrayList<String>();
		List<String> lnk = new LinkedList<String>();
		long startTime =0;
		long endTime =0;
		//준비(데이터를 100개씩)
		for (int i = 0; i <= 100; i++) {
			arr.add("data");
			lnk.add("data");
			
		}
		
		//시간체크
		startTime = System.currentTimeMillis();//현제 시간을ms로 저장한다 
		
		//LinkedList 시작
		for (int i = 0; i <= 100000; i++) {
			lnk.add(55,"add data");
			
		}
		//LinkedList 종료
		//시간체크
		endTime = System.currentTimeMillis();
		//도착시간 - 출발 시간 = 걸린시간
		System.out.println("LinkedList 걸린시간 : "+(endTime-startTime)+"ms");
		

		//시간체크
		startTime = System.currentTimeMillis();//현제 시간을ms로 저장한다 
		//ArrayList 시작
		for (int i = 0; i <= 100000; i++) {
			arr.add(55,"add data");
			
		}
		//ArrayList 종료
		
		//시간체크
		endTime = System.currentTimeMillis();
		//도착시간 - 출발 시간 = 걸린시간
		System.out.println("ArrayList 걸린시간 : "+(endTime-startTime)+"ms");//현제 시간을ms로 저장한다 

	}

}
