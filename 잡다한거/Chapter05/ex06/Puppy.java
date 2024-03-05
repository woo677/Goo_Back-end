package chap05.ex06;


public class Puppy {

		public String name;
		public String goal;

		//mame과 gola은 생성자가 사용되고나면 사라져 버린다
		public Puppy(String name,String goal){
			//그래서 받아온 값을 밖으로 꺼내 줘야 한다
			this.name =name; //여기(클래스)있는 name 에 가져온 name을 대입 한다
			this.goal = goal;
			
		}
		//오버로드 : 과적, 원래는 하나의 이름으로 존재해야 하는데 같은 이름으로 여러개 존재하므로 과적(overload)했다고 표현한다
		//단, 매개변수의 갯수나 데이터 타입이 달라야 한다
		//왜? 다양한 객체화를 지원하기 위해서.(누군가는 초기화를 하고싶지 않을수도,이름만 넣고 싶을수도 있으니깐)
		public Puppy() {//기본 생성자 : 매개변수가 없으므로 가능
			
		}
		
		public Puppy(String name) {//메개변수가 하나만 있으므로 가능
			this.name = name;
		}
		
		/*
		 * public Puppy() {//같은 타입의 매개변수가 1개 있으므로 불가능(위와 타입과 생성자 이름100% 일치)
		 * 
		 * }
		 */
		

}
