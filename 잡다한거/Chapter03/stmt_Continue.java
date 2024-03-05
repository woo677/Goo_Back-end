package default_packege;

public class stmt_Continue {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			if (i%3==0) {
				continue;//이 값을 무시함
			}
			System.out.println(i);
		}

	}

}
