
public class ThreeD {

	public static void main(String[] args) {
		
		// royal 아파트는 4개층 4개호 방 3개
		String[][][] royal = new String[4][4][3];
		System.out.println(royal.length+" 층");
		System.out.println(royal[0].length+" 호");
		System.out.println(royal[0][0].length+" 개");
		
		// 2층 3호 2번 방은 "철수의 방"
		royal[2][3][2] = "철수의 방";
		// 0층 0호 0번 방은 "영희의 방"
		royal[0][0][0] = "영희의 방";
		
		// 나머지는 "공실" 로 표기 하세요
		for (int f = 0; f < royal.length; f++) {
			for (int h = 0; h < royal[f].length; h++) {
				for (int r = 0; r < royal[f][h].length; r++) {
					/*
					if(!"철수의 방".equals(royal[f][h][r]) && !"영희의 방".equals(royal[f][h][r] )) {
						royal[f][h][r]  = "공실";
					}
					*/
					if (royal[f][h][r] == null) {
						royal[f][h][r]  = "공실";
					}
				}
			}
		}
		
		
		for (int f = 0; f < royal.length; f++) {
			for (int h = 0; h < royal[f].length; h++) {
				for (int r = 0; r < royal[f][h].length; r++) {
					System.out.println(f+"층 "+h+" 호"+r+" 번방 = "+royal[f][h][r]);
				}
			}
		}

	}

}
