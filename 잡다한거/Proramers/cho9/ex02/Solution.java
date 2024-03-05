package cho9.ex02;

import java.util.HashMap;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        
//        //1. 배열 확인 : 0.11ms ~ 0.17ms
//        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
//        
//        for (int i = 0; i < arr.length; i++) {
//		 numbers = numbers.replace(arr[i], String.valueOf(i));
//			System.out.println(numbers);
//		}
        
//        2.HashMap 0.40ms ~ 0.79ms
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for (String key : map.keySet()) {
        	 numbers = numbers.replaceAll(key, map.get(key));
		}
        
        answer = Long.parseLong(numbers);
        
        return answer;
    }
}