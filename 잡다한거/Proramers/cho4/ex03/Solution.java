package cho4.ex03;

import java.util.Iterator;

public class Solution {

	public int[] solution(int money) {
        int[] answer = {0,0};
        
        //몇잔의 커피를 살 수 있나? ->나누기
        answer[0]=money/5500;
        //얼마가 남는가?->나머지
        answer[1]=money%5500;
        
        System.out.println(money);
        return answer;
        
        
//        아이스 아메리카노는 한잔에 5,500원입니다. money-5.500
//        머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때
//        머쓱이가 최대로 마실 수 있는 아메리카노의 잔 수와
//        남는 돈을 순서대로 담은 배열을 return 하도록 solution 함수를 완성
    }

}
