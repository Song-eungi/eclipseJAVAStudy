package java_study.co.kr.jungbu;

enum E{ //열거형 E
	
}

@FunctionalInterface //추상 메서드를 꼭 1개 정의해야 한다.
interface C { //type C
	public void print(); // 추상 메소드만 정의할 수 있다.
//	void printb();
}

abstract class B { //type B
	abstract public void print(); //추상 메소드를 정의할 수 있다.
	
}

class A{ //A type
	
}

public class L03Type {
	//static 필드: jvm이 코드를 실행할떼 static으로 정의된 변수를 메소드 영역에서 생성(보통 상수를 선언)
	public static int I=13; //상수: 메소드 영역에 저장되는 static 필드(변하지 않는 정보)
	
	 class InClass extends B {
		@Override
		public void print() {}
	}
	public static void main(String [] args) {
		final int I =13; //상수: (지역에서 사용되는 바뀌지 않는 상수)
		System.out.println(Integer.MAX_VALUE); //static 필드로 정의된 상수 
		A a=new A();
		//B and c 인터페이스와 추상클래스는 추상메서드가 있기 때문에 객체로 만들 수 없음.
		//but 객체로 만드는 방법
		 B b = new B() { 
			 //생성과 동시에 추상메서드를 구현하면 객체로 생성할 수 있다. 
			 // 이때 이너 클래스가 생성되는데 숫자로 정의된 익명 클래스가 만들어진다.
			 public void print() {}
		 };
		 C c = new C() { //생성과 동시에 추상메서드를 구현하면 객체로 생성할 수 있다.
			 @Override
			public void print() {}
		 };
		 //static을 사용했을 경우 
		 //B b2 = new InClass();
		 //static을 사용하지 않앗을 경우  
		 B b2 = new L03Type().new InClass();
		 
		 
		
		//람다식: 함수형 언어(함수가 객체)를 표방한 화살표함수로 작성된 객체(*자바에서는 함수가 객체될 수 없다.)
		//자바에서 람다식을 작성하기 위해서는 인터페이스에 추상메서드가 1개 있을 경우 가능
		//사용하는이유? 
		//배경:자바에서 함수를 매개변수로 사용할 수 없기 때문에 함수를 매개변수로 사용하려면 꼭 타입을 정의해야한다.
		//해결:이것을 간편하게 하기 위해서 람다식을 사용
		//자바에서 함수를 객체로 사용(X) 문법적 설탕(함수형 언어인 척)
		 
		C c2 =()->{}; //인터페이스에 ★추상메서드가 1개 있을 경우★ 람다식으로 객체를 생성할 수 있다.(함수형 언어 방식)
		 

	}

}
