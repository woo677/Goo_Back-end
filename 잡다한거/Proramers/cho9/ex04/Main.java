package cho9.ex04;

public class Main {

	public static void main(String[] args) {
		 
		Solution sol = new Solution();
		boolean result =true;
		
		result = sol.solution("()()");
		System.out.println("   == "+result);
		
		result = sol.solution("(())()");
		System.out.println(" == "+result);
		
		result = sol.solution(")()(");
		System.out.println(" == "+result);

		result = sol.solution("(()(");
				System.out.println(" == "+result);


				
				
		
	}
	

}
