package cho2.ex06;

public class Solution {

	public int solution(int n, int k) {
		int yang = n*12000;//양꼬치 가격
		int drink = k*2000;//음료 가격
		int free = (n/10)*2000;//무료 음료가격
        int answer = yang+drink-free;
        return answer;
    }

}
