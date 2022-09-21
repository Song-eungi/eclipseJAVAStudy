package java_study.co.kr.jungbu;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class L13MehodReference {

	public static void main(String[] args) {
		//메소드 참조(람다식을 한번 더 줄여서 작성)
		//"13"->13
		Function<String, Integer> parseInt=(s)->{return Integer.parseInt(s);};
		Function<String, Integer> parseInt2=s-> Integer.parseInt(s);
		Function<String, Integer> parseInt3=Integer::parseInt;
		//컴파일러가 해석할 수 있는 정도의 생략만 가능
		//매개변수가 무조건 존재하고 반환할때 실행되는 함수가 매개변수를 꼭 1개 사용하기 때문에
		System.out.println(parseInt3.apply("99")*3);
		
		//문자열 객체를 equals로 같은지 검사하는 함수 작성
		BiPredicate<String,String> strEquals=(s1,s2)->s1.equals(s2);
		BiPredicate<String,String> strEquals2=String::equals; //메서드 참조는 매개변수를 생략
		
		String str="안녕하세요!";
		String str2=new String("안녕하세요!");
		System.out.println(str==str2); //false
		System.out.println(str.equals(str2));   //true
		System.out.println(strEquals.test(str, str2));   //true
		System.out.println(strEquals2.test(str, str2)); //true
		
		char[] charArr = {'안','녕','하','세','요'};
		String msg = new String(charArr);
		System.out.println(msg);
		
		Function<char[], String> parseStr=(cArr)->new String(cArr);
		Function<char[], String> parseStr2=String::new;
		System.out.println(parseStr.apply(new char []{'고','생','하','셨','습','니','다','!'})+"!");
		System.out.println(parseStr2.apply(new char []{'주','잘','보','내','세','요','!'})+"!");
		
	}
	

}
