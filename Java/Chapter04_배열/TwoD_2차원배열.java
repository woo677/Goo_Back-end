
public class TwoD_2차원배열 {

	public static void main(String[] args) {
		
		//arr 아파트 2개층 , 3개 호를 가지고 있다
		int arr[][] = {
				{00,01,02,03,},//0층
				{10,11,12,13}//1층
	};
		//royal 아파트는 4개층 4개호가 있다
		String[][] royal = new String[4][4];
		royal[0][0] = "0층 0호";
		
		//층을 돈다
		
		for (int i = 0; i < royal.length; i++) {//층
			for (int j = 0; j < royal[i].length; j++) {//호
				System.out.println(i+"층"+j+" 호");
				royal[i][j] = i+"층"+j+" 호";
				System.out.println(royal[i][j]);
				
			}
		}
}
}
