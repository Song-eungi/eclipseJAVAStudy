package java_study.co.kr.jungbu;

import java.util.Objects;

class PersonTest {
	String name;
	int age;
	
	public PersonTest(String name, int age) {
		this.name=name; //this 필드 접근자
		this.age=age;	
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) //동일한 객체 인지 
			return true;
		if (obj == null) //객체!=null
			return false;
		if (this.getClass() != obj.getClass()) //타입이 같은지
			return false; //메소드의 return이 실행되면 종료된다.
		PersonTest other = (PersonTest) obj;//부모의 타입을 참조하는 변수를 자식의 타입으로 형변환
		return age == other.age && Objects.equals(name, other.name); //필드가 같은지
	}
	
	
}
public class L02Equals {

	public static void main(String[] args) {
		PersonTest 송은지 = new PersonTest("송은지", 20);
		PersonTest 송은지2 = new PersonTest("송은지", 20);
		PersonTest 송은지3=송은지; //if (this == obj) //동일한 객체 인지 
		System.out.println(송은지==송은지2);         //false
		System.out.println(송은지.equals(송은지2));  //false ==> equals 재정의 ==> true
	}
}
