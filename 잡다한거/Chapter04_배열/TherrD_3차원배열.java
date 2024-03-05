
public class TherrD_3차원배열 {

	public static void main(String[] args) {
		
		// royal 아파트는 4개층 4개호 방3개
		
		String[][][] royal = new String[4][4][3];
		System.out.println(royal.length);//총 몇층
		System.out.println(royal[0].length);//총 호층
		System.out.println(royal[0][0].length+"\n");//총 방갯수
		
		//2층 2호 2번방은 "철수의 방"
		
		royal[2][3][2] = "철수의 방";
		//0층 0호 0번방은 "영희의 방"
				
		royal[0][0][0] = "영희의 방";
		
		//나머지는 "공실" 로 표기 하세요
		
		for (int i = 0; i < royal.length; i++) {//층
			for (int j = 0; j < royal[i].length; j++) {//호
				for (int k = 0; k < royal[i][j].length; k++) {//방
					if (royal[i][j][k]==null) {
						royal[i][j][k] = "공실";
					}
					System.out.println(i+"층"+j+"호"+k+"방 "+royal[i][j][k]);
					}
				}
			}
		
		
	}
}

