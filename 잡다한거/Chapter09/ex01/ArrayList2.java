package chap09.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList2 {

	//배열을 ArrayList 에 옮기고 싶을떄
	public static void main(String[] args) {
		//Array ->List ->ArrayList
		
		//Array ->List 
		String[] arr = {"List","Map","Set"};
		List<String> list = Arrays.asList(arr);
		System.out.println(list.size());
		System.out.println(list.get(1));
		//list.add("Collection");//Array를 List로 변환하고 나면 수정은 불가능 하다.
		
		//List -> ArrayList
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.addAll(list);
		arrList.add("collection");
		System.out.println(arrList);

	}

}
