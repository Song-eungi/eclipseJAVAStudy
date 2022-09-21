package java_study.co.kr.jungbu;

import java.util.ArrayList;

public class L01variable extends Object {
	public static void main(String []args) {
		
		//Array배열
		String [] arr = {"a","b","c","d"};
		System.out.println(arr.length);
		//Object.toString(): 객체의 주소(객체에 대한 정보를 재정의 하기를 기대하는 함수)
		//java.lang.Object : 모든 타입의 부모, 모든 객체의 부모
		//(모든 타입이 객체가 될 수 있는 정보를 포함=>class의 생성자를 new 연산자로 호출해서 객체를 생성할 수 있게 해준다.  )
		System.out.println(arr.toString()); 
		
		//List 배열
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		//Object.toSting() 재정의> List.toStirng() : 객체의 설명
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println(list.contains("c")); 
		
		L01variable l01variable = new L01variable();
		//toString은 생략 가능
		System.out.println(l01variable);
		System.out.println(l01variable.toString());
		//@Override : 부모의 필드를 재정의 하는 것을 오버라이드(다형성: 한개의 이름이 역할이 많이 갖는 것)
		//자식은 부모의 모든 필드를 물려 받지만 재정의 된 필드가 우선 순위를 갖는다.
		//오버로드: 메소드 이름이 갖지만 매개변수가 다른 것 (다형성)
		//타입의 다형성 : 한개의 객체가 여러 타입에 참조 가능(다형성)
		String hello ="안녕";
		Object o = hello; //o 변수는 Object 타입의 객체만 참조 가능, 부모가 Object인 객체를 참조가능(타입의 다형성 => 형변환)
		
		//0 정기적 신호가 있음 or 1 전기적 신호가 없음
		//2진수와 16진수 => 1byte(8bit)
		//메모리가 가장 작은 단위는 1bit를 8개씩 1byte로 나눈다
		//-+(부호비트) 7비트 2진수를 표기 2^0 2^1 2^2 2^3 .....2^7 => 수는 약속
		// 5: 4+1 첫번째 비트와 3번째 비트에 전기적 신호를 준다.
		
		//부동소수점으로 표기하는 실수
		//0.005 (고정소수점) ==> 5.0 * 10-3 (부동소수점)
		//+(-): 부호비트
		//5.0: 가수부 4+1 첫번째 비트와 세번째 비트에 전기적 신호를 준다.
		//-3: 지수부 ==> 실수부의 부호비트에 정기적 신호, 1+2 첫번째 비트와 두번째 비트에 전기적 신호를 준다.
		
		byte b; //1byte(8bit)를 참조할 수 있는 정수 
		short s; //2byte를 참조할 수 있는 정수
		//변수 i가 선언됨 (참조할 객체의 타입을 명시)
		int i; //4byte를 참조할 수 있는 정수 (기본 정수)
		long l; //8byte 정수
		char c; //문자표(아스키코드, *유니코드*)의 번호를 참조
		
		//실수를 참조하는 타입
		float f;  // 4byte로 표기하는 실수 float 0.000314 => 3.14 * 10-4(부동소수점)
		double d; // 8byte 실수(기본 실수)
		System.out.println(13.33);//double
		System.out.println(13);//int
		//////////////////////////////////////////////////////////////////////
		i=320000000*320000000;
		System.out.println(i); //-385875968
		
		i=2147483647+1;
		System.out.println(i); //-2147483648 정수 기본 타입은 표현할 수 있는 수보다 큰수를 참조하면 가장 작은 수 부터 나머지를 더한다.
		
		l=9223372036854775807L + 1;
		System.out.println(l); //-9223372036854775808

		
		/////////////////////////////////////////////////////////////////////
		f=13; //13.0
		f=13.123456789123456789f; 
		System.out.println(f); //13.123457 가수부로 표현할수 없는 수는 버린다.(가수부가 작다)
		
		f=13123456789123456789f;
		System.out.println(f);  //1.3123456E19
		
//		f=1312345678912345678912345123123412312312f; //float 지수부로 표현할수없는 수를 참조할 수 없다
		f=13123456734445589123456789f*1312345678453345359123456789f; 
		System.out.println(f); //float로 참조하기에 큰수는 Infinity 반환
		
		d=13.123456789123456789; 
		System.out.println(d); //13.123456789123457
		
		d=13123456734489.0*-1312345678789.0; 
		System.out.println(d); //-1.722251173628104E25
		
		d=131234524234543212349999999999999999999999999999999999999999999999999999999999999999995432345543243999999999999999999999999999999999999999999999999999999943456734489.0*-131232334324344345432345432111199999999999999999999999999999992399999999999999999999654345456789876543123223123543445678789.0; 
		System.out.println(d); //Infinity
		
		//javascript의 Number는 java double과 같다
		
		boolean bool=true; //true: 1  false:0 = 1bit data => 자바에서는 8bit를 사용함(메모리를 1byte로 구성(참조하는 주소가 바이트 단위)하기 때문에)
		
		//상수
		final int I=20;
		//I=1; 최초 선언된 값 외의 data를 참조 할 수 없다.
		//(기본형 data를 값이라 부른다. 객체라 불러도 큰 문제는 없으나 객체를 참조형 data로 구분하는 사람들이 있음)
		System.out.println(I);
		Integer objI = new Integer(20); //java는 기본형을 참조형으로 선언하는 것을 권장하지 않음
		System.out.println(I==objI); //false(x) => true
		
		String objStr = new String("안녕");
		String literalStr = "안녕";
		String literalStr2 = "안녕";
		System.out.println(objStr==literalStr); //false
		System.out.println(literalStr=literalStr2); //true //문자열은 참조형 data(객체)는 동등 비교를 할 수 없다.
		
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println(obj==obj2); //false
		
		//== 동등비교가 비교하는 것!!!! ★
		//1.객체가 같은 것인지 비교[참조형은 선언할때 마다 새로운 객체를 만들기 때문에 무조건 false]
		//2.값이 같은지 비교(깂은 기본형 => 수 => 수가 같은지)
		
		System.out.println(20==20.0); //기본형: 값을 비교 true
		System.out.println(new String("안녕")==new String("안녕")); //참조형: 주소를 비교(완전히 같은 객체인지 비교) false
		//참조형 중에 String만 예외: 문자열을 리터럴하게 선언시 기본형 처럼 새로운 데이터를 만들지 않고 기존의 데이터를 참조한다. 리터럴하게 선언한 두 문자열은 완전히 같은 객체
		System.out.println("안녕"=="안녕");//true 
		//참조형을 비교연산 하는 방법 ?? Object.equals(obj) 서로 다른 두 객체가 같으려면 필드가 완전히 같아야 한다(주관적으로 필드의 범위를 지정가능) => 재정의해야 가능
		//String은 equlas를 재정의 하고 있다.
		//리터럴하게 선언된 문자열도 참조형 데이터 이다. 
		//문자열의 동등 비교를 권장하지 않는다. (참조형을 동등비교 할 수 있나요? 왜 안되나요? 문자열을 비교하던데, 참조는 주소가 같은 것만 비교가 가능)
		System.out.println(new String("안녕").equals(new String("안녕"))); //true
		
		
		
	}
	//
	public void print() {}
	public void print(int i) {}
	public void print(String s) {}
	public void print(String s, String s2) {}
	public void print(double d) {}
	public void print(char c) {}
	public void print(Object o) {}
	public void print(float f) {}
	
	@Override //모든 class는 Object를 자동으로 상속하기 때문에 toString을 재정의 할 수 있다.
	public String toString() {
		return "변수에 대한 수업 입니다.";
	}
}
