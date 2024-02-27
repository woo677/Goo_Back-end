// 45.

public class ThreeD {

	public static void main(String[] args) {
		
		// royal 아파트 4개 층, 4개 호, 방 3개
		String[][][] royal = new String[4][4][3];
		
		System.out.print(royal.length+"층 ");
		System.out.print(royal[0].length+"호 ");
		System.out.println(royal[0][0].length+"방 ");
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++"+"\n");
		
		// 2층 3호 2번 방은 "철수의 방"
		// 0층 0호 0번 방은 "영희의 방"
		// 나머지는 공실
		
		for (int i = 0; i < royal.length; i++) {
			for (int j = 0; j < royal[i].length; j++) {
				for (int k = 0; k < royal[i][j].length; k++) {
					/*
					 * royal[2][3][2] = "철수의 방";
					 * royal[0][0][0] = "영희의 방";
					 * if(!"철수의 방".equals(royal[i][j][k]) && !"영희의 방".equals(royal[i][j][k])) {
					 *     royal[i][j][k] = "공실";
					 * }
					 * System.out.println( i+"층 "+j+"호 "+k+"방: "+royal[i][j][k]);
					 */
					/*
					 * if(royal[i][j][k] == null) {
					 *     royal[i][j][k] = "공실";
					 * }
					 */
					royal[i][j][k] = "공실";
					
					if (royal[i][j][k] == royal[2][3][2]) {
						royal[2][3][2] = "철수의 방";
					} else if (royal[i][j][k] == royal[0][0][0]) {
						royal[0][0][0] = "영희의 방";
					} 
					
					System.out.println(i+"층 "+j+"호 "+k+"방 "+royal[i][j][k]);
				}
				System.out.println();
			}
			System.out.println("+++++++++++++++++++++++++++++"+"\n");
		}

	}

}
