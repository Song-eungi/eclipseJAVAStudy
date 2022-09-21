package java_study.co.kr.jungbu;

import java.time.LocalTime;
import java.util.Scanner;

class Clock implements Runnable {
	//스레드를 생성할 코드 작성//상속 구현
	@Override
	public void run() {
		while(true) {
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} } } }

public class L09MultiTread {
	
	public static void main(String[] args) {
		System.out.println("첫번째");
		System.out.println("두번째");
		System.out.println("세번째");

		Clock clock = new Clock(); //객체 생성
		//Runnable type
		//스레드의 매게변수 타입을 런어블로 제한 (타입의 명확한 언어 특징)
		//타입이 명확한 객체지향 언엉의 장점과 단점
		//장점: 매개변수의 타입이 명확해서 오류가 발생하지 않는다
		//단점: 번거롭다 (상속 구현=>객체 생성 =>매게변수)
		//극복1: 인터페이스를 익명클래스로 구현 ( L10 참고)
		//극복2: 람다식 사용 (추상메소드가 1개만 있는 인터페이스만 사용 가능)
		Thread clockTread = new Thread(); //Thread: 스레드를 run()에 작성된 코드를 생성
		clockTread.start(); //start(): 스레드 생성 하는 함수 
		
		System.out.println("네번째");
		Scanner sc = new Scanner(System.in);
		while (true) {
			String type = sc.nextLine();
			System.out.println("당신이 입력한 값:"+type);
			
		}
	}

}
