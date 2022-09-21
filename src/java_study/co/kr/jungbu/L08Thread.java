package java_study.co.kr.jungbu;

import java.time.LocalTime;
import java.util.Scanner;

public class L08Thread {
	public static void main(String[] args) {
		//스레드: main메소드가 1개 가지고 있다.(순차적 언어 main에 작성한 코드가 순서대로 1개씩 실행 되는 것)
		
		System.out.println("첫번째");
		System.out.println("두번째");
		System.out.println("세번째");
		boolean start = true;
		while (start) { //반복문이 한개의 스레드를  독점하기 때문에 다음 코드는 절대 실행 되지 않는다. 
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(1000); //스레드를 1초동안 대기 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		//sc.nextLine(); 콘솔창에 엔터를 입력하는 것을 대기 => 스레드를 독점
		
		System.out.println("네번째");
		System.out.println("동시에 여러가지 일을 하려면 쓰레드가 여러개 존재해야 한다.");
		
		
	}
}
