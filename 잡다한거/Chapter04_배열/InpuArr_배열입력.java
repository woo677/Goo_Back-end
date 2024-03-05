
public class InpuArr_배열입력 {

	public static void main(String[] args) {
		
		//10개 짜리 방 생성
		int[] scores = new int[10];
		
		System.out.println("크기 "+scores.length);//랭스
		//0번 방에 10
		scores[0] =10;
		
		//1번 방에 50
		scores[1] = 50;
		
		//2번 방에 70
		
		scores[2] = 70;
		
		//3번방 부터 끝까지 100 씩 넣기
		scores[3] = 100;
		scores[4] = 100;
		scores[5] = 100;
		scores[6] = 100;
		scores[7] = 100;
		scores[8] = 100;
		scores[9] = 100;
		
		for (int i = 3; i < scores.length; i++) {
			//System.out.print("로그 확인= "+i+", "+i);//로그를 반드시 찍어 봐서 내용을 확인을 해봐라!!!
			scores[i] =100;
		}

	}

}
