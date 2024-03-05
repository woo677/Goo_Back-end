
public class One {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		
		x++;//증가 나중에
		++y;//증가 먼저
		System.out.println("x="+x);
		System.out.println("y="+y);
		
		x=1;
		y=1;
		int result1=(++x)+10;//1+10 x가 먼저 증가->2,10 을 더하면=12
		int result2=(y++)+10;//1+10 y가 10을 더해서 11, 이후 y는 1증가해서 2
		System.out.println("result1 = "+result1);
		System.out.println("result2 = "+result2);
		
		//++ 가 뒤에 붙는다.(아령들고 나서 1개)->카운트에 주로 활용
		//++가 앞에 붙는다.(증가한 내용을 이용해 다른행동을 할 때)
		
		//반전 연산(! not)
		boolean yn = true;
		System.out.println("yn= "+yn);
		
		yn=!yn;
		System.out.println("!yn= "+yn);
		
		yn=!yn;
		System.out.println("!yn= "+yn);
	}

}
