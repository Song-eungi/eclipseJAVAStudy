package java_study.co.kr.jungbu;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Fun<T,R> {
	R apply(T t) ;
}

public class L12Lamda {

	public static void main(String[] args) {
		// function() { } 함수 =>프로토타입(타입), class(문법적 설탕==function), ()=>{ } 람다식 함수(타입이 존재하지 않는)
		// js: function Calc(a,b) {this.a=a;this.b=b; this.sum=function()} let cal = new Calc();
		
		// JAVA{객체지향언어) 람다식: 함수가 하나 있는 객체의 매게변수 대신 간편하게 작성하는 문법적 설탕
		//Function은 매개변수가 하나 있고 반환하는 것이 있는 함수
		Function<Integer, Long> square=(i)->{return (long)i*i;};  
		Function<Integer, Long> square2=new Function<Integer, Long>() {
			@Override
			public Long apply(Integer t) {
				long result=t*t;
				return result;
			}
		};
		BiFunction<Integer, Integer, Long>sum=(i,i2)->{return (long)(i+i2);};
		System.out.println(sum.apply(40, 100));
		Consumer<Integer> squarPrint=(i)->{System.out.println(i*i);}; //매게변수 1개만 존재하는 함수
		squarPrint.accept(133);
		//Predicate(검사식): 매개변수와 반환하는 값이 있는데 반환하는 값의 타입은 무조건 boolean
		Predicate<String> nullCheck=(s)->{return s!=null;};
		//Supplier: 반환하는 것만 있는 함수 정의
		Supplier<Integer> reandomNum=()->{return (int) (Math.random()*10) + 1;}; //1~10까지 랜덤 한 수를 반환하는 함수
		System.out.println(reandomNum.get());
		System.out.println(reandomNum.get());
		System.out.println(reandomNum.get());
		//BinaryOperator(연산하는 함수): 매게변수가 2개고 반환하는 것이 있으며 매개변수와 반환 값의 타입이 같은것
		BinaryOperator<Integer> sum2=(i,i2)->i+i2; //한줄뿐이면 return 바디 생략 가능
		Predicate<String> nullCheck2=s->s!=null; // 매개변수가 한개일때도 가로 생략 가능
		System.out.println(sum2.apply(20, 30)); 
		
		//코드의 길이가 줄어들면 가독성 +시간 절약
	}

}















